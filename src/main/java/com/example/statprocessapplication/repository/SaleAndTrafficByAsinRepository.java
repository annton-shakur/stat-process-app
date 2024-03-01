package com.example.statprocessapplication.repository;

import com.example.statprocessapplication.model.salesandtrafficbyasin.SaleAndTrafficByAsin;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleAndTrafficByAsinRepository
        extends MongoRepository<SaleAndTrafficByAsin, String> {

    List<SaleAndTrafficByAsin> findAllByParentAsinIn(List<String> asins);
}
