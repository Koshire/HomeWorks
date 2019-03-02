package com.itacademy.akulov.regex;

import lombok.Getter;
import lombok.Setter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
public class Event {

    private int day;
    private String startTime;
    private String endTime = "";
    private String description;

    public Event(int day, String startTime, String description) {
        this.day = day;
        this.startTime = startTime;
        this.description = description;
    }

    public double getDuration() {
        int result = 0;
        String regexp = "^([0|1|2]\\d):(\\d{2})$";
        Pattern re = Pattern.compile(regexp);
        Matcher matcherFirstTime = re.matcher(startTime);
        Matcher matcherSecondTime = re.matcher((endTime));
        int firstMinutes = 0;
        int secondMinutes = 0;
        if (matcherFirstTime.matches() && matcherSecondTime.matches()) {
            firstMinutes = Integer.parseInt(matcherFirstTime.group(1)) * 60
                    + Integer.parseInt(matcherFirstTime.group(2));
            secondMinutes = Integer.parseInt(matcherSecondTime.group(1)) * 60
                    + Integer.parseInt(matcherSecondTime.group(2));
            result = secondMinutes - firstMinutes;
        }
        return result;
    }

    public String getGroup() {
        int result = 0;
        String group = "";
        String[] expression = {"[Пп]ерерыв", "[Уу]пражнени[яе]",
                "[Рр]ешени[яе]", "[Кк]онец", ".*"};
        for (int i = 0; i < expression.length; i++) {
            Pattern re = Pattern.compile(expression[i]);
            Matcher matcher = re.matcher(description);
            if (matcher.find()) {
                result = i;
                break;
            }
        }
        switch (result) {
            case 0:
                group = GroupsConst.GROUP_RELAX;
                break;
            case 1:
                group = GroupsConst.GROUP_PRACTICE;
                break;
            case 2:
                group = GroupsConst.GROUP_RESULTS;
                break;
            case 3:
                group = GroupsConst.GROUP_END;
                break;
            default:
                group = GroupsConst.GROUP_THEORY;
                break;
        }
        return group;
    }

    public String toEventString() {
        String result;
        if (!getGroup().equals(GroupsConst.GROUP_END)) {
            result = startTime + "-" + endTime + " " + description;
        } else {
            result = startTime + " " + description + System.lineSeparator();
        }
        return result;
    }
}
