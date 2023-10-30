package br.com.fastfood.flashfood.compartilhado.dominio.vo;

public class RespostaDeErro {
    private String message;

    public RespostaDeErro(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}