package org.example;

public class Funcionario extends Usuario{
    private int acesso;
    private String login;
    private int senha;

    public Funcionario(String nome, String cpf, int acesso, String login, int senha) {
        super(nome, cpf);
        this.acesso = acesso;
        this.login = login;
        this.senha = senha;
    }
    /*----------------------Geters------------------*/

    public int getAcesso() {
        return acesso;
    }

    public String getLogin() {
        return login;
    }

    public int getSenha() {
        return senha;
    }

    public String getDadosFuncionario(){
        return String.format("Login: %s  Senha: %d",
                getLogin(),
                getSenha());
    }


    /*--------------------setters-----------------------*/

    public void setAcesso(int acesso) {
        this.acesso = acesso;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    // Escrever o nivel do acesso do funcionario
    public String FuncionarioAcesso(){
        switch (this.acesso){
            case 1:
                return "Administrador";

            case 2:
                return "Operador";

            default:
                return "Sem acesso";

        }
    }

    //    to String


    @Override
    public String toString() {
        return String.format("%04d %-15s %-15s %-12s",
                getId(),
                getNome(),
                getCpf(),
                FuncionarioAcesso());
    }
}
