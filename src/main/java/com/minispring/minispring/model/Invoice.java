package com.minispring.minispring.model;

import java.util.List;
import java.util.Set;

public class Invoice extends  ExternalPaymentInstruction{
    public static final String OBJECT_TYPE = "INVOICE";
    private List<NegotiableInstrument> negotiableInstruments;
    private Set<NotaFiscalEletronica> notasFiscaisEletronicas;

    public List<NegotiableInstrument> getNegotiableInstruments() {
        return negotiableInstruments;
    }

    public void setNegotiableInstruments(List<NegotiableInstrument> negotiableInstruments) {
        this.negotiableInstruments = negotiableInstruments;
    }

    public Set<NotaFiscalEletronica> getNotasFiscaisEletronicas() {
        return notasFiscaisEletronicas;
    }

    public void setNotasFiscaisEletronicas(Set<NotaFiscalEletronica> notasFiscaisEletronicas) {
        this.notasFiscaisEletronicas = notasFiscaisEletronicas;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "negotiableInstruments=" + negotiableInstruments +
                ", notasFiscaisEletronicas=" + notasFiscaisEletronicas +
                '}';
    }
}
