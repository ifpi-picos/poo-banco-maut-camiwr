package br.edu.ifpi.poo.Cliente;

public class Cliente {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private Endereco endereco;

    public Cliente(String nome, String cpf, String dataNascimento, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }
    // gets
    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
