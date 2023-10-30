package br.com.fastfood.flashfood.produto.dominio.portas.entrada;

import br.com.fastfood.flashfood.produto.dominio.dtos.CategoriaDoProdutoDTO;
import br.com.fastfood.flashfood.produto.dominio.dtos.ProdutoDTO;

import java.util.List;
import java.util.UUID;

public interface PortaProdutoServico {

    void criarProduto(ProdutoDTO produtoDTO);

    void atualizarProduto(ProdutoDTO produtoDTO);

    void excluirProduto(UUID id);

    List<ProdutoDTO> buscarProdutoPorCategoria(CategoriaDoProdutoDTO categoriaDoProdutoDTO);
    List<ProdutoDTO> listarTodosProdutos();
}
