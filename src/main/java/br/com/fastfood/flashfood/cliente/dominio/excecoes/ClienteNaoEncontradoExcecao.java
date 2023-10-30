package br.com.fastfood.flashfood.cliente.dominio.excecoes;

import br.com.fastfood.flashfood.compartilhado.dominio.vo.CPF;

public class ClienteNaoEncontradoExcecao extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ClienteNaoEncontradoExcecao(CPF cpf) {
        super("Cliente nao encontrado com CPF: " + cpf.getNumero());
    }
}
