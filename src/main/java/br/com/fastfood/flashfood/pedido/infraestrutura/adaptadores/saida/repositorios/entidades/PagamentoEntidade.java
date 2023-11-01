package br.com.fastfood.flashfood.pedido.infraestrutura.adaptadores.saida.repositorios.entidades;

import br.com.fastfood.flashfood.pedido.dominio.modelos.Pagamento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "pagamentos")
public class PagamentoEntidade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID idDoPedido;
    private LocalDate dataPagamento;

    private String nomeCartao;

    private String numeroCartao;

    private int mesExpiracao;

    private int anoExpiracao;


    public PagamentoEntidade() {

    }

    public PagamentoEntidade(Pagamento pagamento) {
        this.id = UUID.randomUUID();
        this.idDoPedido = pagamento.getIdDoPedido().getId();
        this.dataPagamento = LocalDate.now();
        this.nomeCartao = pagamento.getCartaoDeCredito().getNome();
        this.numeroCartao = pagamento.getCartaoDeCredito().getNumero();
        this.mesExpiracao = pagamento.getCartaoDeCredito().getMesExpiracao();
        this.anoExpiracao = pagamento.getCartaoDeCredito().getAnoExpiracao();
    }

    public UUID getId() {
        return id;
    }

    public UUID getIdDoPedido() {
        return idDoPedido;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public String getNomeCartao() {
        return nomeCartao;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public int getMesExpiracao() {
        return mesExpiracao;
    }

    public int getAnoExpiracao() {
        return anoExpiracao;
    }
}
