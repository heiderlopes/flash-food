package br.com.fastfood.flashfood.produto.infraestrutura.adaptadores.saida.repositorios.persistencia.entidades;

import br.com.fastfood.flashfood.compartilhado.dominio.vo.CodigoDeIdentificacaoDoProduto;
import br.com.fastfood.flashfood.produto.dominio.modelos.CategoriaDoProduto;
import br.com.fastfood.flashfood.produto.dominio.modelos.Produto;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "produtos")
public class ProdutoEntidade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private String categoria;
    private String descricao;
    private BigDecimal preco;

    @ElementCollection
    @CollectionTable(name = "produtos_imagens")
    private List<String> imagens = new ArrayList<>();

    public ProdutoEntidade() {
    }

    public ProdutoEntidade(Produto produto) {
        this.id = produto.getId().getId();
        this.nome = produto.getNome();
        this.categoria = produto.getCategoria().toString();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.imagens = produto.getImagens();
    }

    public Produto toProduct() {
        return new Produto(
                new CodigoDeIdentificacaoDoProduto(this.id),
                this.nome,
                CategoriaDoProduto.valueOf(this.categoria),
                this.preco,
                this.descricao,
                this.imagens
        );
    }
}