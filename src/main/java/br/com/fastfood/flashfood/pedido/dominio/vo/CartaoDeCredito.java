package br.com.fastfood.flashfood.pedido.dominio.vo;

public class CartaoDeCredito {

    private String nome;

    private String numero;

    private int mesExpiracao;

    private int anoExpiracao;

    public CartaoDeCredito(String nome, String numero, int mesExpiracao, int anoExpiracao) {
        this.nome = nome;
        this.numero = numero;
        this.mesExpiracao = mesExpiracao;
        this.anoExpiracao = anoExpiracao;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }

    public int getMesExpiracao() {
        return mesExpiracao;
    }

    public int getAnoExpiracao() {
        return anoExpiracao;
    }
}
