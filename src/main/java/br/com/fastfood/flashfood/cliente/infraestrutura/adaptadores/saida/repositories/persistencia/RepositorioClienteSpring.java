package br.com.fastfood.flashfood.cliente.infraestrutura.adaptadores.saida.repositories.persistencia;

import br.com.fastfood.flashfood.cliente.infraestrutura.adaptadores.saida.repositories.persistencia.entidades.EntidadeCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RepositorioClienteSpring extends JpaRepository<EntidadeCliente, UUID> {
    Optional<EntidadeCliente> findByCpf(String cpf);
}
