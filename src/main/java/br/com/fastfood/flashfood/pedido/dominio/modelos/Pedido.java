package br.com.fastfood.flashfood.pedido.dominio.modelos;

import br.com.fastfood.flashfood.compartilhado.dominio.vo.CPF;
import br.com.fastfood.flashfood.compartilhado.dominio.vo.CodigoDeIdentificacaoDoPedido;
import br.com.fastfood.flashfood.pedido.dominio.dtos.PedidoDTO;
import br.com.fastfood.flashfood.pedido.dominio.excecao.AtualizacaoDeStatusDoPedidoExcecao;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static br.com.fastfood.flashfood.pedido.dominio.modelos.PedidoStatus.AGUARDANDO_PAGAMENTO;
import static br.com.fastfood.flashfood.pedido.dominio.modelos.PedidoStatus.RECEBIDO;

public class Pedido {

    private CodigoDeIdentificacaoDoPedido codigoDeIdentificacaoDoPedido;
    private CPF cpfDoCliente;
    private List<String> itensDoPedido;

    private BigDecimal valorTotal;
    private PedidoStatus status;

    public Pedido(CPF cpfDoCliente, List<String> itensDoPedido, BigDecimal valorTotal) {
        this.cpfDoCliente = cpfDoCliente;
        this.codigoDeIdentificacaoDoPedido = new CodigoDeIdentificacaoDoPedido(UUID.randomUUID());
        this.itensDoPedido = itensDoPedido;
        this.valorTotal = valorTotal;
        this.status = AGUARDANDO_PAGAMENTO;
    }

    public Pedido(CPF cpdDoCliente, CodigoDeIdentificacaoDoPedido codigoDeIdentificacaoDoPedido, List<String> itensDoPedido, PedidoStatus status, BigDecimal valorTotal) {
        this.cpfDoCliente = cpdDoCliente;
        this.codigoDeIdentificacaoDoPedido = codigoDeIdentificacaoDoPedido;
        this.itensDoPedido = itensDoPedido;
        this.valorTotal = valorTotal;
        this.status = status;
    }

    public Pedido(PedidoDTO pedidoDTO) {
        this.codigoDeIdentificacaoDoPedido = new CodigoDeIdentificacaoDoPedido(UUID.randomUUID());
        this.cpfDoCliente = pedidoDTO.getCpfDoCliente();
        this.itensDoPedido = pedidoDTO.getItensDoPedido();
        this.valorTotal = pedidoDTO.getValorTotal();
        this.status = AGUARDANDO_PAGAMENTO;
    }

    public CodigoDeIdentificacaoDoPedido getCodigoDeIdentificacaoDoPedido() {
        return codigoDeIdentificacaoDoPedido;
    }

    public CPF getCpfDoCliente() {
        return cpfDoCliente;
    }

    public List<String> getItensDoPedido() {
        return itensDoPedido;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public PedidoStatus getStatus() {
        return status;
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
        return new PedidoDTO(this.getItensDoPedido(), this.cpfDoCliente, this.getValorTotal());
    }
}
