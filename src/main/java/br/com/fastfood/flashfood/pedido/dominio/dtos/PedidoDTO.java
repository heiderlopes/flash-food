package br.com.fastfood.flashfood.pedido.dominio.dtos;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class PedidoDTO {
    private String cpfDoCliente;

    private List<ItemDoPedidoDTO> itensDoPedido;

    private BigDecimal valorTotal;

    private PedidoStatusDTO status;

    public PedidoDTO(
            List<ItemDoPedidoDTO> itensDoPedido,
            String cpfDoCliente,
            BigDecimal valorTotal,
            PedidoStatusDTO status) {

        this.itensDoPedido = itensDoPedido;
        this.cpfDoCliente = cpfDoCliente;
        this.valorTotal = valorTotal;
        this.status = Objects.requireNonNullElse(status, PedidoStatusDTO.AGUARDANDO_PAGAMENTO);

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

    public PedidoStatusDTO getStatus() {
        return status;
    }
}
