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
            transactions.add(new Transaction("Saque",value));

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
            transactions.add(new Transaction("Transferencia",value));
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
    @Override
    public boolean depositar(double value) {
        double incomeValue = value * income;
        double incomeWithValue = value + incomeValue;
        transactions.add(new Transaction("Deposito",value));
            return super.depositar(incomeWithValue);
    }   
}