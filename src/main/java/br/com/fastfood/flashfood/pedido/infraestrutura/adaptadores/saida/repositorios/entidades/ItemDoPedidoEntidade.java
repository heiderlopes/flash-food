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

//    public ItemDoPedidoEntidade(UUID id, UUID idDoProduto, String nomeDoProduto, BigDecimal valorUnitarioDoProduto, PedidoEntidade pedido) {
//        this.id = id;
//        this.idDoProduto = idDoProduto;
//        this.nomeDoProduto = nomeDoProduto;
//        this.valorUnitarioDoProduto = valorUnitarioDoProduto;
//        this.pedido = pedido;
//    }

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
