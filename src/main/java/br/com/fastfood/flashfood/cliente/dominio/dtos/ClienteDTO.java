package br.com.fastfood.flashfood.cliente.dominio.dtos;

import br.com.fastfood.flashfood.cliente.dominio.modelos.Cliente;

public class ClienteDTO {

    private String cpf;

    private String nome;

    private String email;

    public ClienteDTO(String cpf, String nome, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public ClienteDTO(Cliente cliente) {
        this.cpf = cliente.getCpf().getNumero();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail().getEndereco();
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
