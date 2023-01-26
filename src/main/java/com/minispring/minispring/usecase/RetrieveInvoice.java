package com.minispring.minispring.usecase;

import com.minispring.minispring.exception.InvoiceNotFoundException;
import com.minispring.minispring.model.Invoice;
import com.minispring.minispring.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RetrieveInvoice {
    @Autowired
    private InvoiceRepository invoiceRepository;

    public Optional<Invoice> execute(Long id){
        if(!this.verifyInvoice(id)){
            throw new InvoiceNotFoundException(id);

        }
        else{
            return invoiceRepository.findById(id);
        }
    }

    public List<Invoice> execute(){
       return invoiceRepository.findAll();
    }

    private Boolean verifyInvoice(Long id){
        if(invoiceRepository.existsById(id)){
            return true;
        }
        return false;

    }
}
