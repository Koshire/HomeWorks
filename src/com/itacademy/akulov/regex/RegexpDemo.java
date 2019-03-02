package com.itacademy.akulov.regex;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RegexpDemo {

    public static void main(String[] args) throws IOException {
        Path pathToRead = Paths.get("resources", "log-file.log");
        Path pathToWriteList = Paths.get("resources", "log-list.log");
        Path pathToWriteGroups = Paths.get("resources", "log-group.log");
        FileParser.writeEvents(pathToWriteList, FileParser.getEventsList(pathToRead));
        FileParser.writeGroupEvents(pathToRead, pathToWriteGroups);
    }

}

