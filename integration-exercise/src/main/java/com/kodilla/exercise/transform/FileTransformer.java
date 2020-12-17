package com.kodilla.exercise.transform;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileTransformer {
    public String transformFile() throws IOException {
        StringBuilder result = new StringBuilder();
        boolean fileExist = new File("./integration-exercise/data/output/files.txt").isFile();
        if (fileExist) {
            Files.readAllLines(Paths.get("./integration-exercise/data/output/files.txt"))
                    .forEach(line -> result.append(line).append("\n"));
        }
        File[] files = new File("./integration-exercise/data/input").listFiles();
        for (File file : files) {
            if (!result.toString().contains(file.getName())) {
                result.append(file.getName()).append("\n");
            }
        }
        return result.toString().strip();
    }
}
