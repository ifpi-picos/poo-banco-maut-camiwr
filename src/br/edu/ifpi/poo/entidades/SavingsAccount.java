package br.edu.ifpi.poo.entidades;

import  br.edu.ifpi.poo.notificacoes.Notification;

public class SavingsAccount extends Account {
    public double income; //rendimento

    public SavingsAccount(int numberAgency, int numberAccount, double balance, double income, Client client, Notification notification) {
        super(numberAgency, numberAccount, balance, client, notification);
        this.income = income;
    }

    @Override
    public double sacar(double value, Notification chooseNotification){
        if (chooseNotification != null) {
            if (value <= balance){
                double taxa = value * 0.05;
                super.sacar(value + taxa, chooseNotification);
                transactions.add(new Transaction("Saque",value));
                chooseNotification.sendNotification("Saque", value);
                return value;
            }else {
                System.out.println("Saldo insuficiente.");
                return 0;
            }
        }else {
            System.out.println("Notificação não definida. A transferência não pode ser realizada.");
        }
        return value;
    }

    @Override
    public void transferir(Account destiny, double value, Notification chooseNotification) {
        if (chooseNotification != null) {
            if (value <= balance) {
                double taxa = value * 0.10;
                super.sacar(taxa, chooseNotification);
                destiny.depositar(value - taxa, chooseNotification);
                transactions.add(new Transaction("Transferencia",value));
                chooseNotification.sendNotification("Transferencia", value);
    
            } else {
                System.out.println("Saldo insuficiente.");
            }
                
        }else {
            System.out.println("Notificação não definida. A transferência não pode ser realizada.");
        }
    }
    @Override
    public boolean depositar(double value, Notification chooseNotification) {
        double incomeValue = value * income;
        double incomeWithValue = value + incomeValue;
        transactions.add(new Transaction("Deposito",value));
        chooseNotification.sendNotification("Saque", value);
            return super.depositar(incomeWithValue, chooseNotification);
    }   
}