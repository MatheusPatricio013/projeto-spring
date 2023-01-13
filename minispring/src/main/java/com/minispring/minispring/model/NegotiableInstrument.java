package com.minispring.minispring.model;

import java.math.BigDecimal;
import java.util.Objects;

public class NegotiableInstrument extends ExternalPaymentInstruction{
    public static final String OBJECT_TYPE = "NEGOTIABLE_INSTRUMENT";
    private BigDecimal discountAmount;
    private String documentReference;
    private Invoice invoice;
    private Boleto boleto;

    public NegotiableInstrument() {
    }
    public NegotiableInstrument(BigDecimal discountAmount, String documentReference, Invoice invoice, Boleto boleto) {
        this.discountAmount = discountAmount;
        this.documentReference = documentReference;
        this.invoice = invoice;
        this.boleto = boleto;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getDocumentReference() {
        return documentReference;
    }

    public void setDocumentReference(String documentReference) {
        this.documentReference = documentReference;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Boleto getBoleto() {
        return boleto;
    }

    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NegotiableInstrument that)) return false;
        if (!super.equals(o)) return false;
        return discountAmount.equals(that.discountAmount) && documentReference.equals(that.documentReference) && invoice.equals(that.invoice) && Objects.equals(boleto, that.boleto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discountAmount, documentReference, invoice, boleto);
    }

    @Override
    public String toString() {
        return "NegotiableInstrument{\n" +
                "ObjectType=" + NegotiableInstrument.OBJECT_TYPE+
                "\ndiscountAmount=" + discountAmount +
                "\ndocumentReference='" + documentReference + '\'' +
                "\ninvoice=" + invoice +
                "\nboleto=" + boleto +
                '}'+"\n";
    }
}
