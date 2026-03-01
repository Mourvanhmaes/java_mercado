package org.example;

public abstract class Usuario {
    private int id;
    private String nome;
    private String cpf;
    private static int contadorDoId = 0;

    public Usuario(String nome, String cpf) {
        contadorDoId++;
        this.id = contadorDoId;
        this.nome = nome;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
