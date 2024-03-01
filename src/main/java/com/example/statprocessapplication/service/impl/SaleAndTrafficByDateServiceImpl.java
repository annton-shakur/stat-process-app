package com.example.statprocessapplication.service.impl;

import com.example.statprocessapplication.model.salesandtrafficbydate.SaleAndTrafficByDate;
import com.example.statprocessapplication.repository.SalesAndTrafficByDateRepository;
import com.example.statprocessapplication.service.SaleAndTrafficByDateService;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleAndTrafficByDateServiceImpl implements SaleAndTrafficByDateService {
    private final SalesAndTrafficByDateRepository salesAndTrafficByDateRepository;

    @Override
    public List<SaleAndTrafficByDate> getAll() {
        return salesAndTrafficByDateRepository.findAll();
    }

    @Override
    @Cacheable(cacheNames = "salesAndTrafficByDate", key = "#date")
    public SaleAndTrafficByDate findByDate(LocalDate date) {
        return salesAndTrafficByDateRepository.findByDate(date);
    }

    @Override
    @Cacheable(cacheNames = "salesAndTrafficByDateRange",
            key = "#startDate.toString() + '-' + #endDate.toString()")
    public List<SaleAndTrafficByDate> findAllByDateRange(LocalDate startDate, LocalDate endDate) {

        List<SaleAndTrafficByDate> statsListFromDateRange = salesAndTrafficByDateRepository
                .findAllByDateBetween(startDate, endDate);
        statsListFromDateRange.forEach(this::cacheStatsByDate);
        return statsListFromDateRange;
    }

    @CachePut(cacheNames = "salesAndTrafficByDate", key = "#result.date")
    public SaleAndTrafficByDate cacheStatsByDate(SaleAndTrafficByDate saleAndTrafficByDate) {
        System.out.println("Data has been cached");
        return saleAndTrafficByDate;
    }
}
