package com.minispring.minispring.controller;

import com.minispring.minispring.exception.ValidateException;
import com.minispring.minispring.model.SalesOrder;
import com.minispring.minispring.usecase.CreateSalesOrders;
import com.minispring.minispring.usecase.RetrieveSalesOrders;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class DefaultSalesOrderController implements SalesOrderController{
    private final CreateSalesOrders createSalesOrders;
    private final RetrieveSalesOrders retrieveSalesOrders;


    @Override
    public List<SalesOrder> retrieveSalesOrders() {

        return retrieveSalesOrders.execute();
    }

    @Override
    public ResponseEntity<Optional<SalesOrder>> retrieveSalesOrder(Long salesOrderId) {
        return new ResponseEntity<>(retrieveSalesOrders.execute(salesOrderId),HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<SalesOrder> createSalesOrders( SalesOrder salesOrders) throws ValidateException {

        return new ResponseEntity<>(createSalesOrders.execute(salesOrders),HttpStatus.CREATED);
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
