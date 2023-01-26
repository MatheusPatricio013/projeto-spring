package com.minispring.minispring.controller;

import com.minispring.minispring.exception.ValidateException;
import com.minispring.minispring.model.SalesOrder;
import com.minispring.minispring.usecase.CloseSalesOrder;
import com.minispring.minispring.usecase.CreateSalesOrders;
import com.minispring.minispring.usecase.ProcessSalesOrder;
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
    private final ProcessSalesOrder processSalesOrder;

    private final CloseSalesOrder closeSalesOrder;


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
    public SalesOrder updateSalesOrder(Long salesOrderId, SalesOrder salesOrder) {

        return null;
    }

    @Override
    public ResponseEntity<SalesOrder> closeSalesOrder(Long salesOrderId) {
        return new ResponseEntity<>(this.closeSalesOrder.execute(salesOrderId),HttpStatus.PROCESSING);
    }

    @Override
    public  ResponseEntity<SalesOrder> processSalesOrder(Long salesOrderId) {
        return new ResponseEntity<>(this.processSalesOrder.execute(salesOrderId),HttpStatus.PROCESSING);
    }
}
