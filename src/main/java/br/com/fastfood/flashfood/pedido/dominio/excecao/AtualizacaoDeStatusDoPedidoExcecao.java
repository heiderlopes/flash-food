package br.com.fastfood.flashfood.pedido.dominio.excecao;

public class AtualizacaoDeStatusDoPedidoExcecao extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AtualizacaoDeStatusDoPedidoExcecao(String mensagem) {
        super(mensagem);
    }
}


