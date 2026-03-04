package org.example;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class CadastroUsuario {
    Scanner sc = new Scanner(System.in);
    ArrayList<Usuario> usuario = new ArrayList<>();
    public void iniciar(){
        usuario.add(new Funcionario("Admin", "000000000000", 1, "100", 1000));
        usuario.add(new Cliente("Cliente", "11111111111", "85856460", "Rua avenida", 570, "Panorama", "45998557442"));
        usuario.get(1).toString();
        printMenu();
        System.out.println("--Cadastro Usuario--");
        System.out.println("1 - Novo cadastro");
        System.out.println("2 - Atualizar ");
        System.out.println("3 - Voltar");
        int op = sc.nextInt();
        limparBuffer();
        switch (op){
            case 1:
                novo();
                break;
            case 2:
                atualizar();
                break;
            case 3:
                /*Volta ao menu*/
                break;
            default:
                System.out.println("Escolha uma opcao valida!!");
        }
    }
    public void novo(){
        System.out.println("--Novo--");
        String nome;
        String cpf;
        System.out.println("Digite o Nome: ");
        nome = sc.nextLine();
        System.out.println("Digite o CPF: ");
        cpf = sc.nextLine();
        for (int i = 0; i < usuario.size(); i++) {
            if (usuario.get(i).getCpf().equals(cpf)){
                System.out.println("Erro!! Cpf já cadastrado");
            }
        }
        System.out.println("--Novo--");
        System.out.println("1 - Cliente");
        System.out.println("2 - Funcionario");
        System.out.println("3 - Voltar");
        int op = sc.nextInt();
        limparBuffer();
        switch (op){
            case 1:
                String cep;
                String rua;
                int numero;
                String bairro;
                String telefone;
                System.out.println("Cep: ");
                cep = sc.nextLine();
                System.out.println("Rua: ");
                rua = sc.nextLine();
                System.out.println("Numero: ");
                numero = sc.nextInt();
                limparBuffer();
                System.out.println("Bairro: ");
                bairro = sc.nextLine();
                System.out.println("Telefone: ");
                telefone = sc.nextLine();
                usuario.add(new Cliente(nome,cpf,cep,rua,numero,bairro,telefone));
                break;
            case 2:
                int acesso;
                String login;
                int senha;
                System.out.println("Digite o nivel de acesso: ");
                acesso = sc.nextInt();
                limparBuffer();
                System.out.println("Digite o Login: ");
                login = sc.nextLine();
                senha = -1;
                while(senha < 1000 || senha > 9999){
                    try{
                        System.out.println("Digite a senha (somente numeros de 4 digitos): ");
                        senha = sc.nextInt();
                        limparBuffer();
                    }catch (InputMismatchException e){
                        System.out.println("Senha invalida, Tente Novamente");
                        limparBuffer();
                    }

                }
                usuario.add(new Funcionario(nome,cpf,acesso,login,senha));
                iniciar();
                break;

            case 3:
                iniciar();
                break;
            default:
                System.out.println("Escolhe uma opcao disponivel");
                novo();
                break;

        }

    }
    public void atualizar(){
        int resultadoVerificacao = verificar();
        if(resultadoVerificacao == 1){
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
        else if(resultadoVerificacao != 0){
            System.out.println("Usuario não possui permição para alterar");
            iniciar();
        }
        else{
            System.out.println("Erro!!!!");
        }

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
    public int verificar(){
        System.out.println("--Verificao de usuario--");
        System.out.println("Login: ");
        String login = sc.nextLine();
        System.out.println("Senha: ");
        int senha = sc.nextInt();
        limparBuffer();
        for(int i = 0; i < usuario.size(); i++){
            if(login.equals(((Funcionario) usuario.get(i)).getLogin()) && senha == (((Funcionario) usuario.get(i)).getSenha())){
                System.out.println(usuario.get(i).getNome());
                return ((Funcionario) usuario.get(i)).getAcesso(); /*Retorno da verificacao*/
            }
            else{
                System.out.println("Erro!!! Verifique o login e a senha");
                return 0;
            }
        }
        return -1;
    }





}
