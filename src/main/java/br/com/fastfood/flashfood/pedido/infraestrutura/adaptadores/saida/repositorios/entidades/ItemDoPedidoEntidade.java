package br.com.fastfood.flashfood.pedido.infraestrutura.adaptadores.saida.repositorios.entidades;

import br.com.fastfood.flashfood.pedido.dominio.modelos.ItemDoPedido;
import jakarta.persistence.Embeddable;

import java.math.BigDecimal;

@Embeddable
public class ItemDoPedidoEntidade {
    private String nomeDoProduto;
    private BigDecimal valorUnitarioDoProduto;

    public ItemDoPedidoEntidade() {

    }

    public ItemDoPedidoEntidade(ItemDoPedido itemDoPedido) {
        this.nomeDoProduto = itemDoPedido.getNomeDoProduto();
        this.valorUnitarioDoProduto = itemDoPedido.getValorUnitarioDoProduto();
    }


    public ItemDoPedido toItemDoPedido() {
        return new ItemDoPedido(
                nomeDoProduto,
                valorUnitarioDoProduto
        );
    }
}
