package com.example.statprocessapplication.service.impl;

import com.example.statprocessapplication.service.DataReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class JsonFileReader implements DataReader {
    private static final String CANNOT_READ_FILE_MSG = "Cannot read the file at ";

    @Override
    public List<String> readFile(String pathToFile) {
        try {
            return Files.readAllLines(Path.of(pathToFile));
        } catch (IOException e) {
            throw new RuntimeException(CANNOT_READ_FILE_MSG + pathToFile, e);
        }
    }
}
