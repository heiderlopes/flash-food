package br.com.fastfood.flashfood.cliente.dominio.adaptadores.servicos;

import br.com.fastfood.flashfood.cliente.aplicacao.portas.entrada.PortaClienteServico;
import br.com.fastfood.flashfood.cliente.aplicacao.portas.saida.PortaClienteRepositorio;
import br.com.fastfood.flashfood.cliente.dominio.dtos.ClienteDTO;
import br.com.fastfood.flashfood.cliente.dominio.excecoes.ClienteJaCadastradoExcecao;
import br.com.fastfood.flashfood.cliente.dominio.excecoes.ClienteNaoEncontradoExcecao;
import br.com.fastfood.flashfood.cliente.dominio.modelos.Cliente;
import br.com.fastfood.flashfood.compartilhado.dominio.vo.CPF;

import java.util.Optional;

public class ClienteServicoImpl implements PortaClienteServico {

    private final PortaClienteRepositorio customerRepository;

    public ClienteServicoImpl(PortaClienteRepositorio customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public ClienteDTO buscaClientePor(CPF cpf) {
        Optional<Cliente> cliente = this.customerRepository.findBy(cpf);
        if(cliente.isEmpty()) {
            throw new ClienteNaoEncontradoExcecao(cpf);
        } else {
            return new ClienteDTO(cliente.get());
        }

    }

    @Override
    public void criar(ClienteDTO clienteDTO) {
        Optional<Cliente> clienteCadastrado = this.customerRepository.findBy(new CPF(clienteDTO.getCpf()));
        if (clienteCadastrado.isEmpty()) {
            Cliente cliente = new Cliente(clienteDTO);
            this.customerRepository.save(cliente);
        } else {
            throw new ClienteJaCadastradoExcecao(new CPF(clienteDTO.getCpf()));
        }
    }
}
