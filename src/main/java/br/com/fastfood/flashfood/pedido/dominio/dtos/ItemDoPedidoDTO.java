package br.com.fastfood.flashfood.pedido.dominio.dtos;

import java.math.BigDecimal;

public class ItemDoPedidoDTO {

    private String nomeDoProduto;
    private BigDecimal valorUnitarioDoProduto;


    public ItemDoPedidoDTO(String nomeDoProduto, BigDecimal valorUnitarioDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
        this.valorUnitarioDoProduto = valorUnitarioDoProduto;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public BigDecimal getValorUnitarioDoProduto() {
        return valorUnitarioDoProduto;
    }


    //    public ItemDoPedidoDTO(UUID codigoDoProduto) {
//        this.codigoDoProduto = codigoDoProduto;
//    }

//    public ItemDoPedidoDTO(String codigoDoProduto) {
//        this.codigoDoProduto = UUID.fromString(codigoDoProduto);
//    }
//    public ItemDoPedidoDTO(ItemDoPedido itemDoPedido) {
//        this.codigoDoProduto = itemDoPedido.getCodigoDeIdentificacaoDoProduto().getId().toString();
//    }

//    public ItemDoPedido toItemDoPedido(ItemDoPedidoDTO itemDoPedidoDTO) {
//        return new ItemDoPedido(itemDoPedidoDTO);
//    }

}
