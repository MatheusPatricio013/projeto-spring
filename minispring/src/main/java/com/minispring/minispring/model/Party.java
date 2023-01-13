package com.minispring.minispring.model;

public class Party {
    private String name;
    private  PartyIdentification identification;

    public  Party(){};
    public Party(String name, PartyIdentification identification) {
        this.name = name;
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PartyIdentification getIdentification() {
        return identification;
    }

    public void setIdentification(PartyIdentification identification) {
        this.identification = identification;
    }

    @Override
    public String toString() {
        return "Party{" +
                "name='" + name + '\'' +
                ", identification=" + identification +
                '}';
    }
}
