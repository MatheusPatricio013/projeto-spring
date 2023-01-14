package com.minispring.minispring.controller;

import com.minispring.minispring.model.SalesOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface SalesOrderController {
    @GetMapping(path = "/api/v1/sales-orders")
    Page<SalesOrder> retrieveSalesOrders(Pageable pageable, Optional<Predicate> filter,
                                         @RequestParam("$expand") Optional<String> expand);

    @GetMapping(path = "/api/v1/sales-orders/{salesOrderId}")
    Optional<SalesOrder> retrieveSalesOrder(@PathVariable Long salesOrderId,
                                            @RequestParam("$expand") Optional<String> expand);

    @PostMapping(path = "/api/v1/sales-orders")
    List<SalesOrder> createSalesOrders(@RequestBody List<SalesOrder> salesOrders);

    @PutMapping(path = "/api/v1/sales-orders/{salesOrderId}/cancel")
    SalesOrder cancelSalesOrder(@PathVariable Long salesOrderId);

    @PutMapping(path = "/api/v1/sales-orders/{salesOrderId}")
    SalesOrder updateSalesOrder(@PathVariable Long salesOrderId, @RequestBody SalesOrder salesOrder);

    @PutMapping(path = "/api/v1/sales-orders/{salesOrderId}/close")
    SalesOrder closeSalesOrder(@PathVariable Long salesOrderId);

    @PutMapping(path = "/api/v1/sales-orders/{salesOrderId}/process")
    SalesOrder processSalesOrder(@PathVariable Long salesOrderId);
}
