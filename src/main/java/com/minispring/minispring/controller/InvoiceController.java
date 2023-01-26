package com.minispring.minispring.controller;


import com.minispring.minispring.model.Invoice;
import com.minispring.minispring.model.SalesOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public interface InvoiceController {
    @GetMapping(path =("/retrieve-invoices"))
    List<Invoice> retrieveInvoices();

    @GetMapping (path =("/retireve-invoice/{invoiceId}"))
    ResponseEntity<Optional<Invoice>> retrieveInvoice(@PathVariable Long InvoiceId);

    @PostMapping(path=("/create-invoice"))
    ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice);

    @PutMapping(path=("/process-invoice/{invoice-id}"))
    SalesOrder processInvoice(@PathVariable Long invoiceId);

    @PutMapping(path = "invoice/{invoice-id}")
    SalesOrder updateSalesOrder(@PathVariable Long invoiceId, @RequestBody Invoice invoice);

}
