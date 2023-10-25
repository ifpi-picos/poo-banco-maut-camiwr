package br.edu.ifpi.poo.entidades;

import  br.edu.ifpi.poo.notificacoes.Notification;

public class CurrentAccount extends Account {
    private double overdraft;
    private int freeTransfers;

    public CurrentAccount(int numberAgency, int numberAccount, double balance, double overdraft, Client client, Notification notification){
        super(numberAgency, numberAccount, balance, client, notification);
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
    public void transferir (Account destiny, double value, Notification chooseNotification){
        if (chooseNotification != null) {
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
                 transactions.add(new Transaction("Transferencia",value));
                 notification.sendNotification("Transferencia", value);
                  System.out.println("Transferência realizada com sucesso.");
             } else {
                 System.out.println("Saldo e cheque especial insuficientes.");
             }
                } else {
            System.out.println("Notificação não definida. A transferência não pode ser realizada.");
        }
    }

    @Override
    public double sacar(double value, Notification chooseNotification) {
        if (chooseNotification != null) {
            if (value > 0) {
                if (value <= (balance + overdraft)) {
                    if (value <= balance) {
                        balance -= value;
                    } else {
                        double valorSaque = value - balance;
                        balance = 0;
                        overdraft -= valorSaque;
                    }
                    transactions.add(new Transaction("Saque",value));
                    chooseNotification.sendNotification("Saque", value);
                    System.out.println("Saque realizado com sucesso.");
                } else {
                    System.out.println("Saldo e/ou cheque especial insuficientes.");
                }
            } else {
                System.out.println("Valor de saque inválido.");
            }
        }else {
            System.out.println("Notificação não definida. A transferência não pode ser realizada.");
        }
        return value;
    }
    public static void informationUserCurrent(Client client, Adress adress) {
        if (client != null) {
            System.out.println("Informações do Cliente:");
            System.out.println("Nome: " + client.getName());
            System.out.println("CPF: " + client.getCpf());
            System.out.println("Data de nascimento: " + client.getDateOfBirth());
            System.out.println("\nInformações de endereço");
            System.out.println("Rua: "+ adress.getstreet() + ", N°" + adress.getnumber());
            System.out.println("Bairro: "+ adress.getdistrict());
            System.out.println("Cidade: "+ adress.getcity());
            System.out.println("Estado:"+ adress.getstate());
            System.out.println("Pais: "+ adress.getcountry());
        } else {
            System.out.println("Nenhum cliente associado a esta conta.");
        }
    }
    


}

