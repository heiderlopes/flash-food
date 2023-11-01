package br.com.fastfood.flashfood;

//@SpringBootApplication
//@PropertySource(value = {"classpath:application.properties"})
////@OpenAPIDefinition
//public class FlashfoodApplication implements CommandLineRunner {
//
//    public static void main(final String[] args) {
//        SpringApplication application = new SpringApplication(FlashfoodApplication.class);
//        // uncomment to run just the console application
//        // application.setWebApplicationType(WebApplicationType.NONE);
//        //application.run(args);
//    }
//
//    @Autowired
//    public CliOrderController orderController;
//
//    @Autowired
//    public ConfigurableApplicationContext context;
//
//    @Override
//    public void run(String... args) throws Exception {
//        orderController.createCompleteOrder();
//        orderController.createIncompleteOrder();
//        // uncomment to stop the context when execution is done
//        context.close();
//    }
//}

import br.com.fastfood.flashfood.cliente.infraestrutura.adaptadores.saida.repositories.persistencia.RepositorioClienteSpring;
import br.com.fastfood.flashfood.pedido.infraestrutura.adaptadores.saida.repositorios.RepositorioPagamentoSpring;
import br.com.fastfood.flashfood.pedido.infraestrutura.adaptadores.saida.repositorios.RepositorioPedidoSpring;
import br.com.fastfood.flashfood.produto.infraestrutura.adaptadores.saida.repositorios.RepositorioProdutoSpring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {RepositorioProdutoSpring.class, RepositorioClienteSpring.class, RepositorioPedidoSpring.class, RepositorioPagamentoSpring.class})
public class FlashfoodApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlashfoodApplication.class, args);
    }

}
