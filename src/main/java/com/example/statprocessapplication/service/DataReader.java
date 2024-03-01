package com.example.statprocessapplication.service;

import java.util.List;

public interface DataReader {
    List<String> readFile(String pathToFile);
}
