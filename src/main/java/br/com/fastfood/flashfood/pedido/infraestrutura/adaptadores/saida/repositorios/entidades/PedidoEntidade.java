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
import java.util.stream.Collectors;

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

    //@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
//    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
//    private List<ItemDoPedidoEntidade> itensDoPedido;

    @ElementCollection
    @CollectionTable(name = "pedido_items", joinColumns = @JoinColumn(name = "pedido_id"))
    private List<ItemDoPedidoEntidade> itensDoPedido = new ArrayList<>();

    public PedidoEntidade() {

    }

    public PedidoEntidade(Pedido pedido) {
        //this.id = pedido.getCodigoDeIdentificacaoDoPedido().getId();
        this.id = UUID.randomUUID();
        if (pedido.getCpfDoCliente() != null) this.cpf = pedido.getCpfDoCliente().getNumero();
        this.status = pedido.getStatus();
        this.valorTotal = pedido.getValorTotal();
        this.itensDoPedido = pedido.getItensDoPedido().stream().map(ItemDoPedidoEntidade::new).collect(Collectors.toList());
    }

    public Pedido toPedido() {
        return new Pedido(
                (this.cpf == null) ? null : new CPF(this.cpf),
                new CodigoDeIdentificacaoDoPedido(UUID.randomUUID()),
                this.itensDoPedido.stream().map(ItemDoPedidoEntidade::toItemDoPedido).collect(Collectors.toList()),
                this.status, valorTotal
        );
    }
}
