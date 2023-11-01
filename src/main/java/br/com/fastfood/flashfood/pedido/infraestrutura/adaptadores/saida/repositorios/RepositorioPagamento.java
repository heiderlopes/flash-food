package br.com.fastfood.flashfood.pedido.infraestrutura.adaptadores.saida.repositorios;

import br.com.fastfood.flashfood.pedido.aplicacao.portas.saida.PortaPagamentoRepositorio;
import br.com.fastfood.flashfood.pedido.dominio.modelos.Pagamento;
import br.com.fastfood.flashfood.pedido.infraestrutura.adaptadores.saida.repositorios.entidades.PagamentoEntidade;
import org.springframework.stereotype.Component;

@Component
public class RepositorioPagamento implements PortaPagamentoRepositorio {

    private final RepositorioPagamentoSpring repositorioPagamentoSpring;

    public RepositorioPagamento(RepositorioPagamentoSpring repositorioPagamentoSpring) {
        this.repositorioPagamentoSpring = repositorioPagamentoSpring;
    }

    @Override
    public void pagar(Pagamento pagamento) {
        PagamentoEntidade pagamentoEntidade = new PagamentoEntidade(pagamento);
        this.repositorioPagamentoSpring.save(pagamentoEntidade);
    }
}
