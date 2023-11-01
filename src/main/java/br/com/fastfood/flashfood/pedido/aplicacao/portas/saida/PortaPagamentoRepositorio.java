package br.com.fastfood.flashfood.pedido.aplicacao.portas.saida;

import br.com.fastfood.flashfood.pedido.dominio.modelos.Pagamento;

public interface PortaPagamentoRepositorio {

    void pagar(Pagamento pagamento);

}


