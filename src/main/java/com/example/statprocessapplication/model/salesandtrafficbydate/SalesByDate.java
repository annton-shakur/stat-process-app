package com.example.statprocessapplication.model.salesandtrafficbydate;

import lombok.Data;

@Data
public class SalesByDate {
    private SellingPrice orderedProductSales;
    private SellingPrice orderedProductSalesB2B;
    private Integer unitsOrdered;
    private Integer unitsOrderedB2B;
    private Integer totalOrderItems;
    private Integer totalOrderItemsB2B;
    private SellingPrice averageSalesPerOrderItem;
    private SellingPrice averageSalesPerOrderItemB2B;
    private Double averageUnitsPerOrderItem;
    private Double averageUnitsPerOrderItemB2B;
    private SellingPrice averageSellingPrice;
    private SellingPrice averageSellingPriceB2B;
    private Integer unitsRefunded;
    private Double refundRate;
    private Integer claimsGranted;
    private SellingPrice claimsAmount;
    private SellingPrice shippedProductSales;
    private Integer unitsShipped;
    private Integer ordersShipped;
}
