package br.com.fastfood.flashfood.cliente.aplicacao.portas.saida;

import br.com.fastfood.flashfood.cliente.dominio.modelos.Cliente;
import br.com.fastfood.flashfood.compartilhado.dominio.vo.CPF;

import java.util.Optional;

public interface PortaClienteRepositorio {
    Optional<Cliente> findBy(CPF cpf);

    void save(Cliente cliente);
}
