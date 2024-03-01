package com.example.statprocessapplication.service.fileversioncontrol;

import com.example.statprocessapplication.model.reportspecification.ReportSpecification;
import com.example.statprocessapplication.model.salesandtrafficbyasin.SaleAndTrafficByAsin;
import com.example.statprocessapplication.model.salesandtrafficbydate.SaleAndTrafficByDate;
import com.example.statprocessapplication.service.DataInitializer;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseVersionController {
    private static final String jsonFilePath = "src/main/java/com/example/"
            + "statprocessapplication/filesForProcessing/test_report.json";
    private final DataInitializer dataInitializer;
    private final MongoTemplate mongoTemplate;
    private long lastModifiedTimestamp = 0L;

    @Scheduled(fixedRate = 15000)
    public void checkAndUpdate() {
        Path filePath = Paths.get(jsonFilePath);
        long currentModifiedTimestamp = new File(filePath.toString()).lastModified();

        if (currentModifiedTimestamp != lastModifiedTimestamp) {
            lastModifiedTimestamp = currentModifiedTimestamp;
            dropCollections();
            dataInitializer.loadDataToDb();
        }
    }

    private void dropCollections() {
        mongoTemplate.dropCollection(ReportSpecification.class);
        mongoTemplate.dropCollection(SaleAndTrafficByAsin.class);
        mongoTemplate.dropCollection(SaleAndTrafficByDate.class);
    }
}
