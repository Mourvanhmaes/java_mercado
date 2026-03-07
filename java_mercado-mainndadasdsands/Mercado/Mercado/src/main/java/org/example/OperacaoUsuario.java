package org.example;
import org.example.dados.DadosUsuario;
import java.util.Scanner;
import java.util.InputMismatchException;

public class OperacaoUsuario {
    Scanner sc = new Scanner(System.in);
    Verificacoes verificar = new Verificacoes();
    Utilidades util = new Utilidades();
    public void iniciar(){
        DadosUsuario.usuario.add(new Funcionario("Admin", "000000000000", 1, "100", 1000));
        DadosUsuario.usuario.add(new Cliente("Cliente", "11111111111", "85856460", "Rua avenida", 570, "Panorama", "45998557442"));
        printMenu();
        System.out.println("--Usuarios--");
        System.out.println("1 - Novo cadastro");
        System.out.println("2 - Atualizar ");
        System.out.println("3 - Relatorio");
        System.out.println("0 - Voltar");
        int op;
        while(true){
            if(sc.hasNextInt()){
                op = sc.nextInt();
                break;
            }
            else{
                System.out.println("Digite algo valido!!!");
                limparBuffer();
            }
        }
        limparBuffer();
        switch (op){
            case 1:
                novo();
                break;
            case 2:
                atualizar();
                break;
            case 3:
                relatoriosUsuarios();
                break;
            case 0:
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
        for (int i = 0; i < DadosUsuario.usuario.size(); i++) {
            if (DadosUsuario.usuario.get(i).getCpf().equals(cpf)){
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
                DadosUsuario.usuario.add(new Cliente(nome,cpf,cep,rua,numero,bairro,telefone));
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
                senha = verificar.senha();
                DadosUsuario.usuario.add(new Funcionario(nome,cpf,acesso,login,senha));
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
        int resultadoVerificacao = verificar.acesso();
        if(resultadoVerificacao == 1){
            System.out.println("Selecione o ID do usuario que deseja alterar: ");
            int opId = sc.nextInt();
            opId--;
            if(opId > DadosUsuario.usuario.size() || opId < 0){
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


    public void printOpAtualizar(int opId){
        System.out.println("--Alterar dados Usuario--");
        System.out.println("1 - Nome");
        System.out.println("2 - Cpf");
        if (DadosUsuario.usuario.get(opId) instanceof Cliente){
            System.out.println("3 - Cep");
            System.out.println("4 - rua");
            System.out.println("5 - Numero");
            System.out.println("6 - Bairro");
            System.out.println("7 - Telefone");
            atualizarCliente(opId);
        }
        else if(DadosUsuario.usuario.get(opId) instanceof Funcionario){
            System.out.println("3 - Acesso");
            System.out.println("4 - Login");
            System.out.println("5 - Senha");
            atualizarFuncionario(opId);
        }
    }

    public void atualizarCliente(int opId){
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
                DadosUsuario.usuario.get(opId).setNome(nome);
                break;
            case 2:
                String cpf = sc.nextLine();
                DadosUsuario.usuario.get(opId).setCpf(cpf);
                break;
            case 3:
                String cep = sc.nextLine();
                ((Cliente) DadosUsuario.usuario.get(opId)).setCep(cep);
                break;
            case 4:
                String rua = sc.nextLine();
                ((Cliente) DadosUsuario.usuario.get(opId)).setRua(rua);
                break;
            case 5:
                int numero = sc.nextInt();
                limparBuffer();
                ((Cliente) DadosUsuario.usuario.get(opId)).setNumero(numero);
                break;
            case 6:
                String bairro = sc.nextLine();
                ((Cliente) DadosUsuario.usuario.get(opId)).setBairro(bairro);
                break;
            case 7:
                String telefone = sc.nextLine();
                ((Cliente) DadosUsuario.usuario.get(opId)).setTelefone(telefone);
                break;
            default:
                System.out.println("Error");
                break;
        }
    }

    public void atualizarFuncionario(int opId){
        System.out.println("Selecione o numero do que deseja alterar: ");
        int op = sc.nextInt();
        util.limparBuffer();
        if(op < 1 || op > 5){
            System.out.println("Selecione uma opcao disponivel!!");
        }
        System.out.println("Digite: ");
        switch (op){
            case 1:
                String nome = sc.nextLine();
                DadosUsuario.usuario.get(opId).setNome(nome);
                break;
            case 2:
                String cpf = sc.nextLine();
                DadosUsuario.usuario.get(opId).setCpf(cpf);
                break;
            case 3:
                int acesso = sc.nextInt();
                limparBuffer();
                ((Funcionario) DadosUsuario.usuario.get(opId)).setAcesso(acesso);
                break;
            case 4:
                String login = sc.nextLine();
                ((Funcionario) DadosUsuario.usuario.get(opId)).setLogin(login);
                break;
            case 5:
                int senha = sc.nextInt();
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
                limparBuffer();
                ((Funcionario) DadosUsuario.usuario.get(opId)).setSenha(senha);
                break;
            default:
                System.out.println("Error");
                break;
        }
    }

    public void printMenu(){
        util.limpar();
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("%-4s %-15s %-15s %-12s\n",
                "ID", "Nome", "CPF", "Acesso");

        System.out.println("-------------------------------------------------------------------");
        for (int i = 0; i < DadosUsuario.usuario.size(); i++) {
            System.out.println(DadosUsuario.usuario.get(i).toString());
        }

    }


    public void dadosComplementares(int id){
        id--;
        Usuario aux = DadosUsuario.usuario.get(id);
        if (aux instanceof Cliente) {
            System.out.println("-------------------------------------------------------------------");
            System.out.printf("%-4s %-15s %-15s %-12s\n",
                    "ID", "Nome", "CPF", "Acesso");

            System.out.println("-------------------------------------------------------------------");
            System.out.println(((Cliente) aux).toString());
            System.out.println(((Cliente) aux).getDadosCliente());
        } else if (aux instanceof Funcionario) {
            System.out.println("-------------------------------------------------------------------");
            System.out.printf("%-4s %-15s %-15s %-12s\n",
                    "ID", "Nome", "CPF", "Acesso");

            System.out.println("-------------------------------------------------------------------");
            System.out.println(((Funcionario) aux).toString());
            System.out.println(((Funcionario) aux).getDadosFuncionario());
        }
    }

    public void relatoriosUsuarios(){
        printMenu();
        util.limpar();
        System.out.println("--Relatorio Usuario--");
        System.out.println("Id do usuario que deseja ver os dados complementares (0 para sair): ");
        int op = sc.nextInt();
        limparBuffer();
        dadosComplementares(op);
    }





    public void limparBuffer(){
        sc.nextLine();
    }




}
