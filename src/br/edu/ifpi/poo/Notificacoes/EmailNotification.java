package br.edu.ifpi.poo.Notificacoes;

public class EmailNotification implements Notification {
    // método sobrescrito da Interface Notificacao
    @Override
    public void sendNotification(String type, double value) {
        // corpo/implementação do método
        System.out.println("enviando notificacao por email, " + type + ", Valor: " + value);
    }
}
