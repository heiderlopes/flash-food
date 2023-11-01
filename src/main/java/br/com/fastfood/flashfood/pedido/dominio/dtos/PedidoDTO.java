package br.com.fastfood.flashfood.pedido.dominio.dtos;

import java.math.BigDecimal;
import java.util.List;

public class PedidoDTO {
    private String cpfDoCliente;

    private List<ItemDoPedidoDTO> itensDoPedido;

    private BigDecimal valorTotal;

    public PedidoDTO(
            List<ItemDoPedidoDTO> itensDoPedido,
            String cpfDoCliente,
            BigDecimal valorTotal) {

        this.itensDoPedido = itensDoPedido;
        this.cpfDoCliente = cpfDoCliente;
        this.valorTotal = valorTotal;

    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public List<ItemDoPedidoDTO> getItensDoPedido() {
        return itensDoPedido;
    }

    public String getCpfDoCliente() {
        return cpfDoCliente;
    }
}
