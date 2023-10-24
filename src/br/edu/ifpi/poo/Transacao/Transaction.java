package br.edu.ifpi.poo.Transacao;

import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private String date;
    private String description;
    private double value;

    public Transaction(String date, String description, double value) {
        this.date = date;
        this.description = description;
        this.value = value;
    }

    private List<Transaction> transactions;

    public Transaction(){
        this.transactions = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "data: " + date + ", Descrição: " + description + ", valor: " + value;
    }
    public String getDate() {
        return date;
    }
    public String getDescription() {
        return description;
    }
    public double getValue() {
        return value;
    }
    //!!
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction (String description, double value, String date){
        Transaction transaction = new Transaction(description, date, value);
        transaction.add(transaction);
    }

    private void add(Transaction transaction) {
    }

    public void clearTransactions(){
        transactions.clear();
    } 
}
