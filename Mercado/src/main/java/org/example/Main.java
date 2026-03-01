package org.example;

public class Main {
    public static void main(String[] args) {
        CadastroUsuario cadastroUsuario = new CadastroUsuario();
        cadastroUsuario.iniciar();
        System.out.println(cadastroUsuario.listaUsuario().get(0).toString());
    }
}