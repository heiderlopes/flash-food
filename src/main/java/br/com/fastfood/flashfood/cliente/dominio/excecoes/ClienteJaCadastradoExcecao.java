package br.com.fastfood.flashfood.cliente.dominio.excecoes;

import br.com.fastfood.flashfood.compartilhado.dominio.vo.CPF;

public class ClienteJaCadastradoExcecao extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ClienteJaCadastradoExcecao(CPF cpf) {
        super("Cliente com CPF: " + cpf.getNumero() + " já cadastrado");
    }
}