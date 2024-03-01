package com.example.statprocessapplication.model;

import com.example.statprocessapplication.model.reportspecification.ReportSpecification;
import com.example.statprocessapplication.model.salesandtrafficbyasin.SaleAndTrafficByAsin;
import com.example.statprocessapplication.model.salesandtrafficbydate.SaleAndTrafficByDate;
import java.util.List;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "report")
public class Report {
    private ReportSpecification reportSpecification;
    private List<SaleAndTrafficByDate> salesAndTrafficByDate;
    private List<SaleAndTrafficByAsin> salesAndTrafficByAsin;
}
