package org.example;

public class Cliente extends Usuario{
    private String cep;
    private String rua;
    private int numero;
    private String bairro;
    private String telefone;

    public Cliente(String nome, String cpf, String cep, String rua, int numero, String bairro, String telefone) {
        super(nome, cpf);
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.telefone = telefone;
    }


//    Getters

    public String getCep() {
        return cep;
    }

    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getDadosCliente(){
        return String.format(
                "\n+----------------+----------------------+" +
                        "\n| Campo          | Valor                |" +
                        "\n+----------------+----------------------+" +
                        "\n| CEP            | %-20s |" +
                        "\n| Rua            | %-20s |" +
                        "\n| Número         | %-20d |" +
                        "\n| Bairro         | %-20s |" +
                        "\n| Telefone       | %-20s |" +
                        "\n+----------------+----------------------+",
                cep, rua, numero, bairro, telefone
        );
    }
//  Setters

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return String.format("%04d %-15s %-15s %-12s",
                getId(),
                getNome(),
                getCpf(),
                "Cliente");
    }
}
