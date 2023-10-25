package br.edu.ifpi.poo.entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.ifpi.poo.notificacoes.Notification;

public abstract class Account {
    private int agencyNumber;
    private int accountNumber;
    private Client client;
    protected Notification notification;
    protected double balance;
    protected List<Transaction> transactions;


    // construtor
    public Account(int agencyNumber, int accountNumber, double balance, Client client, Notification notification2) {
        this.agencyNumber = agencyNumber;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.client = client;
        this.transactions = new ArrayList<>();
        client.addAccount(this); 
        }

    public List<Transaction> geTransactions(){
        return transactions;
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

    // hora e data certas para o extrato
    protected String correctDateAndHour (){
        Date dateHourNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hh:mm - dd/mm/aaaa");
        return format.format(dateHourNow);
    }
    //metodo para depositar
    public boolean depositar(double value, Notification chooseNotification){
        if (chooseNotification != null) {
            balance += value;
            transactions.add(new Transaction("Depósito",value));
            chooseNotification.sendNotification("Depósito", value);
    
            System.out.println("Depósito concluído com sucesso.");
        }else {
            System.out.println("Notificação não definida. A transferência não pode ser realizada.");
        }
        return false;
    }

    //medoto para sacar
    public double sacar(double value, Notification chooseNotification){
        if (chooseNotification != null) {
            if (value <= balance){
                balance -= value;
            transactions.add(new Transaction("saque",value));
    
                if (notification != null) {
                    this.notification.sendNotification("Saque", value);
                } else {
                    System.out.println("Nao foi possível enviar uma notificação.");
                }
    
                System.out.println("Saque concluído com sucesso");
            } else {
                System.out.println("Saldo insuficiente.");
            }
                
        } else {
            System.out.println("Notificação não definida. A transferência não pode ser realizada.");
        }
        return value;
    }

    // método para transferir
    public void transferir(Account destiny, double value, Notification chooseNotification){
            if (chooseNotification != null) {
                if (value <= balance){
                balance -= value;
                destiny.depositar(value, notification);
                transactions.add(new Transaction("Transferencia",value));
                if (notification != null) {
                this.notification.sendNotification("Transferencia", value);
                } else {
                    System.out.println("Não foi possível enviar uma notificação.");
                }

                System.out.println("Transferência concluída com sucesso");
            } else {
                System.out.println("Saldo insuficiente.");
            }
        }else {
            System.out.println("Notificação não definida. A transferência não pode ser realizada.");
        }
    }

    public void displayTransactions(){
        for (Transaction account : transactions) {
            System.out.println("\n******************************************");
            System.out.println(
                    "Tipo -> " + account.getDescription() +
                            "\nValor -> R$" + account.getValue() +
                            "\nData -> " + account.getDate());
            System.out.println("\n******************************************");
        }
    }
}
