package br.com.fastfood.flashfood.cliente.infraestrutura.adaptadores.saida.repositories.persistencia.entidades;

import br.com.fastfood.flashfood.cliente.dominio.modelos.Cliente;
import br.com.fastfood.flashfood.cliente.dominio.vo.Email;
import br.com.fastfood.flashfood.compartilhado.dominio.vo.CPF;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "clientes")
public class EntidadeCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private String cpf;
    private String email;

    public EntidadeCliente() {}
    public EntidadeCliente(Cliente cliente) {
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf().getNumero();
        this.email = cliente.getEmail().getEndereco();
    }

    public Cliente toCustomer() {
        return new Cliente(new CPF(this.cpf), this.nome, new Email(this.email));
    }
}


