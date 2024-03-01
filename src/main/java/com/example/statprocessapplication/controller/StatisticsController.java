package com.example.statprocessapplication.controller;

import com.example.statprocessapplication.model.salesandtrafficbyasin.SaleAndTrafficByAsin;
import com.example.statprocessapplication.model.salesandtrafficbydate.SaleAndTrafficByDate;
import com.example.statprocessapplication.service.SaleAndTrafficByAsinService;
import com.example.statprocessapplication.service.SaleAndTrafficByDateService;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/stats")
public class StatisticsController {
    private final SaleAndTrafficByAsinService saleAndTrafficByAsinService;
    private final SaleAndTrafficByDateService saleAndTrafficByDateService;

    @GetMapping("/by-isbn")
    public List<SaleAndTrafficByAsin> getAllByAsin() {
        return saleAndTrafficByAsinService.getAll();
    }

    @GetMapping("by-date")
    public List<SaleAndTrafficByDate> getAllByDate() {
        return saleAndTrafficByDateService.getAll();
    }

    @GetMapping("/by-date/{date}")
    public SaleAndTrafficByDate getByDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        return saleAndTrafficByDateService.findByDate(date);
    }

    @GetMapping("/by-date-range")
    public List<SaleAndTrafficByDate> getByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
        return saleAndTrafficByDateService.findAllByDateRange(startDate, endDate);
    }

    @GetMapping("/by-asin")
    List<SaleAndTrafficByAsin> findAllByAsin(@RequestParam List<String> asins) {
        return saleAndTrafficByAsinService.getAllByAsinList(asins);
    }
}
