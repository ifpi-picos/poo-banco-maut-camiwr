package br.edu.ifpi.poo.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Client {
    // Atributos privados que representam informações do cliente
    private String name;
    private String cpf;
    private LocalDate dateOfBirth;
    private Adress adress;
    private List<Account> accounts;

    //construtor
    public Client(String name, String cpf, LocalDate dateOfBirth, Adress adress) {
        this.name = name;
        this.cpf = cpf;
        this.dateOfBirth = dateOfBirth;
        this.adress = adress;
        this.accounts = new ArrayList<>();
    }
    // (getters e setters

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name.length() > 2) {
            this.name = name;
        } else {
            System.out.println("Nome invalido, digite um nome maior que 2 letras.");
        }
    }
    // cpf so tem get pois nao pode ser alterado
    public String getCpf() {
        return cpf;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public Adress getAdress() {
        return adress;
    }
    public void setAdress(Adress adress) {
        this.adress = adress;
    }
    public List<Account> getAccounts() {
        return accounts;
    }
    // Define a lista de contas associadas ao cliente
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
    // Adiciona uma conta à lista de contas do cliente
    public void addAccount(Account account) {
        accounts.add(account);
    }
}
