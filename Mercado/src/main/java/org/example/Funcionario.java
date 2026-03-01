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
                return "Supervisor";

            case 3:
                return "Operador";

            default:
                return "Acesso não reconhecido!!!";

        }
    }

    //    to String


    @Override
    public String toString() {
        return String.format("%-4d %-15s %-15s %-12s %-10s %-6d",
                getId(),
                getNome(),
                getCpf(),
                FuncionarioAcesso(),
                login,
                senha);
    }
}
