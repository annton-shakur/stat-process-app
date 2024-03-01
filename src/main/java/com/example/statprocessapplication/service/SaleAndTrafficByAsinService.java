package com.example.statprocessapplication.service;

import com.example.statprocessapplication.model.salesandtrafficbyasin.SaleAndTrafficByAsin;
import java.util.List;

public interface SaleAndTrafficByAsinService {
    List<SaleAndTrafficByAsin> getAll();

    List<SaleAndTrafficByAsin> getAllByAsinList(List<String> asins);
}
