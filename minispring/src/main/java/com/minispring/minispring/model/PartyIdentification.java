package com.minispring.minispring.model;

public class PartyIdentification {
    private String value;
    private PartyIdentificationType type;

    public PartyIdentification( PartyIdentificationType type,String value) {
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public PartyIdentificationType getType() {
        return type;
    }

    public void setType(PartyIdentificationType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "\nPartyIdentification{\n" +
                "value='" + value + '\'' +
                ", type=" + type +
                '}'+"\n";
    }
}
