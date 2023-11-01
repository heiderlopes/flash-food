package br.com.fastfood.flashfood.produto.infraestrutura.adaptadores.saida.repositorios;

import br.com.fastfood.flashfood.produto.dominio.modelos.CategoriaDoProduto;
import br.com.fastfood.flashfood.produto.dominio.modelos.Produto;
import br.com.fastfood.flashfood.produto.aplicacao.portas.saida.PortaProdutoRepositorio;
import br.com.fastfood.flashfood.produto.infraestrutura.adaptadores.saida.repositorios.persistencia.entidades.ProdutoEntidade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Component
public class RepositorioProduto implements PortaProdutoRepositorio {

    private final RepositorioProdutoSpring repositorioProdutoSpring;

    public RepositorioProduto(
            RepositorioProdutoSpring repositorioProdutoSpring) {
        this.repositorioProdutoSpring = repositorioProdutoSpring;
    }

    @Override
    public List<Produto> buscaTodosOsProdutos() {
        List<ProdutoEntidade> produtoEntities = this.repositorioProdutoSpring.findAll();
        return produtoEntities.stream().map(ProdutoEntidade::toProduct).collect(toList());
    }

    @Override
    public List<Produto> buscarProdutoPorCategoria(CategoriaDoProduto categoriaDoProduto) {
        List<ProdutoEntidade> produtoEntities = this.repositorioProdutoSpring.findByCategoria(categoriaDoProduto.name());
        return produtoEntities.stream().map(ProdutoEntidade::toProduct).collect(toList());
    }

    @Override
    public Optional<Produto> pesquisarPorId(UUID id) {
        return repositorioProdutoSpring.findById(id).map(ProdutoEntidade::toProduct);
    }

    @Override
    public Produto atualizar(Produto produto) {
        ProdutoEntidade produtoEntidade;
        produtoEntidade = new ProdutoEntidade(produto);
        return this.repositorioProdutoSpring.save(produtoEntidade).toProduct();
    }

    @Override
    public void apagar(UUID id) {
        this.repositorioProdutoSpring.deleteById(id);
    }

    @Override
    public void salvar(Produto produto) {
        ProdutoEntidade produtoEntidade;
        produtoEntidade = new ProdutoEntidade(produto);
        this.repositorioProdutoSpring.save(produtoEntidade);
    }
}
