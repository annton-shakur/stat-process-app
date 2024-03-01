package com.example.statprocessapplication.repository;

import com.example.statprocessapplication.model.reportspecification.ReportSpecification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportSpecificationRepository
        extends MongoRepository<ReportSpecification, String> {
}
