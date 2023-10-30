package br.com.fastfood.flashfood.cliente.dominio.adaptadores.servicos;

import br.com.fastfood.flashfood.cliente.dominio.dtos.ClienteDTO;
import br.com.fastfood.flashfood.cliente.dominio.modelos.Cliente;
import br.com.fastfood.flashfood.cliente.dominio.portas.entrada.PortaClienteServico;
import br.com.fastfood.flashfood.cliente.dominio.portas.saida.PortaClienteRepositorio;
import br.com.fastfood.flashfood.compartilhado.dominio.vo.CPF;

public class ClienteServicoImpl implements PortaClienteServico {

    private final PortaClienteRepositorio customerRepository;

    public ClienteServicoImpl(PortaClienteRepositorio customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public ClienteDTO getCustomerBy(CPF cpf) {
        Cliente cliente = this.customerRepository.findBy(cpf);
        return new ClienteDTO(cliente);
    }

    @Override
    public void createCustomer(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente(clienteDTO);
        this.customerRepository.save(cliente);
    }
}
