package br.com.fastfood.flashfood.produto.dominio.modelos;

import br.com.fastfood.flashfood.produto.dominio.dtos.ProdutoDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
public class Produto {
    private final UUID id;
    private String nome;
    private CategoriaDoProduto categoria;
    private BigDecimal preco;

    private String descricao;

    private List<String> imagens;

    public Produto(UUID id, String nome, CategoriaDoProduto categoria, BigDecimal preco, String descricao, List<String> imagens) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.descricao = descricao;
        this.imagens = imagens;
    }

    public Produto(ProdutoDTO produtoDTO) {
        this.id = produtoDTO.getId();
        this.nome = produtoDTO.getNome();
        this.categoria = produtoDTO.getCategoria();
        this.preco = produtoDTO.getPreco();
        this.descricao = produtoDTO.getDescricao();
        this.imagens = produtoDTO.getImagens();
    }


    public UUID getId() {
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
        return new ProdutoDTO(this.getId(), this.getNome(), this.getCategoria(), this.getPreco(), this.getDescricao(), this.getImagens());
    }
}