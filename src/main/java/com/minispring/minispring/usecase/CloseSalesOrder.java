package com.minispring.minispring.usecase;

import com.minispring.minispring.exception.SalesOrderAlreadyProcessedException;
import com.minispring.minispring.exception.SalesOrderNotFoundException;
import com.minispring.minispring.model.SalesOrder;
import com.minispring.minispring.model.SalesOrderState;
import com.minispring.minispring.model.SalesOrderStatus;
import com.minispring.minispring.repository.SalesOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CloseSalesOrder {
    @Autowired
    private SalesOrderRepository salesOrderRepository;

    public SalesOrder execute(Long salesOrderId){
        this.validateId(salesOrderId);
        Optional<SalesOrder> salesOrder = salesOrderRepository.findById(salesOrderId);
        this.process(salesOrder.get(),salesOrderId);
        salesOrderRepository.save(salesOrder.get());
        return  salesOrder.get();
    }

    private void process(SalesOrder salesOrder,Long id){
        this.validateProcessing(salesOrder,id);
        salesOrder.setState(SalesOrderState.CLOSED);

    }

    private void validateId(Long id){
        if(!salesOrderRepository.existsById(id)){
            throw new SalesOrderNotFoundException(id);
        }
    }

    private void validateProcessing(SalesOrder salesOrder,Long id){
        if(salesOrder.getState().equals(SalesOrderState.CLOSED)){
            throw new SalesOrderAlreadyProcessedException(id);
        }
    }
}
