package br.com.fastfood.flashfood.pedido.infraestrutura.configuracao;

import br.com.fastfood.flashfood.FlashfoodApplication;
import br.com.fastfood.flashfood.pedido.aplicacao.portas.entrada.PortaGerenciarPedidoServico;
import br.com.fastfood.flashfood.pedido.aplicacao.portas.saida.PortaPagamentoRepositorio;
import br.com.fastfood.flashfood.pedido.aplicacao.portas.saida.PortaPedidoRepositorio;
import br.com.fastfood.flashfood.pedido.dominio.adaptadores.servicos.ServicoGerenciarPedido;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackageClasses = FlashfoodApplication.class)
public class PedidoBeanConfiguracao {
    @Bean
    PortaGerenciarPedidoServico gerenciarPedidoServico(PortaPedidoRepositorio portaPedidoRepositorio, PortaPagamentoRepositorio portaPagamentoRepositorio) {
        return new ServicoGerenciarPedido(portaPedidoRepositorio, portaPagamentoRepositorio);
    }

}
