package br.com.fastfood.flashfood.cliente.infraestrutura.adaptadores.entrada.rest;

import br.com.fastfood.flashfood.cliente.dominio.dtos.ClienteDTO;
import br.com.fastfood.flashfood.cliente.aplicacao.portas.entrada.PortaClienteServico;
import br.com.fastfood.flashfood.compartilhado.dominio.vo.CPF;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Clientes")
@RestController
@RequestMapping("clientes")
public class ClienteController {

    private final PortaClienteServico portaClienteServico;

    public ClienteController(PortaClienteServico portaClienteServico) {
        this.portaClienteServico = portaClienteServico;
    }

    @PostMapping
    void createProduct(@RequestBody ClienteDTO clienteDTO) {
        this.portaClienteServico.criar(clienteDTO);
    }

    @GetMapping("/{cpf}")
    ClienteDTO getCustomerByCPF(@PathVariable("cpf") String cpf) {
        return this.portaClienteServico.buscaClientePor(new CPF(cpf));
    }
}
