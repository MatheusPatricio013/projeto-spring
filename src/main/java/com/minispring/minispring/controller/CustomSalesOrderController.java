package com.minispring.minispring.controller;

import com.minispring.minispring.usecase.CreateSalesOrders;
import com.minispring.minispring.usecase.RetrieveSalesOrders;

public class CustomSalesOrderController extends DefaultSalesOrderController{
    public CustomSalesOrderController(CreateSalesOrders createSalesOrders, RetrieveSalesOrders retrieveSalesOrders) {
        super(createSalesOrders, retrieveSalesOrders);
    }
}
