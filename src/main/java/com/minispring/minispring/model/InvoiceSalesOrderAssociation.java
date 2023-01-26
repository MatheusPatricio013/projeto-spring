package com.minispring.minispring.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.Objects;
@Getter
@Setter
@Entity
@Table(name = "invoiceAssociation")
public class InvoiceSalesOrderAssociation implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    private LocalDateTime date;
    private BigDecimal amount;
    private Currency currency;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    })
    private Invoice invoice;
    @ManyToOne
    @JoinColumn(name = "sales_order_id")
    private SalesOrder salesOrder;



    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "\nInvoiceSalesOrderAssociation{" +
                ", date=" + date +
                ", amount=" + amount +
                ", currency=" + currency +
                ", invoiceExternalReference=" + invoice.getExternalReference()+
                ", invoiceAmount=" + invoice.getAmount();
    }
}
