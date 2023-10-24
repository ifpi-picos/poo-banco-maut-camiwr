package br.edu.ifpi.poo.Transacao;

import java.sql.Date;

public class Transacao {
    private Date data;
    private String descricao;
    private double valor;

    public Transacao(String descricao, double valor) {
        this.data = new Date(0);
        this.descricao = descricao;
        this.valor = valor;
    }
    @Override
    public String toString() {
        return "Data: " + data + ", Descrição: " + descricao + ", Valor: " + valor;
    }
}
