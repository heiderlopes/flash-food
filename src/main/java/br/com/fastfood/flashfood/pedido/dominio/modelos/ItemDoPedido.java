package br.com.fastfood.flashfood.pedido.dominio.modelos;

import br.com.fastfood.flashfood.compartilhado.dominio.vo.CodigoDeIdentificacaoDoProduto;
import br.com.fastfood.flashfood.pedido.dominio.dtos.ItemDoPedidoDTO;

public class ItemDoPedido {

    private CodigoDeIdentificacaoDoProduto codigoDeIdentificacaoDoProduto;

    public ItemDoPedido(CodigoDeIdentificacaoDoProduto codigoDeIdentificacaoDoProduto) {
        this.codigoDeIdentificacaoDoProduto = codigoDeIdentificacaoDoProduto;
    }

    public ItemDoPedido(ItemDoPedidoDTO itemDoPedidoDTO) {
        this.codigoDeIdentificacaoDoProduto = itemDoPedidoDTO.getCodigoDeIdentificacaoDoProduto();
    }

    public CodigoDeIdentificacaoDoProduto getCodigoDeIdentificacaoDoProduto() {
        return codigoDeIdentificacaoDoProduto;
    }

    public ItemDoPedidoDTO toItemDoPedidoDTO() {
        return new ItemDoPedidoDTO(codigoDeIdentificacaoDoProduto);
    }
}
