package com.example.statprocessapplication.model.salesandtrafficbyasin;

import com.example.statprocessapplication.model.salesandtrafficbydate.SellingPrice;
import lombok.Data;

@Data
public class SalesByAsin {
    private Integer unitsOrdered;
    private Integer unitsOrderedB2B;
    private SellingPrice orderedProductSales;
    private SellingPrice orderedProductSalesB2B;
    private Integer totalOrderItems;
    private Integer totalOrderItemsB2B;
}
