package br.com.fastfood.flashfood.pedido.dominio.modelos;

import br.com.fastfood.flashfood.compartilhado.dominio.vo.CPF;
import br.com.fastfood.flashfood.compartilhado.dominio.vo.CodigoDeIdentificacaoDoPedido;
import br.com.fastfood.flashfood.pedido.dominio.dtos.PedidoDTO;
import br.com.fastfood.flashfood.pedido.dominio.dtos.PedidoStatusDTO;
import br.com.fastfood.flashfood.pedido.dominio.excecao.AtualizacaoDeStatusDoPedidoExcecao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static br.com.fastfood.flashfood.pedido.dominio.modelos.PedidoStatus.AGUARDANDO_PAGAMENTO;
import static br.com.fastfood.flashfood.pedido.dominio.modelos.PedidoStatus.RECEBIDO;

public class Pedido {

    private CodigoDeIdentificacaoDoPedido codigoDeIdentificacaoDoPedido;

    private LocalDateTime dataDoPedido;
    private CPF cpfDoCliente;
    private List<ItemDoPedido> itensDoPedido;

    private BigDecimal valorTotal;
    private PedidoStatus status;

    public Pedido(CPF cpdDoCliente, CodigoDeIdentificacaoDoPedido codigoDeIdentificacaoDoPedido, List<ItemDoPedido> itensDoPedido, PedidoStatus status, BigDecimal valorTotal, LocalDateTime dataDoPedido) {
        this.cpfDoCliente = cpdDoCliente;
        this.codigoDeIdentificacaoDoPedido = codigoDeIdentificacaoDoPedido;
        this.itensDoPedido = itensDoPedido;
        this.valorTotal = valorTotal;
        this.status = status;
        this.dataDoPedido = dataDoPedido;
    }

    public Pedido(PedidoDTO pedidoDTO) {
        this.codigoDeIdentificacaoDoPedido = new CodigoDeIdentificacaoDoPedido(UUID.randomUUID());
        this.cpfDoCliente = new CPF(pedidoDTO.getCpfDoCliente());
        this.itensDoPedido = pedidoDTO.getItensDoPedido().stream().map(ItemDoPedido::new).collect(Collectors.toList());
        this.valorTotal = pedidoDTO.getValorTotal();
        this.status = AGUARDANDO_PAGAMENTO;
        this.dataDoPedido = LocalDateTime.now();
    }

    public CodigoDeIdentificacaoDoPedido getCodigoDeIdentificacaoDoPedido() {
        return codigoDeIdentificacaoDoPedido;
    }

    public CPF getCpfDoCliente() {
        return cpfDoCliente;
    }

    public List<ItemDoPedido> getItensDoPedido() {
        return itensDoPedido;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public PedidoStatus getStatus() {
        return status;
    }


    public LocalDateTime getDataDoPedido() {
        return dataDoPedido;
    }

    public Pedido adicionarPedidoAFila() {
        if (status != AGUARDANDO_PAGAMENTO) {
            throw new AtualizacaoDeStatusDoPedidoExcecao("Pedido não está pago");
        }
        status = RECEBIDO;
        return this;
    }

    public Pedido marcarComoEmPreparacao() {
        if (status != RECEBIDO) {
            throw new AtualizacaoDeStatusDoPedidoExcecao("Pedido não foi pago.");
        }
        status = PedidoStatus.EM_PREPARACAO;
        return this;
    }

    public Pedido marcarComoPronto() {
        if (status != PedidoStatus.EM_PREPARACAO) {
            throw new AtualizacaoDeStatusDoPedidoExcecao("Pedido não está em preparacao");
        }
        status = PedidoStatus.PRONTO;
        return this;
    }

    public Pedido marcarPedidoComoFinalizado() {
        if (status != PedidoStatus.PRONTO) {
            throw new AtualizacaoDeStatusDoPedidoExcecao("Pedido não está pronto");
        }
        status = PedidoStatus.FINALIZADO;
        return this;
    }

    public PedidoDTO toPedidoDTO() {

        return new PedidoDTO(
                this.getItensDoPedido().stream().map(ItemDoPedido::toItemDoPedidoDTO).collect(Collectors.toList()),
                (this.getCpfDoCliente() == null) ? null : this.cpfDoCliente.getNumero(),
                this.getValorTotal(),
                PedidoStatusDTO.valueOf(this.status.name())
        );
    }
}
