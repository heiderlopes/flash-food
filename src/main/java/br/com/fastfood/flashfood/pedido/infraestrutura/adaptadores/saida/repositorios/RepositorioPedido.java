package br.com.fastfood.flashfood.pedido.infraestrutura.adaptadores.saida.repositorios;

import br.com.fastfood.flashfood.compartilhado.dominio.vo.CodigoDeIdentificacaoDoPedido;
import br.com.fastfood.flashfood.pedido.aplicacao.portas.saida.PortaPedidoRepositorio;
import br.com.fastfood.flashfood.pedido.dominio.modelos.Pedido;
import br.com.fastfood.flashfood.pedido.dominio.modelos.PedidoStatus;
import br.com.fastfood.flashfood.pedido.infraestrutura.adaptadores.saida.repositorios.entidades.PedidoEntidade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Component
public class RepositorioPedido implements PortaPedidoRepositorio {

    private final RepositorioPedidoSpring repositorioPedidoSpring;

    public RepositorioPedido(RepositorioPedidoSpring repositorioPedidoSpring) {
        this.repositorioPedidoSpring = repositorioPedidoSpring;
    }

    @Override
    public Optional<Pedido> buscaPedidoPor(CodigoDeIdentificacaoDoPedido codigoDeIdentificacaoDoPedido) {
        return repositorioPedidoSpring.findById(codigoDeIdentificacaoDoPedido.getId()).map(PedidoEntidade::toPedido);
    }

    @Override
    public Pedido salvar(Pedido pedido) {

        PedidoEntidade pedidoEntidade = new PedidoEntidade(pedido);
        pedidoEntidade = repositorioPedidoSpring.save(pedidoEntidade);
        return pedidoEntidade.toPedido();

    }

    @Override
    public List<Pedido> buscaPedidoPor(PedidoStatus status) {
        List<PedidoEntidade> pedidoEntidades = this.repositorioPedidoSpring.findByStatus(status);
        return pedidoEntidades.stream().map(PedidoEntidade::toPedido).collect(toList());
    }
}