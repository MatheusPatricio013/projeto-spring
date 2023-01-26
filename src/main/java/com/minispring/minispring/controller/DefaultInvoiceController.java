package com.minispring.minispring.controller;

import com.minispring.minispring.model.Invoice;
import com.minispring.minispring.model.SalesOrder;
import com.minispring.minispring.usecase.CreateInvoice;
import com.minispring.minispring.usecase.RetrieveInvoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
public class DefaultInvoiceController implements InvoiceController{
    @Autowired
    private CreateInvoice createInvoice;
    @Autowired
    private RetrieveInvoice retrieveInvoice;
    @Override

    public List<Invoice> retrieveInvoices() {
        return this.retrieveInvoice.execute();
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Optional<Invoice>> retrieveInvoice(Long InvoiceId) {
        return new ResponseEntity<>(retrieveInvoice.execute(InvoiceId),HttpStatus.FOUND);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Invoice> createInvoice(Invoice invoice) {
        return new ResponseEntity<>(createInvoice.execute(invoice), HttpStatus.CREATED);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public SalesOrder processInvoice(Long invoiceId) {
        return null;
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public SalesOrder updateSalesOrder(Long invoiceId, Invoice invoice) {
        return null;
    }
}
