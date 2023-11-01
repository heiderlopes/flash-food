package br.com.fastfood.flashfood.compartilhado.dominio.vo;

import java.util.UUID;

public class CodigoDeIdentificacaoDoPedido {

    private UUID id;
    public CodigoDeIdentificacaoDoPedido(UUID id) {
        this.id = id;
    }
    public UUID getId() {
        return id;
    }


}