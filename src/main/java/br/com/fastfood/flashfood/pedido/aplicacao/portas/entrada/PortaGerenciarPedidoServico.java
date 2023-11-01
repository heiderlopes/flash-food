package br.com.fastfood.flashfood.pedido.aplicacao.portas.entrada;

import br.com.fastfood.flashfood.pedido.dominio.dtos.PagamentoDTO;
import br.com.fastfood.flashfood.pedido.dominio.dtos.PedidoDTO;
import br.com.fastfood.flashfood.pedido.dominio.dtos.PedidoStatusDTO;

import java.util.List;
import java.util.UUID;

public interface PortaGerenciarPedidoServico {

    PedidoDTO criarPedido(PedidoDTO pedidoDTO);

    PedidoDTO pagarPedido(PagamentoDTO pagamentoDTO);

    PedidoDTO colocarPedidoNaFilaDePreparacao(UUID idDoPedido);
    PedidoDTO iniciarPreparacaoDoPedido(UUID idDoPedido);

    PedidoDTO finalizarPreparacaoDoPedido(UUID idDoPedido);
    PedidoDTO entregarPedido(UUID idDoPedido);

    List<PedidoDTO> buscarPedidosPor(PedidoStatusDTO pedidoStatusDTO);

}
