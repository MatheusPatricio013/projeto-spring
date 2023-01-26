package com.minispring.minispring.usecase;

import com.minispring.minispring.exception.*;
import com.minispring.minispring.model.*;
import com.minispring.minispring.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class CreateInvoice {
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private NegotiableInstrumentRepository negotiableInstrumentRepository;
    @Autowired
    private BoletoRepository boletoRepository;
    @Autowired
    private SalesOrderRepository salesOrderRepository;
    @Autowired
    private InvoiceSalesOrderAssociationRepository invoiceSalesOrderAssociationRepository;
    private SalesOrder salesOrder = new SalesOrder();

    public Invoice execute(Invoice invoice) {
        this.validateInvoice(invoice);
        this.validateAmountInvoiced(invoice);
        invoice.setNegotiableInstruments(this.createNegotiable(invoice));
        if (invoice.getDate() == null) {
            LocalDateTime now = LocalDateTime.now();
            Timestamp timestamp = Timestamp.valueOf(now);
            invoice.setDate(timestamp);
            invoice.setDueDate(now.plusDays(30));
            invoice.getNegotiableInstruments().get(0).setDueDate(invoice.getDueDate().plusDays(30));
        }
        Invoice invoice1 = invoiceRepository.save(invoice);
        this.createAssociation(invoice,this.salesOrder);
        return invoice1;
    }

    private List<NegotiableInstrument> createNegotiable(Invoice invoice) {
        List<NegotiableInstrument> negotiableInstruments = new ArrayList<>();
        if (invoice.getNegotiableInstruments() == null) {
            NegotiableInstrument negotiableInstrument = new NegotiableInstrument();

            negotiableInstrument.setAmount(invoice.getAmount());
            negotiableInstrument.setCurrency(invoice.getCurrency());
            negotiableInstrument.setState(ExternalPaymentInstructionState.OPEN);
            negotiableInstrument.setDocumentReference("92392992");
            negotiableInstruments.add(negotiableInstrument);
            negotiableInstrument.setExternalReference(invoice.getExternalReference());
            negotiableInstrument.setBoleto(this.createBoleto(negotiableInstrument));

            negotiableInstrumentRepository.save(negotiableInstrument);

        }

        return negotiableInstruments;
    }

    private Boleto createBoleto(NegotiableInstrument negotiableInstrument) {
        LocalDateTime now = LocalDateTime.now();
        if (negotiableInstrument.getBoleto() == null) {
            Boleto boleto = new Boleto();
            boleto.setState(BoletoState.OPEN);
            boleto.setBankReference("341");
            boleto.setDueDate(negotiableInstrument.getDueDate());
            boleto.setDate(negotiableInstrument.getDate());
            boleto.setPaidAmount(negotiableInstrument.getAmount());
            boleto.setAmount(negotiableInstrument.getAmount());
            boleto.setBarCode("23098201213991");
            boleto.setCurrency(negotiableInstrument.getCurrency());
            boleto.setDocumentReference("3442123423");
            boleto.setExternalReference(negotiableInstrument.getExternalReference());
            boleto.setState(BoletoState.OPEN);
            boleto.setPaidDate(now.plusDays(10));
            boletoRepository.save(boleto);
            negotiableInstrument.setBoleto(boleto);
            return boleto;
        }

        return negotiableInstrument.getBoleto();
    }

    public void validateInvoice(Invoice invoice) throws ValidateException {

        Set<Exception> violationExceptions = new LinkedHashSet<>();
        if (invoice.getAmount() == null) {
            violationExceptions.add(new NullValueException("amount"));
        }
        if (invoice.getCurrency() == null) {
            violationExceptions.add(new NullValueException("Currency"));
        }
        if (invoice.getState() == null) {
            violationExceptions.add(new NullValueException("State"));
        }
        if (invoice.getStatus() == null) {
            violationExceptions.add(new NullValueException("Status"));
        }

        if (violationExceptions.size() > 0) {
            throw new ValidateException(violationExceptions, Invoice.class);
        }

    }

    private void validateAmountInvoiced(Invoice invoice){
         salesOrder = new SalesOrder();
        if(invoice.getExternalReference() != null){
            List<SalesOrder> salesOrders= salesOrderRepository.findAll().stream().toList();

            Boolean isValidExternal = false;
            for(SalesOrder sl: salesOrders){
                if(sl.getExternalReference() != null){
                    if(sl.getExternalReference().equals(invoice.getExternalReference())){
                        salesOrder= sl;
                        isValidExternal = true;
                    }
                }

            }
          if(!isValidExternal){
              throw new ExternalReferenceNotFoundException(invoice.getExternalReference());
          }

            }


                BigDecimal invoiceAmount = invoice.getAmount();
                BigDecimal salesOrderAmount =salesOrder.getAmount();
                if(invoiceAmount.compareTo(salesOrderAmount) == 0 ){
                   invoice.setStatus(ExternalPaymentInstructionStatus.EXECUTED);
                }
                else{
                    invoice.setStatus(ExternalPaymentInstructionStatus.CANCELED);
                    throw new ValueDifferentThanAmountException("Invoice different than Sales order amount ");

        }


    }

    private InvoiceSalesOrderAssociation createAssociation(Invoice invoice,SalesOrder salesOrder){
        InvoiceSalesOrderAssociation association = new InvoiceSalesOrderAssociation();
        association.setAmount(invoice.getAmount());
        association.setDate(LocalDateTime.now());
        invoiceSalesOrderAssociationRepository.save(association);
        return association;
    }

}
