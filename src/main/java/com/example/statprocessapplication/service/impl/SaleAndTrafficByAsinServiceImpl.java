package com.example.statprocessapplication.service.impl;

import com.example.statprocessapplication.model.salesandtrafficbyasin.SaleAndTrafficByAsin;
import com.example.statprocessapplication.repository.SaleAndTrafficByAsinRepository;
import com.example.statprocessapplication.service.SaleAndTrafficByAsinService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleAndTrafficByAsinServiceImpl implements SaleAndTrafficByAsinService {
    private final SaleAndTrafficByAsinRepository saleAndTrafficByAsinRepository;

    @Override
    public List<SaleAndTrafficByAsin> getAll() {
        return saleAndTrafficByAsinRepository.findAll();
    }

    @Override
    @Cacheable(cacheNames = "salesAndTrafficByAsins")
    public List<SaleAndTrafficByAsin> getAllByAsinList(List<String> asins) {
        return saleAndTrafficByAsinRepository.findAllByParentAsinIn(asins);
    }
}
