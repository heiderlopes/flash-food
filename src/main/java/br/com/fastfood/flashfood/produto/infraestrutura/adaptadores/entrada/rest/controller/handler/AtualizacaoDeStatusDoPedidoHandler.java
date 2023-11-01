package br.com.fastfood.flashfood.produto.infraestrutura.adaptadores.entrada.rest.controller.handler;

import br.com.fastfood.flashfood.compartilhado.dominio.vo.RespostaDeErro;
import br.com.fastfood.flashfood.pedido.dominio.excecao.AtualizacaoDeStatusDoPedidoExcecao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class AtualizacaoDeStatusDoPedidoHandler {

    @ExceptionHandler(AtualizacaoDeStatusDoPedidoExcecao.class)
    public ResponseEntity<RespostaDeErro> handleCustomerNotFoundException(AtualizacaoDeStatusDoPedidoExcecao ex) {
        RespostaDeErro respostaDeErro = new RespostaDeErro(ex.getMessage());
        return new ResponseEntity<>(respostaDeErro, HttpStatus.PRECONDITION_FAILED);
    }
}