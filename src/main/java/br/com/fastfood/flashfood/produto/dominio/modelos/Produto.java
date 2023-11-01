package br.com.fastfood.flashfood.produto.dominio.modelos;

import br.com.fastfood.flashfood.compartilhado.dominio.vo.CodigoDeIdentificacaoDoProduto;
import br.com.fastfood.flashfood.produto.dominio.dtos.ProdutoDTO;

import java.math.BigDecimal;
import java.util.List;

public class Produto {
    private final CodigoDeIdentificacaoDoProduto id;
    private String nome;
    private CategoriaDoProduto categoria;
    private BigDecimal preco;

    private String descricao;

    private List<String> imagens;

    public Produto(CodigoDeIdentificacaoDoProduto id, String nome, CategoriaDoProduto categoria, BigDecimal preco, String descricao, List<String> imagens) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.descricao = descricao;
        this.imagens = imagens;
    }

    public Produto(ProdutoDTO produtoDTO) {
        this.id =  new CodigoDeIdentificacaoDoProduto(produtoDTO.getId());
        this.nome = produtoDTO.getNome();
        this.categoria = produtoDTO.getCategoria();
        this.preco = produtoDTO.getPreco();
        this.descricao = produtoDTO.getDescricao();
        this.imagens = produtoDTO.getImagens();
    }


    public CodigoDeIdentificacaoDoProduto getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public CategoriaDoProduto getCategoria() {
        return categoria;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<String> getImagens() {
        return imagens;
    }

    public ProdutoDTO toProductDTO() {
        return new ProdutoDTO(this.getId().getId(), this.getNome(), this.getCategoria(), this.getPreco(), this.getDescricao(), this.getImagens());
    }
}