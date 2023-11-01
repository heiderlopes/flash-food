package br.com.fastfood.flashfood.pedido.dominio.dtos;

import br.com.fastfood.flashfood.pedido.dominio.vo.CartaoDeCredito;

import java.util.UUID;

public class PagamentoDTO {

    private UUID idDoPedido;

    private CartaoDeCredito cartaoDeCredito;

    public PagamentoDTO(UUID idDoPedido, CartaoDeCredito cartaoDeCredito) {
        this.idDoPedido = idDoPedido;
        this.cartaoDeCredito = cartaoDeCredito;
    }

    public UUID getIdDoPedido() {
        return idDoPedido;
    }

    public CartaoDeCredito getCartaoDeCredito() {
        return cartaoDeCredito;
    }
}
