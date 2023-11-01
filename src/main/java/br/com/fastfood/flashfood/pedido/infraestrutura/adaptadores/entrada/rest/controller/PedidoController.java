package br.com.fastfood.flashfood.pedido.infraestrutura.adaptadores.entrada.rest.controller;

import br.com.fastfood.flashfood.pedido.aplicacao.portas.entrada.PortaGerenciarPedidoServico;
import br.com.fastfood.flashfood.pedido.dominio.dtos.PagamentoDTO;
import br.com.fastfood.flashfood.pedido.dominio.dtos.PedidoDTO;
import br.com.fastfood.flashfood.pedido.dominio.dtos.PedidoStatusDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Pedido")
@RestController
@RequestMapping("pedidos")
public class PedidoController {

    private final PortaGerenciarPedidoServico portaGerenciarPedidoServico;

    public PedidoController(PortaGerenciarPedidoServico portaGerenciarPedidoServico) {
        this.portaGerenciarPedidoServico = portaGerenciarPedidoServico;
    }

    @GetMapping("/status/{statusDoPedido}")
    List<PedidoDTO> buscarPedidosPor(@PathVariable("statusDoPedido")PedidoStatusDTO pedidoStatusDTO) {
        return this.portaGerenciarPedidoServico.buscarPedidosPor(pedidoStatusDTO);
    }

    @PostMapping
    void criarPedido(@RequestBody PedidoDTO pedidoDTO) {
        this.portaGerenciarPedidoServico.criarPedido(pedidoDTO);
    }


    @PostMapping("pagar")
    void pagarPedido(@RequestBody PagamentoDTO pagamentoDTO) {
        this.portaGerenciarPedidoServico.pagarPedido(pagamentoDTO);
    }

    @PutMapping("/iniciarpreparacao/{idDoPedido}")
    void iniciarPreparacao(@PathVariable("idDoPedido") UUID idDoPedido) {
        this.portaGerenciarPedidoServico.iniciarPreparacaoDoPedido(idDoPedido);
    }

    @PutMapping("/finalizarpreparacao/{idDoPedido}")
    void finalizarPreparacao(@PathVariable("idDoPedido") UUID idDoPedido) {
        this.portaGerenciarPedidoServico.finalizarPreparacaoDoPedido(idDoPedido);
    }

    @PutMapping("/entregarpedido/{idDoPedido}")
    void entregarPedido(@PathVariable("idDoPedido") UUID idDoPedido) {
        this.portaGerenciarPedidoServico.entregarPedido(idDoPedido);
    }
}