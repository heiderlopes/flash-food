package br.com.fastfood.flashfood.produto.infraestrutura.adaptadores.repositorios;

import br.com.fastfood.flashfood.produto.infraestrutura.adaptadores.entidades.ProdutoEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RepositorioProdutoSpring extends JpaRepository<ProdutoEntidade, UUID> {
    List<ProdutoEntidade> findByCategoria(String CategoriaDoProduto);
}
