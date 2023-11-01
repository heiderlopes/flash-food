package br.com.fastfood.flashfood.pedido.dominio.dtos;

import br.com.fastfood.flashfood.compartilhado.dominio.vo.CodigoDeIdentificacaoDoProduto;
import br.com.fastfood.flashfood.pedido.dominio.modelos.ItemDoPedido;

public class ItemDoPedidoDTO {

    private CodigoDeIdentificacaoDoProduto codigoDeIdentificacaoDoProduto;

    public ItemDoPedidoDTO(ItemDoPedido itemDoPedido) {
        this.codigoDeIdentificacaoDoProduto = itemDoPedido.getCodigoDeIdentificacaoDoProduto();
    }

    public ItemDoPedidoDTO(CodigoDeIdentificacaoDoProduto codigoDeIdentificacaoDoProduto) {
        this.codigoDeIdentificacaoDoProduto = codigoDeIdentificacaoDoProduto;
    }

    public CodigoDeIdentificacaoDoProduto getCodigoDeIdentificacaoDoProduto() {
        return codigoDeIdentificacaoDoProduto;
    }

}
