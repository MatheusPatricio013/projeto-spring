package com.minispring.minispring.controller;

import com.minispring.minispring.model.SalesOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class DefaultSalesOrderController implements SalesOrderController{
    @Override
    public Page<SalesOrder> retrieveSalesOrders(Pageable pageable, Optional<Predicate> filter, Optional<String> expand) {
        return null;
    }

    @Override
    public Optional<SalesOrder> retrieveSalesOrder(Long salesOrderId, Optional<String> expand) {
        return Optional.empty();
    }

    @Override
    public List<SalesOrder> createSalesOrders(List<SalesOrder> salesOrders) {
        return null;
    }

    @Override
    public SalesOrder cancelSalesOrder(Long salesOrderId) {
        return null;
    }

    @Override
    public SalesOrder updateSalesOrder(Long salesOrderId, SalesOrder salesOrder) {
        return null;
    }

    @Override
    public SalesOrder closeSalesOrder(Long salesOrderId) {
        return null;
    }

    @Override
    public SalesOrder processSalesOrder(Long salesOrderId) {
        return null;
    }
}
