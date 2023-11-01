package br.com.fastfood.flashfood.pedido.aplicacao.portas.saida;

import br.com.fastfood.flashfood.compartilhado.dominio.vo.CodigoDeIdentificacaoDoPedido;
import br.com.fastfood.flashfood.pedido.dominio.modelos.Pedido;
import br.com.fastfood.flashfood.pedido.dominio.modelos.PedidoStatus;

import java.util.List;
import java.util.Optional;

public interface PortaPedidoRepositorio {

    Optional<Pedido> buscaPedidoPor(CodigoDeIdentificacaoDoPedido codigoDeIdentificacaoDoPedido);
    Pedido salvar(Pedido pedido);

    List<Pedido> buscaPedidoPor(PedidoStatus status);

}
