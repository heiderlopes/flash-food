package br.com.fastfood.flashfood.pedido.dominio.dtos;

import br.com.fastfood.flashfood.compartilhado.dominio.vo.CPF;

import java.math.BigDecimal;
import java.util.List;

public class PedidoDTO {
    private CPF cpfDoCliente;

    private List<String> itensDoPedido;

    private BigDecimal valorTotal;

    public PedidoDTO(List<String> itensDoPedido, CPF cpfDoCliente, BigDecimal valorTotal) {
        this.itensDoPedido = itensDoPedido;
        this.cpfDoCliente = cpfDoCliente;
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public List<String> getItensDoPedido() {
        return itensDoPedido;
    }

    public CPF getCpfDoCliente() {
        return cpfDoCliente;
    }
}
