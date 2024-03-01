package com.example.statprocessapplication.service.impl;

import com.example.statprocessapplication.model.Report;
import com.example.statprocessapplication.service.DataConverter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JsonConverter implements DataConverter {
    private final ObjectMapper objectMapper;

    @Override
    public String fromListToString(List<String> lines) {
        return String.join("", lines);
    }

    @Override
    public Report toModel(String jsonData) {
        try {
            return objectMapper.readValue(jsonData, Report.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
