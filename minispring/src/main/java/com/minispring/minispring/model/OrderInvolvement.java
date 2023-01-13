package com.minispring.minispring.model;

public class OrderInvolvement {
    private Party party;
    private OrderInvolvementType type;

    public OrderInvolvement(Party party, OrderInvolvementType type) {
        this.party = party;
        this.type = type;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public OrderInvolvementType getType() {
        return type;
    }

    public void setType(OrderInvolvementType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "OrderInvolvement{\n" +
                "party=" + party +
                "\ntype=" + type +
                '}';
    }
}
