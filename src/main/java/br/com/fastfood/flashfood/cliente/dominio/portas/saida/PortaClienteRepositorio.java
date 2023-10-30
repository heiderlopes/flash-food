package br.com.fastfood.flashfood.cliente.dominio.portas.saida;

import br.com.fastfood.flashfood.cliente.dominio.modelos.Cliente;
import br.com.fastfood.flashfood.compartilhado.dominio.vo.CPF;

public interface PortaClienteRepositorio {
    Cliente findBy(CPF cpf);

    void save(Cliente cliente);
}
