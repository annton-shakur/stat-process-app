package com.example.statprocessapplication.model.salesandtrafficbydate;

import java.time.LocalDate;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "sale_and_traffic_by_date")
public class SaleAndTrafficByDate {
    private LocalDate date;
    private SalesByDate salesByDate;
    private TrafficByDate trafficByDate;
}
