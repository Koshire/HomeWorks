package com.itacademy.akulov.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.nio.file.StandardOpenOption.CREATE;

public class FileParser {

    public static List<Event> getEventsList(Path path) throws IOException {
        List<Event> list = new ArrayList<>();
        int day = 1;
        BufferedReader reader = Files.newBufferedReader(path);
        String regexp = "^([0|1|2]\\d:\\d{2})\\s([А-Яа-яЁёA-Za-z,!.:;\\s]+)";
        Pattern re = Pattern.compile(regexp);
        while (reader.ready()) {
            String line = reader.readLine();
            Matcher matcher = re.matcher(line);
            if (matcher.find()) {
                list.add(new Event(day, matcher.group(1), matcher.group(2)));
            } else {
                day++;
            }
        }
        for (int i = 1; i < list.size(); i++) {
            if (!list.get(i - 1).getGroup().equals(GroupsConst.GROUP_END)) {
                list.get(i - 1).setEndTime(list.get(i).getStartTime());
            }
        }
        return list;
    }

    public static void writeEvents(Path path, List<Event> list) throws IOException {
        Files.write(path, list.stream().map(Event::toEventString).collect(Collectors.toList()), CREATE);
    }

    public static void writeGroupEvents(Path pathToRead, Path pathToWriteGroups) throws IOException {
        List<Event> list = FileParser.getEventsList(pathToRead);
        double sumTime = list.stream().mapToDouble(Event::getDuration).sum();
        StringBuilder stringBuilderCommon = new StringBuilder();
        StringBuilder strBuilderDivided = new StringBuilder();
        Map<String, Double> tempMap = new TreeMap<>();
        String[] groups = {GroupsConst.GROUP_THEORY, GroupsConst.GROUP_PRACTICE, GroupsConst.GROUP_RESULTS,
                GroupsConst.GROUP_RELAX};
        for (String tempGroup : groups) {
            double tempSum = list.stream().filter(value -> value.getGroup().equals(tempGroup))
                    .mapToDouble(Event::getDuration).sum();
            stringBuilderCommon.append(String.format("%s: %.0f минут %.0f%% %n", tempGroup, tempSum,
                    tempSum / sumTime * 100));
            strBuilderDivided.append(tempGroup).append(": ").append(System.lineSeparator());
            List<Event> collect = list.stream().filter(value -> value.getGroup().equals(tempGroup))
                    .collect(Collectors.toList());
            collect.forEach(value -> tempMap.merge(value.getDescription(), value.getDuration(),
                    (oldValue, newValue) -> oldValue + newValue));
            tempMap.forEach((key, value) -> strBuilderDivided.append(key).append(": ").append(String.format("%.0f", value))
                    .append(" минут ").append(String.format("%.0f", value / tempSum * 100)).append("%")
                    .append(System.lineSeparator()));
            strBuilderDivided.append(System.lineSeparator());
            tempMap.clear();
        }
        String stringToWrite = stringBuilderCommon.toString() + System.lineSeparator() + strBuilderDivided.toString();
        Files.write(pathToWriteGroups, stringToWrite.getBytes(Charset.defaultCharset()), CREATE);
    }
}



