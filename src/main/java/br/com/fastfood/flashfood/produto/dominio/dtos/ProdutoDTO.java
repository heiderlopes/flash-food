package br.com.fastfood.flashfood.produto.dominio.dtos;

import br.com.fastfood.flashfood.produto.dominio.modelos.CategoriaDoProduto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class ProdutoDTO {
    private UUID id;
    private String nome;
    private CategoriaDoProduto categoria;
    private BigDecimal preco;

    private String descricao;
    private List<String> imagens;

    public ProdutoDTO(UUID id, String nome, CategoriaDoProduto categoria, BigDecimal preco, String descricao, List<String> imagens) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.descricao = descricao;
        this.imagens = imagens;
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
}
