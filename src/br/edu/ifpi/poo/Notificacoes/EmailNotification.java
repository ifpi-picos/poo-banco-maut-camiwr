package br.edu.ifpi.poo.notificacoes;

public class EmailNotification implements Notification {
    
    @Override
    public void sendNotification(String type, double value) {
        System.out.println("\n------------------------------------" +
        "Enviando notificação por EMAIL - Tipo: " + type + ", Valor: " + value +
        "------------------------------------");
    }
}
