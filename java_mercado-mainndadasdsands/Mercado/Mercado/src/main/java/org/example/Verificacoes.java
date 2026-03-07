package org.example;

import org.example.dados.DadosUsuario;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Verificacoes {
    Scanner sc = new Scanner(System.in);
    Utilidades util = new Utilidades();
    public int acesso(){
        System.out.println("--Verificao de usuario--");
        System.out.println("Login: ");
        String login = sc.nextLine();
        System.out.println("Senha: ");
        int senha = sc.nextInt();
        util.limparBuffer();
        for(int i = 0; i < DadosUsuario.usuario.size(); i++){
            if(DadosUsuario.usuario.get(i) instanceof Funcionario){
                if(login.equals(((Funcionario) DadosUsuario.usuario.get(i)).getLogin()) && senha == (((Funcionario) DadosUsuario.usuario.get(i)).getSenha())){
                    System.out.println(DadosUsuario.usuario.get(i).getNome());
                    return ((Funcionario) DadosUsuario.usuario.get(i)).getAcesso(); /*Retorno da verificacao*/
                }
            }

        }
        System.out.println("Erro!! verifique o login e senha");
        return 0;
    }

    public int senha(){
        int senha = -1;
        while(senha < 1000 || senha > 9999){
            try{
                System.out.println("Digite a senha (somente numeros de 4 digitos): ");
                senha = sc.nextInt();
                sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Senha invalida, Tente Novamente");
                sc.nextLine();
            }

        }
        return senha;
    }
}
