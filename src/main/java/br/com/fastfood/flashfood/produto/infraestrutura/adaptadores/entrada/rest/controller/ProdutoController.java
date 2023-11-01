package br.com.fastfood.flashfood.produto.infraestrutura.adaptadores.entrada.rest.controller;

import br.com.fastfood.flashfood.produto.dominio.dtos.CategoriaDoProdutoDTO;
import br.com.fastfood.flashfood.produto.dominio.dtos.ProdutoDTO;
import br.com.fastfood.flashfood.produto.aplicacao.portas.entrada.PortaProdutoServico;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Produtos")
@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private final PortaProdutoServico portaProdutoServico;

    public ProdutoController(PortaProdutoServico portaProdutoServico) {
        this.portaProdutoServico = portaProdutoServico;
    }

    @PostMapping
    void criarProduto(@RequestBody ProdutoDTO produtoDTO) {
        portaProdutoServico.criarProduto(produtoDTO);
    }

    @PutMapping
    void atualizarProduto(@RequestBody ProdutoDTO produtoDTO) {
        portaProdutoServico.atualizarProduto(produtoDTO);
    }

    @DeleteMapping("/{id}")
    void excluirProduto(@PathVariable("id") UUID id) {
        portaProdutoServico.excluirProduto(id);
    }

    @GetMapping
    List<ProdutoDTO> listarTodosProdutos() {
        return portaProdutoServico.listarTodosProdutos();
    }

    @GetMapping("/categoria/{id}")
    List<ProdutoDTO> listarProdutoPorCategoria(@PathVariable("id") CategoriaDoProdutoDTO categoriaDoProduto) {
        return portaProdutoServico.buscarProdutoPorCategoria(categoriaDoProduto);
    }
}
