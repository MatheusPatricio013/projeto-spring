package com.minispring.minispring.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Currency;
import java.util.Set;
@Table(name="salesOrder")
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
public class SalesOrder extends Order implements Serializable {
    private static final Long serialVersionUID = 1L;
    public static final String OBJECT_TYPE = "SALES_ORDER";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name="amount")
    private BigDecimal amount;
    @Column(name="currency")
    private Currency currency;
    @Column(name="state")
    private SalesOrderState state;
    @Column(name="status")
    private SalesOrderStatus status;
    @Column(name="externalReference")
    private String externalReference;
    @CreatedDate
    @Column(name="createdDate",columnDefinition = "TIMESTAMP")
    private Timestamp createdDate;


    private InternalPaymentInstruction instruction;
@OneToMany
    private Set<InvoiceSalesOrderAssociation> invoiceSalesOrderAssociations;

    public SalesOrder(){}


    @Override
    public String toString() {
        return "\nSalesOrder{" +
                "amount=" + amount +
                ", currency=" + currency +
                ", invoiceSalesOrderAssociations=" + invoiceSalesOrderAssociations +
                "\nExternalReference=" + getExternalReference();
    }
}
