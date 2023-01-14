package com.minispring.minispring.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

public class InstructionInvolvement {
    private BigDecimal creditLimit;
    private InstructionInvolvementType type;
    private OrderInvolvement orderInvolvement;

    private Configuration configuration;
    private Set<SalesOrder> salesOrders;
    public InstructionInvolvement(){};

    //Obligor
    public InstructionInvolvement(BigDecimal creditLimit,
                                  InstructionInvolvementType type,
                                  OrderInvolvement orderInvolvement,
                                  Set<SalesOrder> salesOrders) {
        this.creditLimit = creditLimit;
        this.type = type;
        this.orderInvolvement = orderInvolvement;
        this.salesOrders = salesOrders;
    }


    //Obligee


    public InstructionInvolvement(BigDecimal creditLimit, InstructionInvolvementType type, OrderInvolvement orderInvolvement, Configuration configuration, Set<SalesOrder> salesOrders) {
        this.creditLimit = creditLimit;
        this.type = type;
        this.orderInvolvement = orderInvolvement;
        this.configuration = configuration;
        this.salesOrders = salesOrders;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public InstructionInvolvementType getType() {
        return type;
    }

    public void setType(InstructionInvolvementType type) {
        this.type = type;
    }

    public OrderInvolvement getOrderInvolvement() {
        return orderInvolvement;
    }

    public void setOrderInvolvement(OrderInvolvement orderInvolvement) {
        this.orderInvolvement = orderInvolvement;
    }

    public Set<SalesOrder> getSalesOrders() {
        return salesOrders;
    }

    public void setSalesOrders(Set<SalesOrder> salesOrders) {
        this.salesOrders = salesOrders;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InstructionInvolvement that)) return false;
        return creditLimit.equals(that.creditLimit) && type == that.type && orderInvolvement.equals(that.orderInvolvement) && configuration.equals(that.configuration) && salesOrders.equals(that.salesOrders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditLimit, type, orderInvolvement, configuration, salesOrders);
    }

    @Override
    public String toString() {
        return "\nInstructionInvolvement{\n" +
                "creditLimit=" + creditLimit +
                "\ntype=" + type +
                "\norderInvolvement=" + orderInvolvement +
                "\nsalesOrders=" + salesOrders +
                '}'+"\n";
    }
}
