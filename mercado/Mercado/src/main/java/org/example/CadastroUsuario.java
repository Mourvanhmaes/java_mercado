package org.example;

import java.util.Scanner;
import java.util.ArrayList;

public class CadastroUsuario {
    Scanner sc = new Scanner(System.in);
    ArrayList<Usuario> usuario = new ArrayList<>();
    public void iniciar(){
        printMenu();
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
        System.out.println("Selecione o ID do usuario que deseja alterar: ");
        int opId = sc.nextInt();
        opId--;
        if(opId > usuario.size() || opId < 0){
            System.out.println("Erro escolha um usuario disponivel!!");
            atualizar();
        }
        limparBuffer();
        printOpAtualizar(opId);
        String continuar;
        do{
            printMenu();
            System.out.println("Continuar alterando mesmo usuario (s/n)");
            continuar = sc.nextLine().toLowerCase();
            if(continuar.equals("s")){
                printOpAtualizar(opId);
            }
            else if(!continuar.equals("n")){
                System.out.println("Erro!!! Responda somente com s/n");
            }
        }while(!continuar.equals("n"));
        iniciar();
    }
    public void limparBuffer(){
        sc.nextLine();
    }
    public ArrayList<Usuario> listaUsuario(){
        return usuario;
    }
    public void printOpAtualizar(int opId){
        System.out.println("--Alterar dados Usuario--");
        System.out.println("1 - Nome");
        System.out.println("2 - Cpf");
        System.out.println("3 - Acesso");
        System.out.println("4 - Login");
        System.out.println("5 - Senha");
        System.out.println("Selecione o numero do que deseja alterar: ");
        int op = sc.nextInt();
        limparBuffer();
        if(op < 1 || op > 5){
            System.out.println("Selecione uma opcao disponivel!!");
        }
        System.out.println("Digite: ");
        switch (op){
            case 1:
                String nome = sc.nextLine();
                usuario.get(opId).setNome(nome);
                break;
            case 2:
                String cpf = sc.nextLine();
                usuario.get(opId).setCpf(cpf);
                break;
            case 3:
                int acesso = sc.nextInt();
                limparBuffer();
                ((Funcionario) usuario.get(opId)).setAcesso(acesso);
                break;
            case 4:
                String login = sc.nextLine();
                ((Funcionario) usuario.get(opId)).setLogin(login);
                break;
            case 5:
                int senha = sc.nextInt();
                limparBuffer();
                ((Funcionario) usuario.get(opId)).setSenha(senha);
                break;
            default:
                System.out.println("Error");
                break;
        }
    }
    public void printMenu(){
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("%-4s %-15s %-15s %-12s %-10s %-6s\n",
                "ID", "Nome", "CPF", "Acesso", "Login", "Senha");

        System.out.println("-------------------------------------------------------------------");
        for (int i = 0; i < usuario.size(); i++) {
            System.out.println(usuario.get(i).toString());
        }
    }





}
