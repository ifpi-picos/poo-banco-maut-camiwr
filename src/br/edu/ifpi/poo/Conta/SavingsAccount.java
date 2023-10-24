package br.edu.ifpi.poo.Conta;

import br.edu.ifpi.poo.Cliente.Client;

public class SavingsAccount extends Account {
    public double income; //rendimento

    public SavingsAccount(int numberAgency, int numberAccount, double balance, double interestRate, Client client) {
        super(numberAgency, numberAccount, balance, client);
        this.income = income;
    }

    @Override
    public double sacar(double value){
        if (value <= balance){
            double taxa = value * 0.05;
            super.sacar(value + taxa);
            return value;
        }else {
            System.out.println("Saldo insuficiente.");
            return 0;
        }
    }
}