package br.com.fastfood.flashfood.pedido.dominio.modelos;

import br.com.fastfood.flashfood.compartilhado.dominio.vo.CodigoDeIdentificacaoDoPedido;
import br.com.fastfood.flashfood.pedido.dominio.dtos.PagamentoDTO;
import br.com.fastfood.flashfood.pedido.dominio.vo.CartaoDeCredito;

import java.time.LocalDateTime;

public class Pagamento {

    private CodigoDeIdentificacaoDoPedido idDoPedido;

    private CartaoDeCredito cartaoDeCredito;
    private LocalDateTime dataPagamento;

    public Pagamento(CodigoDeIdentificacaoDoPedido idDoPedido, CartaoDeCredito cartaoDeCredito, LocalDateTime dataPagamento) {
        this.idDoPedido = idDoPedido;
        this.cartaoDeCredito = cartaoDeCredito;
        this.dataPagamento = dataPagamento;
    }

    public Pagamento(PagamentoDTO pagamentoDTO) {
        this.idDoPedido = new CodigoDeIdentificacaoDoPedido(pagamentoDTO.getIdDoPedido());
        this.cartaoDeCredito = pagamentoDTO.getCartaoDeCredito();
        this.dataPagamento = LocalDateTime.now();
    }

    public CodigoDeIdentificacaoDoPedido getIdDoPedido() {
        return idDoPedido;
    }

    public CartaoDeCredito getCartaoDeCredito() {
        return cartaoDeCredito;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }
}
