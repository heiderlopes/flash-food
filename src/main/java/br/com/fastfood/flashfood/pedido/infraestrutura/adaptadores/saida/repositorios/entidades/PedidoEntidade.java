package br.com.fastfood.flashfood.pedido.infraestrutura.adaptadores.saida.repositorios.entidades;

import br.com.fastfood.flashfood.compartilhado.dominio.vo.CPF;
import br.com.fastfood.flashfood.compartilhado.dominio.vo.CodigoDeIdentificacaoDoPedido;
import br.com.fastfood.flashfood.pedido.dominio.modelos.Pedido;
import br.com.fastfood.flashfood.pedido.dominio.modelos.PedidoStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pedidos")
public class PedidoEntidade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private PedidoStatus status;

    private String cpf;

    private BigDecimal valorTotal;

    @ElementCollection
    @CollectionTable(name = "pedido_itens")
    private List<String> itensDoPedido = new ArrayList<>();

    public PedidoEntidade() {

    }

    public PedidoEntidade(Pedido pedido) {
        this.id = pedido.getCodigoDeIdentificacaoDoPedido().getId();
        if (pedido.getCpfDoCliente() != null) this.cpf = pedido.getCpfDoCliente().getNumero();
        this.status = pedido.getStatus();
        this.valorTotal = pedido.getValorTotal();
        this.itensDoPedido = pedido.getItensDoPedido();
    }

    public Pedido toPedido() {
        return new Pedido(
                (this.cpf == null) ? null : new CPF(this.cpf),
                new CodigoDeIdentificacaoDoPedido(this.id),
                this.itensDoPedido,
                this.status, valorTotal
        );
    }
}
