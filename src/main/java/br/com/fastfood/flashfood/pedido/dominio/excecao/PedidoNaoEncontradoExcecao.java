package br.com.fastfood.flashfood.pedido.dominio.excecao;

import br.com.fastfood.flashfood.compartilhado.dominio.vo.CodigoDeIdentificacaoDoPedido;

public class PedidoNaoEncontradoExcecao extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public PedidoNaoEncontradoExcecao(CodigoDeIdentificacaoDoPedido codigoDeIdentificacaoDoPedido) {
        super("Pedido " + codigoDeIdentificacaoDoPedido.getId() + " não encontrado");
    }
}