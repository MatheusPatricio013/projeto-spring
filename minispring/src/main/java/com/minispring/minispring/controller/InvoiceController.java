package com.minispring.minispring.controller;


import com.minispring.minispring.model.Invoice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public interface InvoiceController {
    @GetMapping(path =("/retrieve-invoices"))
    List<Invoice> retrieveInvoices();
}
