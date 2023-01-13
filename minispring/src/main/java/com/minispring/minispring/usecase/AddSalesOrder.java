package com.minispring.minispring.usecase;

import com.minispring.minispring.model.SalesOrder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

public class AddSalesOrder {

    public SalesOrder execute(Integer randomExternal, Double amount, Currency currency) {
        SalesOrder salesOrder = new SalesOrder();
        salesOrder.setCurrency(currency);
        salesOrder.setExternalReference(randomExternal.toString());
        salesOrder.setAmount(BigDecimal.valueOf(amount));
        salesOrder.setDate(LocalDateTime.now());
        salesOrder.setExternalReference(randomExternal.toString());
        return  salesOrder;
    }
}
