package br.com.fastfood.flashfood.cliente.aplicacao.portas.entrada;

import br.com.fastfood.flashfood.cliente.dominio.dtos.ClienteDTO;
import br.com.fastfood.flashfood.compartilhado.dominio.vo.CPF;

public interface PortaClienteServico {

    ClienteDTO buscaClientePor(CPF cpf);

    void criar(ClienteDTO clienteDTO);

}
