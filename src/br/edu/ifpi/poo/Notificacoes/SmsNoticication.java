package br.edu.ifpi.poo.Notificacoes;

public class SmsNoticication implements Notification {

    @Override
    public void sendNotification(String type, double value) {
         System.out.println("\nEnviando notificação por SMS - Tipo: " + type + ", Valor: " + value);
    }
}
