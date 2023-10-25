package br.edu.ifpi.poo.entidades;

public class CurrentAccount extends Account {
    private double overdraft;
    private int freeTransfers;

    public CurrentAccount(int numberAgency, int numberAccount, double balance, double overdraft, Client client){
        super(numberAgency, numberAccount,balance, client);
        this.overdraft = 1000;
        this.freeTransfers = 2;
    }


    
    public double getOverdraft() {
        return overdraft;
    }

    public int getFreeTransfers() {
        return freeTransfers;
    }
    @Override
    public void transferir (Account destiny, double value){
        double taxa = value * 0.10;
        if (value > 0 && value <= (balance + overdraft)) {
            balance -= value;

            if(freeTransfers > 0) {
                destiny.balance += value ;
                freeTransfers--;
            } else {
                balance -= (value + taxa);
                destiny.balance +=(value);
             }
             transaction.addTransaction("Transferência", value, correctDateAndHour());
             System.out.println("Transferência realizada com sucesso.");
         } else {
             System.out.println("Saldo e cheque especial insuficientes.");
         }
    }

    @Override
    public double sacar(double value) {
        if (value > 0) {
            if (value <= (balance + overdraft)) {
                if (value <= balance) {
                    balance -= value;
                } else {
                    double valorSaque = value - balance;
                    balance = 0;
                    overdraft -= valorSaque;
                }
                transaction.addTransaction("Saque", value, correctDateAndHour());
                System.out.println("Saque realizado com sucesso.");
            } else {
                System.out.println("Saldo e/ou cheque especial insuficientes.");
            }
        } else {
            System.out.println("Valor de saque inválido.");
        }
        return value;
    }


}

