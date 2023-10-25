package br.edu.ifpi.poo.entidades;

import java.util.Date;
import java.util.List;

public class Transaction {
    private Date date;
    private String description;
    private double value;

    public Transaction(String description, double value) {
        this.date = new Date();
        this.description = description;
        this.value = value;
    }

    @Override
    public String toString() {
        return "data: " + date + ", Descrição: " + description + ", valor: " + value;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public double getValue() {
        return value;
    }

    public List<Transaction> getTransactions() {
        return null;
    } 
}
