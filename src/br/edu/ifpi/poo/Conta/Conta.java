package br.edu.ifpi.poo.Conta;

import java.util.ArrayList;

import br.edu.ifpi.poo.Cliente.Cliente;
import br.edu.ifpi.poo.Transacao.Transacao;

public class Conta {
    private static int proximoNumeroConta = 1;
    private int numeroAgencia;
    private int numeroConta;
    private double saldo;
    private Cliente cliente;
     private ArrayList<Transacao> transacoes;


    // construtor
    public Conta(Cliente cliente, int numeroAgencia) {
            this.cliente = cliente;
            this.numeroAgencia = numeroAgencia;
            this.numeroConta = proximoNumeroConta++;
            this.saldo = 0;
            transacoes = new ArrayList<>();
        }


    public static int getProximoNumeroConta() {
        return proximoNumeroConta;
    }


    public int getNumeroAgencia() {
        return numeroAgencia;
    }


    public int getNumeroConta() {
        return numeroConta;
    }


    public double getSaldo() {
        return saldo;
    }


    public Cliente getCliente() {
        return cliente;
    }


    public ArrayList<Transacao> getTransacoes() {
        return transacoes;
    }
        
}
