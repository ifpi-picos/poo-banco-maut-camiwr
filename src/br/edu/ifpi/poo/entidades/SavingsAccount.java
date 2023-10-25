package br.edu.ifpi.poo.entidades;

public class SavingsAccount extends Account {
    public double income; //rendimento

    public SavingsAccount(int numberAgency, int numberAccount, double balance, double income, Client client) {
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
    @Override
    public void transferir(Account destiny, double value) {
        if (value <= balance) {
            double taxa = value * 0.10;
            super.sacar(taxa);
            destiny.depositar(value - taxa);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
    @Override
    public boolean depositar(double value) {
        double incomeValue = value * income;
        double incomeWithValue = value + incomeValue;
        transaction.addTransaction("Depósito realizado com taxa de Rendimento", incomeWithValue, correctDateAndHour());
        return super.depositar(incomeWithValue);
    }   
}