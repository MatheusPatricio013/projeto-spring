package com.minispring.minispring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="Boleto")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Boleto implements Serializable{
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "amount", nullable = false)
    private BigDecimal amount;
    @Column(name="bankReference",nullable = false)
    private String bankReference;
    @Column(name="barCode",nullable = false)
    private String barCode;
    @Column(name="currency",nullable = false)
    private Currency currency;
    @Column(name="date",nullable = true)
    private Timestamp date;
    @Column(name="documentReference",nullable = false)
    private String documentReference;
    @Column(name="dueDate",nullable = true)
    private LocalDateTime dueDate;
    @Column(name="externalReference",nullable = false)
    private String externalReference;
    @Column(name="paidAmount",nullable = false)
    private BigDecimal paidAmount;
    @Column(name="paidDate",nullable = false)
    private LocalDateTime paidDate;
    @Column(name="state",nullable = false)
    private BoletoState state;

    @OneToOne
    private NegotiableInstrument negotiableInstrument;

    public Boleto(){};
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

                ", state=" + state +
                '}'+"\n";
    }
}
