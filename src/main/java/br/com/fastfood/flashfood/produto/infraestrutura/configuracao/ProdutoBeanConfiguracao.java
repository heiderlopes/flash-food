package br.com.fastfood.flashfood.produto.infraestrutura.configuracao;


import br.com.fastfood.flashfood.FlashfoodApplication;
import br.com.fastfood.flashfood.produto.dominio.adaptadores.servicos.ProdutoServicoImpl;
import br.com.fastfood.flashfood.produto.aplicacao.portas.entrada.PortaProdutoServico;
import br.com.fastfood.flashfood.produto.aplicacao.portas.saida.PortaProdutoRepositorio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackageClasses = FlashfoodApplication.class)
public class ProdutoBeanConfiguracao {
    @Bean
    PortaProdutoServico produtoService(PortaProdutoRepositorio portaProdutoRepositorio) {
        return new ProdutoServicoImpl(portaProdutoRepositorio);
    }

}
