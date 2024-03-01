package com.example.statprocessapplication.service;

import com.example.statprocessapplication.model.Report;
import com.example.statprocessapplication.repository.ReportSpecificationRepository;
import com.example.statprocessapplication.repository.SaleAndTrafficByAsinRepository;
import com.example.statprocessapplication.repository.SalesAndTrafficByDateRepository;
import com.example.statprocessapplication.service.impl.JsonConverter;
import com.example.statprocessapplication.service.impl.JsonFileReader;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private static final String STATS_FILE_PATH = "src/main/java/com/example/"
            + "statprocessapplication/filesForProcessing/test_report.json";
    private final JsonConverter jsonConverter;
    private final JsonFileReader jsonFileReader;
    private final SaleAndTrafficByAsinRepository saleAndTrafficByAsinRepository;
    private final SalesAndTrafficByDateRepository salesAndTrafficByDateRepository;
    private final ReportSpecificationRepository reportSpecificationRepository;

    @PostConstruct
    public void loadDataToDb() {
        Report report = jsonConverter.toModel(
                jsonConverter.fromListToString(jsonFileReader.readFile(STATS_FILE_PATH))
        );
        saleAndTrafficByAsinRepository.saveAll(report.getSalesAndTrafficByAsin());
        salesAndTrafficByDateRepository.saveAll(report.getSalesAndTrafficByDate());
        reportSpecificationRepository.save(report.getReportSpecification());
    }
}
