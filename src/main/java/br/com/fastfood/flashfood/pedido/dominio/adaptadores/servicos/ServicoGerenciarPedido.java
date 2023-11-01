package br.com.fastfood.flashfood.pedido.dominio.adaptadores.servicos;

import br.com.fastfood.flashfood.compartilhado.dominio.vo.CodigoDeIdentificacaoDoPedido;
import br.com.fastfood.flashfood.pedido.aplicacao.portas.entrada.PortaGerenciarPedidoServico;
import br.com.fastfood.flashfood.pedido.aplicacao.portas.saida.PortaPagamentoRepositorio;
import br.com.fastfood.flashfood.pedido.aplicacao.portas.saida.PortaPedidoRepositorio;
import br.com.fastfood.flashfood.pedido.dominio.dtos.PagamentoDTO;
import br.com.fastfood.flashfood.pedido.dominio.dtos.PedidoDTO;
import br.com.fastfood.flashfood.pedido.dominio.dtos.PedidoStatusDTO;
import br.com.fastfood.flashfood.pedido.dominio.excecao.PedidoNaoEncontradoExcecao;
import br.com.fastfood.flashfood.pedido.dominio.modelos.Pagamento;
import br.com.fastfood.flashfood.pedido.dominio.modelos.Pedido;
import br.com.fastfood.flashfood.pedido.dominio.modelos.PedidoStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class ServicoGerenciarPedido implements PortaGerenciarPedidoServico {

    private final PortaPedidoRepositorio repositorioPedido;
    private final PortaPagamentoRepositorio repositorioPagamento;

    public ServicoGerenciarPedido(PortaPedidoRepositorio repositorioPedido, PortaPagamentoRepositorio repositorioPagamento) {
        this.repositorioPedido = repositorioPedido;
        this.repositorioPagamento = repositorioPagamento;
    }

    @Override
    public PedidoDTO criarPedido(PedidoDTO pedidoDTO) {
        return repositorioPedido.salvar(new Pedido(pedidoDTO)).toPedidoDTO();
    }

    @Override
    public PedidoDTO pagarPedido(PagamentoDTO pagamentoDTO) {
        Optional<Pedido> pedido = repositorioPedido.buscaPedidoPor(new CodigoDeIdentificacaoDoPedido(pagamentoDTO.getIdDoPedido()));
        if(pedido.isEmpty()) {
            throw new PedidoNaoEncontradoExcecao(new CodigoDeIdentificacaoDoPedido(pagamentoDTO.getIdDoPedido()));
        } else {
            repositorioPagamento.pagar(new Pagamento(pagamentoDTO));
            pedido.get().adicionarPedidoAFila();
            return repositorioPedido.salvar(pedido.get()).toPedidoDTO();
        }
    }

    @Override
    public PedidoDTO colocarPedidoNaFilaDePreparacao(UUID idDoPedido) {
        CodigoDeIdentificacaoDoPedido id = new CodigoDeIdentificacaoDoPedido(idDoPedido);
        Optional<Pedido> pedido = repositorioPedido.buscaPedidoPor(new CodigoDeIdentificacaoDoPedido(id.getId()));
        if(pedido.isEmpty()) {
            throw new PedidoNaoEncontradoExcecao(id);
        } else {
            pedido.get().adicionarPedidoAFila();
            repositorioPedido.salvar(pedido.get());
            return pedido.get().toPedidoDTO();
        }
    }

    @Override
    public PedidoDTO iniciarPreparacaoDoPedido(UUID idDoPedido) {
        CodigoDeIdentificacaoDoPedido id = new CodigoDeIdentificacaoDoPedido(idDoPedido);
        Optional<Pedido> pedido = repositorioPedido.buscaPedidoPor(new CodigoDeIdentificacaoDoPedido(id.getId()));
        if(pedido.isEmpty()) {
            throw new PedidoNaoEncontradoExcecao(id);
        } else {
            pedido.get().marcarComoEmPreparacao();
            repositorioPedido.salvar(pedido.get());
            return pedido.get().toPedidoDTO();
        }
    }

    @Override
    public PedidoDTO finalizarPreparacaoDoPedido(UUID idDoPedido) {
        CodigoDeIdentificacaoDoPedido id = new CodigoDeIdentificacaoDoPedido(idDoPedido);
        Optional<Pedido> pedido = repositorioPedido.buscaPedidoPor(new CodigoDeIdentificacaoDoPedido(id.getId()));

        if(pedido.isEmpty()) {
            throw new PedidoNaoEncontradoExcecao(id);
        } else {
            pedido.get().marcarComoPronto();
            repositorioPedido.salvar(pedido.get());
            return pedido.get().toPedidoDTO();
        }
    }

    @Override
    public PedidoDTO entregarPedido(UUID idDoPedido) {
        CodigoDeIdentificacaoDoPedido id = new CodigoDeIdentificacaoDoPedido(idDoPedido);
        Optional<Pedido> pedido = repositorioPedido.buscaPedidoPor(new CodigoDeIdentificacaoDoPedido(id.getId()));

        if(pedido.isEmpty()) {
            throw new PedidoNaoEncontradoExcecao(id);
        } else {
            pedido.get().marcarPedidoComoFinalizado();
            repositorioPedido.salvar(pedido.get());
            return pedido.get().toPedidoDTO();
        }
    }

    @Override
    public List<PedidoDTO> buscarPedidosPor(PedidoStatusDTO pedidoStatusDTO) {
        PedidoStatus pedidoStatus = PedidoStatus.valueOf(pedidoStatusDTO.name());
        List<Pedido> pedidos = this.repositorioPedido.buscaPedidoPor(pedidoStatus);
        return pedidos.stream().map(Pedido::toPedidoDTO).collect(Collectors.toList());
    }
}
