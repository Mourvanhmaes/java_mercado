package org.example;

import java.util.Scanner;
import java.util.ArrayList;

public class CadastroUsuario {
    Scanner sc = new Scanner(System.in);
    ArrayList<Usuario> usuario = new ArrayList<>();
    public void iniciar(){
        System.out.printf("%-4s %-15s %-15s %-12s %-10s %-6s\n",
                "ID", "Nome", "CPF", "Acesso", "Login", "Senha");

        System.out.println("-------------------------------------------------------------------");
        for (int i = 0; i < usuario.size(); i++) {
            System.out.println(usuario.get(i).toString());
        }
        System.out.println("Novo cadastro? s/n");
        String novoCadastro = sc.nextLine().toLowerCase();
        if(novoCadastro.equals("s")){
            novo();
        }
        else if(novoCadastro.equals("n")){
            atualizar();
        }
        else{
            System.out.println("Erro!!! Responda somente com s/n");
            iniciar();
        }
    }
    public void novo(){
        System.out.println("novo");
        String nome;
        String cpf;
        int acesso;
        String login;
        int senha;
        System.out.println("Digite o Nome: ");
        nome = sc.nextLine();
        System.out.println("Digite o CPF: ");
        cpf = sc.nextLine();
        System.out.println("Digite o nivel de acesso: ");
        acesso = sc.nextInt();
        limparBuffer();
        System.out.println("Digite o Login: ");
        login = sc.nextLine();
        System.out.println("Digite a senha (somente numeros): ");
        senha = sc.nextInt();
        limparBuffer();
        usuario.add(new Funcionario(nome,cpf,acesso,login,senha));
        iniciar();
    }
    public void atualizar(){
        System.out.println("Selecione o ID do usuario que vai alterar: ");
        int op = sc.nextInt();
        limparBuffer();
        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();
        usuario.get(op - 1).setNome(nome);
        iniciar();
    }
    public void limparBuffer(){
        sc.nextLine();
    }
    public ArrayList<Usuario> listaUsuario(){
        return usuario;
    }





}
