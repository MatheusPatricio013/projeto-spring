package com.minispring.minispring.controller;

import com.minispring.minispring.exception.ValidateException;
import com.minispring.minispring.model.SalesOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public interface SalesOrderController {
    @GetMapping(path = "/sales-orders")
    List<SalesOrder> retrieveSalesOrders();

    @GetMapping(path = "sales-orders/{salesOrderId}")
    ResponseEntity<Optional<SalesOrder>> retrieveSalesOrder(@PathVariable Long salesOrderId);

    @PostMapping(path = "sales-orders")
    ResponseEntity<SalesOrder> createSalesOrders(@RequestBody SalesOrder salesOrders) throws ValidateException;



    @PutMapping(path = "sales-orders/{salesOrderId}")
    SalesOrder updateSalesOrder(@PathVariable Long salesOrderId, @RequestBody SalesOrder salesOrder);

    @PutMapping(path = "sales-orders/{salesOrderId}/close")
    ResponseEntity<SalesOrder> closeSalesOrder(@PathVariable Long salesOrderId);

    @PutMapping(path = "sales-orders/{salesOrderId}/process")
    ResponseEntity<SalesOrder> processSalesOrder(@PathVariable Long salesOrderId);
}
