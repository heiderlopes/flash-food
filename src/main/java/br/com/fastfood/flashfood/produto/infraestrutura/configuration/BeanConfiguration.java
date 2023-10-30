package br.com.fastfood.flashfood.produto.infraestrutura.configuration;


import br.com.fastfood.flashfood.FlashfoodApplication;
import br.com.fastfood.flashfood.cliente.dominio.adaptadores.servicos.ClienteServicoImpl;
import br.com.fastfood.flashfood.cliente.dominio.portas.entrada.PortaClienteServico;
import br.com.fastfood.flashfood.cliente.dominio.portas.saida.PortaClienteRepositorio;
import br.com.fastfood.flashfood.produto.dominio.adaptadores.servicos.ProdutoServicoImpl;
import br.com.fastfood.flashfood.produto.dominio.portas.saida.PortaProdutoRepositorio;
import br.com.fastfood.flashfood.produto.dominio.portas.entrada.PortaProdutoServico;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackageClasses = FlashfoodApplication.class)
public class BeanConfiguration {

    @Bean
    PortaProdutoServico produtoService(PortaProdutoRepositorio portaProdutoRepositorio) {
        return new ProdutoServicoImpl(portaProdutoRepositorio);
    }

    @Bean
    PortaClienteServico customerService(PortaClienteRepositorio portaClienteRepositorio) {
        return new ClienteServicoImpl(portaClienteRepositorio);
    }

}

//@Configuration
//@ComponentScan(basePackageClasses = FlashfoodApplication.class)
//public class BeanConfiguration {
//
//    @Bean
//    OrderService orderService(final OrderRepository orderRepository) {
//        return new DomainOrderService(orderRepository);
//    }
//}