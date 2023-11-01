package br.com.fastfood.flashfood.pedido.dominio.modelos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Recibo {

    private BigDecimal valor;
    LocalDate pago;

    public Recibo(BigDecimal valor, LocalDate pago) {
        this.valor = valor;
        this.pago = pago;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDate getPago() {
        return pago;
    }
}
