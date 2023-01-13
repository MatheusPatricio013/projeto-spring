package com.minispring.minispring.model;

import java.util.Set;

public class NotaFiscalEletronica {
    private Long id;
    private String acessKey;
    private Set<Invoice> invoices;
    private NotaFiscalEletronicaStatus status;

}
