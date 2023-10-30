package br.com.fastfood.flashfood.cliente.infraestrutura.adaptadores.repositories;

import br.com.fastfood.flashfood.cliente.dominio.excecoes.ClienteNaoEncontradoExcecao;
import br.com.fastfood.flashfood.cliente.dominio.modelos.Cliente;
import br.com.fastfood.flashfood.cliente.dominio.portas.saida.PortaClienteRepositorio;
import br.com.fastfood.flashfood.cliente.infraestrutura.adaptadores.entidades.EntidadeCliente;
import br.com.fastfood.flashfood.compartilhado.dominio.vo.CPF;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RepositorioCliente implements PortaClienteRepositorio {

    private final RepositorioClienteSpring repositorioClienteSpring;

    public RepositorioCliente(RepositorioClienteSpring repositorioClienteSpring) {
        this.repositorioClienteSpring = repositorioClienteSpring;
    }

    @Override
    public Cliente findBy(CPF cpf) {
        Optional<EntidadeCliente> customerEntity = this.repositorioClienteSpring.findByCpf(cpf.getNumero());
        return customerEntity.map(EntidadeCliente::toCustomer).orElseThrow(() -> new ClienteNaoEncontradoExcecao(cpf));
    }

    @Override
    public void save(Cliente cliente) {
        this.repositorioClienteSpring.save(new EntidadeCliente(cliente));
    }
}