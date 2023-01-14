package com.minispring.minispring.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.Objects;

@Entity
@Table(name="Boleto")
public class Boleto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "amount", nullable = true)
    private BigDecimal amount;
    private String bankReference;
    private String barCode;
    private Currency currency;
    private LocalDateTime date;
    private String documentReference;
    private LocalDateTime dueDate;
    private String externalReference;
    private BigDecimal paidAmount;
    private LocalDate paidDate;
    private BoletoState state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getBankReference() {
        return bankReference;
    }

    public void setBankReference(String bankReference) {
        this.bankReference = bankReference;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDocumentReference() {
        return documentReference;
    }

    public void setDocumentReference(String documentReference) {
        this.documentReference = documentReference;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public LocalDate getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(LocalDate paidDate) {
        this.paidDate = paidDate;
    }

   /* public NegotiableInstrument getNegotiableInstrument() {
        return negotiableInstrument;
    }

    public void setNegotiableInstrument(NegotiableInstrument negotiableInstrument) {
        this.negotiableInstrument = negotiableInstrument;
    }
*/
    public BoletoState getState() {
        return state;
    }

    public void setState(BoletoState state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boleto boleto = (Boleto) o;
        return this.getId() != null && this.getId().equals(boleto.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "\nBoleto{" +
                "amount=" + amount +
                ", bankReference='" + bankReference + '\'' +
                ", barCode='" + barCode + '\'' +
                ", currency=" + currency +
                ", date=" + date +
                ", documentReference='" + documentReference + '\'' +
                ", dueDate=" + dueDate +
                ", externalReference='" + externalReference + '\'' +
                ", paidAmount=" + paidAmount +
                ", paidDate=" + paidDate +
               /* ", negotiableInstrument=" + negotiableInstrument +*/
                ", state=" + state +
                '}'+"\n";
    }
}
