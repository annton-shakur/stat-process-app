package com.example.statprocessapplication.repository;

import com.example.statprocessapplication.model.salesandtrafficbydate.SaleAndTrafficByDate;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesAndTrafficByDateRepository
        extends MongoRepository<SaleAndTrafficByDate, String> {
    SaleAndTrafficByDate findByDate(LocalDate date);

    @Query("{'date': { $gte: ?0, $lte: ?1 }}")
    List<SaleAndTrafficByDate> findAllByDateBetween(LocalDate startDate, LocalDate endDate);
}
