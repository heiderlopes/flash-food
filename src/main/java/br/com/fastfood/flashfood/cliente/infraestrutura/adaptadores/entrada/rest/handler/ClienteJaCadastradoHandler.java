package br.com.fastfood.flashfood.cliente.infraestrutura.adaptadores.entrada.rest.handler;

import br.com.fastfood.flashfood.cliente.dominio.excecoes.ClienteJaCadastradoExcecao;
import br.com.fastfood.flashfood.compartilhado.dominio.vo.RespostaDeErro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


@ControllerAdvice
@RestController
public class ClienteJaCadastradoHandler {

    @ExceptionHandler(ClienteJaCadastradoExcecao.class)
    public ResponseEntity<RespostaDeErro> handleCustomerNotFoundException(ClienteJaCadastradoExcecao ex) {
        RespostaDeErro respostaDeErro = new RespostaDeErro(ex.getMessage());
        return new ResponseEntity<>(respostaDeErro, HttpStatus.PRECONDITION_FAILED);
    }
}