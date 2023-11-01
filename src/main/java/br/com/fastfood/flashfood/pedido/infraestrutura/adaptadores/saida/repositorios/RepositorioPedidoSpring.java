package br.com.fastfood.flashfood.pedido.infraestrutura.adaptadores.saida.repositorios;

import br.com.fastfood.flashfood.pedido.dominio.modelos.PedidoStatus;
import br.com.fastfood.flashfood.pedido.infraestrutura.adaptadores.saida.repositorios.entidades.PedidoEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RepositorioPedidoSpring extends JpaRepository<PedidoEntidade, UUID> {
    List<PedidoEntidade> findByStatus(PedidoStatus status);
}
