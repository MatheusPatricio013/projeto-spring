package com.minispring.minispring.usecase;

import com.minispring.minispring.exception.SalesOrderNotFoundException;
import com.minispring.minispring.model.SalesOrder;
import com.minispring.minispring.repository.SalesOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RetrieveSalesOrders  {
    @Autowired
    private SalesOrderRepository salesOrderRepository;


    public Optional<SalesOrder> execute(Long salesOrderId){
    Boolean salesOrderExist = this.verifySalesOrder(salesOrderId);

    if(!salesOrderExist){
    throw new SalesOrderNotFoundException(salesOrderId);

    }
        Optional<SalesOrder> salesOrder = salesOrderRepository.findById(salesOrderId);
        return salesOrder;
    }

    public List<SalesOrder> execute(){
      return salesOrderRepository.findAll();
    }
    private Boolean verifySalesOrder(Long id){
        if(salesOrderRepository.existsById(id)){
            return true;
        }
        return false;
    }

}
