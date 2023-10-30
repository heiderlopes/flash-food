package br.com.fastfood.flashfood.cliente.dominio.modelos;

import br.com.fastfood.flashfood.cliente.dominio.dtos.ClienteDTO;
import br.com.fastfood.flashfood.cliente.dominio.vo.Email;
import br.com.fastfood.flashfood.compartilhado.dominio.vo.CPF;

public class Cliente {

    private CPF cpf;

    private String nome;

    private Email email;

    public Cliente(CPF cpf, String nome, Email email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public Cliente(ClienteDTO clienteDTO) {
        this.cpf = new CPF(clienteDTO.getCpf());
        this.nome = clienteDTO.getNome();
        this.email = new Email(clienteDTO.getEmail());
    }

    public CPF getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Email getEmail() {
        return email;
    }
}
