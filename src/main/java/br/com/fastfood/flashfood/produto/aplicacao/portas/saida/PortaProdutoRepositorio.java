package br.com.fastfood.flashfood.produto.aplicacao.portas.saida;

import br.com.fastfood.flashfood.produto.dominio.modelos.CategoriaDoProduto;
import br.com.fastfood.flashfood.produto.dominio.modelos.Produto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PortaProdutoRepositorio {

    void salvar(Produto produto);

    List<Produto> buscaTodosOsProdutos();

    List<Produto> buscarProdutoPorCategoria(CategoriaDoProduto categoriaDoProduto);

    Optional<Produto> pesquisarPorId(UUID id);

    Produto atualizar(Produto produto);

    void apagar(UUID id);
}

