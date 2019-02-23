package iothreads.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public final class IOUtils {

    private IOUtils() {
    }

    public static void randomNumsWriter(Path pathToWrite, int numsQuantity, int randomRange) throws IOException {
        Random randomValue = new Random();
        if (checkFile(pathToWrite)) {
            try (BufferedWriter out = new BufferedWriter(new FileWriter(pathToWrite.toFile(), false))) {
                for (int i = 0; i < numsQuantity; i++) {
                    out.write(randomValue.nextInt(randomRange) + "");
                    out.newLine();
                    out.flush();
                }
            }
        }
    }

    private static boolean checkFile(Path path) {
        return path.toFile().exists() && path.toFile().isFile();
    }

    public static List<Integer> readAndSort(Path pathToRead) throws IOException {
        List<Integer> list = null;
        if (checkFile(pathToRead)) {
            try (BufferedReader in = new BufferedReader(new FileReader(pathToRead.toFile()))) {
                list = in.lines().mapToInt(Integer::parseInt).sorted().boxed().collect(Collectors.toList());
            }
        }
        return list;
    }

    public static void sortedListWriter(Path pathToWrite, List<Integer> list) throws IOException {
        if (checkFile(pathToWrite)) {
            try (BufferedWriter out = new BufferedWriter(new FileWriter(pathToWrite.toFile(), false))) {
                out.write(list.stream().map(String::valueOf).collect(Collectors.joining("\n")));
                out.flush();
            }
        }
    }
}
