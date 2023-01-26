package com.minispring.minispring.usecase;


import co.elastic.apm.api.ElasticApm;
import co.elastic.apm.api.Transaction;
import com.minispring.minispring.exception.NullValueException;
import com.minispring.minispring.exception.ValidateException;
import com.minispring.minispring.model.InstructionInvolvement;
import com.minispring.minispring.model.SalesOrder;
import com.minispring.minispring.repository.SalesOrderRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class CreateSalesOrders {
@Autowired
private SalesOrderRepository salesOrderRepository;


public SalesOrder execute(SalesOrder salesOrders) throws ValidateException {
      this.validateSalesOrder(salesOrders);
      if(salesOrders.getCreatedDate() == null){
         LocalDateTime now = LocalDateTime.now();
         Timestamp timestamp = Timestamp.valueOf(now);
         salesOrders.setCreatedDate(timestamp);
      }

   SalesOrder salesOrder = salesOrderRepository.save(salesOrders);
   return salesOrder;
}
public void validateSalesOrder(SalesOrder salesOrder) throws ValidateException {
   Set<Exception> violationExceptions = new LinkedHashSet<>();
   if(salesOrder.getAmount() == null){
      violationExceptions.add(new NullValueException("Amount"));
   }
   if(salesOrder.getCurrency() == null){
      violationExceptions.add(new NullValueException("Currency"));
   }
   if(salesOrder.getState() == null){
      violationExceptions.add(new NullValueException("State"));
   }
   if(salesOrder.getStatus() == null){
      violationExceptions.add(new NullValueException("Status"));
   }
   if(salesOrder.getExternalReference() == null){
      violationExceptions.add(new NullValueException("External Reference"));
   }
   if(violationExceptions.size() > 0){
      throw new ValidateException(violationExceptions,SalesOrder.class);
   }
}
}
