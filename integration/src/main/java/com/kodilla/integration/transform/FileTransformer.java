package com.kodilla.integration.transform;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileTransformer {

    public String transformFile(String fileName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        StringBuilder result = new StringBuilder();

        for (int n = lines.size() - 1; n >= 0; n--) {
            result.append(lines.get(n) + "\n");
        }

        return result.toString();
    }
}
