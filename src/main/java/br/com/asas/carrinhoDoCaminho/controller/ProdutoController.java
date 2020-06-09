package br.com.asas.carrinhoDoCaminho.controller;

import br.com.asas.carrinhoDoCaminho.model.Produto;
import br.com.asas.carrinhoDoCaminho.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    private static final Logger LOG = Logger.getLogger(ProdutoController.class.getName());

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("listar-todos")
    public ResponseEntity<?> listarTodos() {
        LOG.info("Listar todos os produtos");
        List<Produto> produtos = produtoService.listaProdutos();
        if(produtos == null || produtos.isEmpty()) {
            return ResponseEntity.ok("Não há produtos cadastrados");
        } else {
            return ResponseEntity.ok(produtos);
        }
    }

    @GetMapping("listar-todos")
    public ResponseEntity<?> buscaPorCodigo(Long codigo) {
        LOG.info("Buscar produtos por código.");
        Produto produto = produtoService.buscarProdutoPorCodigo(codigo);
        if(produto == null) {
            return ResponseEntity.ok("Não foi possível localizar produto pelo código informado.");
        } else {
            return ResponseEntity.ok(produto);
        }
    }

    @GetMapping("lista-por-nome")
    public ResponseEntity<?> buscaPorNome(String nome) {
        LOG.info("Busca produto por nome.");
        List<Produto> produtos = produtoService.listaProdutoPorNome(nome);
        if(produtos.isEmpty()) {
            return ResponseEntity.ok(produtos);
        } else {
            return ResponseEntity.ok("Não foi possível localizar produtos pelo nome informado.");
        }
    }

    @GetMapping("busca-por-codigo-barras")
    public ResponseEntity<?> buscaPorCodigoBarras(Long codigoDeBarras) {
        LOG.info("Busca produto por código de barras");
        Produto produto = produtoService.buscarProdutoPorCodigoBarras(codigoDeBarras);
        if(produto == null) {
            return ResponseEntity.ok("Não foi possível localizar o produto pelo código de barras");
        } else {
            return ResponseEntity.ok(produto);
        }
    }

    @GetMapping("lista-por-valor")
    public ResponseEntity<?> listaPorValor(BigDecimal valor) {
        LOG.info("Busca produto pelo valor");
        List<Produto> produtos = produtoService.listaProdutoPorValor(valor);
        if(produtos.isEmpty()) {
            return ResponseEntity.ok("Não foi possível encontrar o produto pelo valor.");
        } else {
            return ResponseEntity.ok(produtos);
        }
    }
}
