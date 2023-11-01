package br.com.fastfood.flashfood.produto.infraestrutura.adaptadores.saida.repositorios;

import br.com.fastfood.flashfood.produto.infraestrutura.adaptadores.saida.repositorios.persistencia.entidades.ProdutoEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RepositorioProdutoSpring extends JpaRepository<ProdutoEntidade, UUID> {
    List<ProdutoEntidade> findByCategoria(String CategoriaDoProduto);
}
