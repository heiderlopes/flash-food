package br.com.fastfood.flashfood.pedido.infraestrutura.adaptadores.saida.repositorios;

import br.com.fastfood.flashfood.pedido.infraestrutura.adaptadores.saida.repositorios.entidades.PagamentoEntidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositorioPagamentoSpring  extends JpaRepository<PagamentoEntidade, UUID> { }
