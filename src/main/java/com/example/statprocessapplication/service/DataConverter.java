package com.example.statprocessapplication.service;

import com.example.statprocessapplication.model.Report;
import java.util.List;

public interface DataConverter {

    String fromListToString(List<String> lines);

    Report toModel(String jsonData);
}
