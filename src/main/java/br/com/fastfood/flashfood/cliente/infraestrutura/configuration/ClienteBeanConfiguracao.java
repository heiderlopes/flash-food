package br.com.fastfood.flashfood.cliente.infraestrutura.configuration;

import br.com.fastfood.flashfood.FlashfoodApplication;
import br.com.fastfood.flashfood.cliente.dominio.adaptadores.servicos.ClienteServicoImpl;
import br.com.fastfood.flashfood.cliente.aplicacao.portas.entrada.PortaClienteServico;
import br.com.fastfood.flashfood.cliente.aplicacao.portas.saida.PortaClienteRepositorio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = FlashfoodApplication.class)
public class ClienteBeanConfiguracao {

    @Bean
    PortaClienteServico clienteServico(PortaClienteRepositorio portaClienteRepositorio) {
        return new ClienteServicoImpl(portaClienteRepositorio);
    }

}