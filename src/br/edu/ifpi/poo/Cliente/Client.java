package br.edu.ifpi.poo.Cliente;

public class Client {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private Adress endereco;

    public Client(String nome, String cpf, String dataNascimento, Adress endereco) {
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

    public Adress getEndereco() {
        return endereco;
    }
}
