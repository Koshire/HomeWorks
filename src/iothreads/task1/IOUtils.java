package iothreads.task1;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public final class IOUtils {

    private IOUtils() {
    }

    private static Map<Character, Integer> readService(Path path) throws IOException {
        Map<Character, Integer> resultMap = new TreeMap<>();
        try (BufferedReader in = new BufferedReader(new FileReader(path.toFile()))) {
            while (in.ready()) {
                addToMap(resultMap, clearString(in.readLine()));
            }
            return resultMap;
        }
    }

    public static boolean letterQuantity(Path pathToRead, Path pathToWrite) throws IOException {
        boolean result = false;
        if (checkFile(pathToRead) && checkFile(pathToWrite)) {
            try (BufferedWriter out = new BufferedWriter(new FileWriter(pathToWrite.toFile(), false))) {
                List<String> list = readService(pathToRead).entrySet().stream()
                        .map(characterIntegerEntry -> characterIntegerEntry.getKey() + " - "
                                + characterIntegerEntry.getValue()).collect(Collectors.toList());
                out.write(String.join("\n", list));
                out.flush();
            }
            result = true;
        }
        return result;
    }

    private static boolean checkFile(Path path) {
        return path.toFile().exists() && path.toFile().isFile();
    }

    private static String clearString(String stringValue) {
        return stringValue.replaceAll("[,.!—?;:…\\-\\s+]", "")
                .toLowerCase();
    }

    private static void addToMap(Map<Character, Integer> map, String symbols) {
        for (int i = 0; i < symbols.length(); i++) {
            map.merge(symbols.charAt(i), 1, (oldVal, newVal) -> oldVal + newVal);
        }
    }
}
