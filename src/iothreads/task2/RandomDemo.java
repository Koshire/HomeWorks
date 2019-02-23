package iothreads.task2;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RandomDemo {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("resources", "random.txt");
        IOUtils.randomNumsWriter(path, 100, 1000);
        IOUtils.sortedListWriter(path, IOUtils.readAndSort(path));
    }
}