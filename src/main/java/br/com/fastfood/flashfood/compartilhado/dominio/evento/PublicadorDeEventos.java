package br.com.fastfood.flashfood.compartilhado.dominio.evento;

import java.util.ArrayList;
import java.util.List;

public class PublicadorDeEventos {


    private List<OuvinteEvento> ouvintes = new ArrayList<>();

    public void adicionar(OuvinteEvento ouvinteEvento) {
        this.ouvintes.add(ouvinteEvento);
    }

    public void publicar(Evento evento) {
        this.ouvintes.forEach(o -> {
            o.processa(evento);
        });
    }

}