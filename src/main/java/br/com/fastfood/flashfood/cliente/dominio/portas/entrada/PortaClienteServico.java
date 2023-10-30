package br.com.fastfood.flashfood.cliente.dominio.portas.entrada;

import br.com.fastfood.flashfood.cliente.dominio.dtos.ClienteDTO;
import br.com.fastfood.flashfood.compartilhado.dominio.vo.CPF;

public interface PortaClienteServico {

    ClienteDTO getCustomerBy(CPF cpf);

    void createCustomer(ClienteDTO clienteDTO);

}
