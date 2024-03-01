package com.example.statprocessapplication.service;

import com.example.statprocessapplication.model.salesandtrafficbydate.SaleAndTrafficByDate;
import java.time.LocalDate;
import java.util.List;

public interface SaleAndTrafficByDateService {
    SaleAndTrafficByDate findByDate(LocalDate date);

    List<SaleAndTrafficByDate> findAllByDateRange(LocalDate startDate, LocalDate endDate);

    List<SaleAndTrafficByDate> getAll();
}
