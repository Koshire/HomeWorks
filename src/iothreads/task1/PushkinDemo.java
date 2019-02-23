package iothreads.task1;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PushkinDemo {

    public static void main(String[] args) throws IOException {
        Path inputPath = Paths.get("resources", "pushkin.txt");
        Path outputPath = Paths.get("resources", "result.txt");
        System.out.println(IOUtils.letterQuantity(inputPath, outputPath) ? "Ok." : "Not Ok.");
    }
}
