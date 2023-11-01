package br.com.fastfood.flashfood.cliente.infraestrutura.adaptadores.saida.repositories.persistencia;

import br.com.fastfood.flashfood.cliente.aplicacao.portas.saida.PortaClienteRepositorio;
import br.com.fastfood.flashfood.cliente.dominio.modelos.Cliente;
import br.com.fastfood.flashfood.cliente.infraestrutura.adaptadores.saida.repositories.persistencia.entidades.EntidadeCliente;
import br.com.fastfood.flashfood.compartilhado.dominio.vo.CPF;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RepositorioCliente implements PortaClienteRepositorio {

    private final RepositorioClienteSpring repositorioClienteSpring;

    public RepositorioCliente(RepositorioClienteSpring repositorioClienteSpring) {
        this.repositorioClienteSpring = repositorioClienteSpring;
    }

//    @Override
//    public Optional<Cliente> findBy(CPF cpf) {
//        Optional<EntidadeCliente> customerEntity = this.repositorioClienteSpring.findByCpf(cpf.getNumero());
//        if(customerEntity.isEmpty()) {
//            return Optional.empty();
//        }
//
//        return Optional.of(customerEntity.map(EntidadeCliente::toCustomer));
//    }

    @Override
    public Optional<Cliente> findBy(CPF cpf) {
        Optional<EntidadeCliente> customerEntity = this.repositorioClienteSpring.findByCpf(cpf.getNumero());
        return customerEntity.map(EntidadeCliente::toCustomer);
    }

    @Override
    public void save(Cliente cliente) {
        this.repositorioClienteSpring.save(new EntidadeCliente(cliente));
    }
}