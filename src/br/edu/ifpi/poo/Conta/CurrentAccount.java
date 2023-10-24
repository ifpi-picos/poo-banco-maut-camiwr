package br.edu.ifpi.poo.Conta;

import br.edu.ifpi.poo.Cliente.Client;

public class CurrentAccount extends Account {
    private double overdraft;
    private int freeTransfers;

    public CurrentAccount(int numberAgency, int numberAccount, double balance, double overdraft, Client client){
        super(client, numberAgency, numberAccount, balance);
        this.overdraft = overdraft;
        this.freeTransfers = 2;
    }

    @Override
    public void transferir (Account destiny, double value){
        if (value <= (balance + overdraft)) {
            balance -= value;

            if(freeTransfers > 0) {
                destiny.depositar(value);
                freeTransfers--;
            } else {
                //Taxa 10%
                double taxa = value * 0.1;
                super.sacar(taxa);
                destiny.depositar(value - taxa);
             }
             transaction.addTransaction("Transferência", value, correctDateAndHour());
             System.out.println("Transferência concluída com sucesso");
         } else {
             System.out.println("Saldo e/ou cheque especial insuficientes.");
         }

    }
    @Override
    public boolean depositar(double value) {
        double incomeValue = value * income;
        double incomeWithValue = value + incomeValue;
        transaction.addTransaction("Depósito realizado com taxa de Rendimento", incomeWithValue, correctDateAndHour());
        return super.depositar(incomeWithValue);
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
}

