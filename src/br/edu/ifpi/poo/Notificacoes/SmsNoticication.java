package br.edu.ifpi.poo.notificacoes;

public class SmsNoticication implements Notification {

    @Override
    public void sendNotification(String type, double value) {
         System.out.println("\n------------------------------------" +
         "Enviando notificação por SMS - Tipo: " + type + ", Valor: " + value +
         "------------------------------------");
    }
}
