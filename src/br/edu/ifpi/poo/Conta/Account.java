package br.edu.ifpi.poo.Conta;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.edu.ifpi.poo.Cliente.Client;
import br.edu.ifpi.poo.Notificacoes.Notification;
import br.edu.ifpi.poo.Transacao.Transaction;

public class Account {
    private int agencyNumber;
    private int accountNumber;
    private Client client;
    private Notification notification;
    protected double balance;
    protected Transaction transaction;


    // construtor
    public Account(int agencyNumber, int accountNumber, double balance, Client client) {
        this.agencyNumber = agencyNumber;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.client = client;
        this.transaction = new Transaction();
        client.addAccount(this); 
        }

    public Account(String numAgencyDestiny, String numAccountDestiny){
        this.transaction = new  Transaction();
    }


    public int getAgencyNumber() {
        return agencyNumber;
    }


    public int getAccountNumber() {
        return accountNumber;
    }


    public Client getClient() {
        return client;
    }
 
    public double getBalance() {
        return balance;
    }
    
    public void setNotification (Notification notification){
        this.notification = notification;
    }

    public List<Transaction> getTransactions() {
        return transaction.getTransactions();
    }

    // hora e data certas para o extrato
    protected String correctDateAndHour (){
        Date dateHourNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hh:mm - dd/mm/aaaa");
        return format.format(dateHourNow);
    }

    //metodo para depositar
    public boolean depositar(double value){
        balance += value;
        transaction.addTransaction("Depósito", value, correctDateAndHour());

        if (notification != null) {
                notification.sendNotification("Depósito", value);
            } else {
                System.out.println("Nao foi possível enviar uma notificação.");
        }

        System.out.println("Depósito concluído com sucesso.");
        return false;
    }

    //medoto para sacar
    public double sacar(double value){
        if (value <= balance){
            balance -= value;
            transaction.addTransaction("Saque", value, correctDateAndHour());

            if (notification != null) {
                notification.sendNotification("Saque", value);
            } else {
                System.out.println("Nao foi possível enviar uma notificação.");
            }

            System.out.println("Saque concluído com sucesso");
        } else {
            System.out.println("Saldo insuficiente.");
        }
        return value;
    }

    // método para transferir
    public void transferir(Account destiny, double value){
        if (value <= balance){
            balance -= value;
            destiny.depositar(value);
            transaction.addTransaction("Transferência", value, correctDateAndHour());

            if (notification != null) {
                notification.sendNotification("Transferência", value);
            } else {
                System.out.println("Não foi possível enviar uma notificação.");
            }

            System.out.println("Transferência concluída com sucesso");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
}
