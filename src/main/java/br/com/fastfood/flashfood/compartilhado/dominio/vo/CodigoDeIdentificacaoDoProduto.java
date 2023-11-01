package br.com.fastfood.flashfood.compartilhado.dominio.vo;

import java.util.UUID;

public class CodigoDeIdentificacaoDoProduto {

    private UUID id;
    public CodigoDeIdentificacaoDoProduto(UUID id) {
        this.id = id;
    }
    public UUID getId() {
        return id;
    }


}