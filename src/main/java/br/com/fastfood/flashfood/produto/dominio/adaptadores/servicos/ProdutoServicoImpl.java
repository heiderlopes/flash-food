package br.com.fastfood.flashfood.produto.dominio.adaptadores.servicos;

import br.com.fastfood.flashfood.produto.dominio.dtos.CategoriaDoProdutoDTO;
import br.com.fastfood.flashfood.produto.dominio.dtos.ProdutoDTO;
import br.com.fastfood.flashfood.produto.dominio.modelos.CategoriaDoProduto;
import br.com.fastfood.flashfood.produto.dominio.modelos.Produto;
import br.com.fastfood.flashfood.produto.aplicacao.portas.entrada.PortaProdutoServico;
import br.com.fastfood.flashfood.produto.aplicacao.portas.saida.PortaProdutoRepositorio;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ProdutoServicoImpl implements PortaProdutoServico {

    private final PortaProdutoRepositorio produtoRepository;

    public ProdutoServicoImpl(PortaProdutoRepositorio produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public void criarProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto(produtoDTO);
        this.produtoRepository.salvar(produto);
    }

    @Override
    public void atualizarProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto(produtoDTO);
        this.produtoRepository.atualizar(produto);
    }

    @Override
    public void excluirProduto(UUID id) {
        this.produtoRepository.apagar(id);
    }

    @Override
    public List<ProdutoDTO> buscarProdutoPorCategoria(CategoriaDoProdutoDTO categoriaDoProdutoDTO) {
        CategoriaDoProduto categoriaDoProduto = CategoriaDoProduto.valueOf(categoriaDoProdutoDTO.name());
        List<Produto> produtos = this.produtoRepository.buscarProdutoPorCategoria(categoriaDoProduto);
        return produtos.stream().map(Produto::toProductDTO).collect(Collectors.toList());
    }

    @Override
    public List<ProdutoDTO> listarTodosProdutos() {
        List<Produto> produtos = this.produtoRepository.buscaTodosOsProdutos();
        return produtos.stream().map(Produto::toProductDTO).collect(Collectors.toList());
    }
}
