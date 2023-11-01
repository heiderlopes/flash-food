package br.com.fastfood.flashfood.pedido.dominio.modelos;

import br.com.fastfood.flashfood.pedido.dominio.dtos.ItemDoPedidoDTO;

import java.math.BigDecimal;

public class ItemDoPedido {

    private String nomeDoProduto;
    private BigDecimal valorUnitarioDoProduto;

    public ItemDoPedido(String nomeDoProduto, BigDecimal valorUnitarioDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
        this.valorUnitarioDoProduto = valorUnitarioDoProduto;
    }

    public ItemDoPedido(ItemDoPedidoDTO itemDoPedidoDTO) {
        this.nomeDoProduto = itemDoPedidoDTO.getNomeDoProduto();
        this.valorUnitarioDoProduto = itemDoPedidoDTO.getValorUnitarioDoProduto();
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public BigDecimal getValorUnitarioDoProduto() {
        return valorUnitarioDoProduto;
    }

    public ItemDoPedidoDTO toItemDoPedidoDTO() {
        return new ItemDoPedidoDTO(
                nomeDoProduto,
                valorUnitarioDoProduto
        );
    }
}
