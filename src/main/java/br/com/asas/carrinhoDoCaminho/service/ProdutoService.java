package br.com.asas.carrinhoDoCaminho.service;

import br.com.asas.carrinhoDoCaminho.model.Produto;
import br.com.asas.carrinhoDoCaminho.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listaProdutos() {
        return produtoRepository.findAll();
    }

    public Produto buscarProdutoPorCodigo(Long codigo) {
        return produtoRepository.findByCodigo(codigo);
    }

    public List<Produto> listaProdutoPorNome(String nome) {
        return produtoRepository.findByNome(nome);
    }

    public Produto buscarProdutoPorCodigoBarras(Long codigoBarras) {
        return produtoRepository.findByCodigoBarras(codigoBarras);
    }

    public List<Produto> listaProdutoPorValor(BigDecimal valor) {
        return produtoRepository.findByValor(valor);
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto atualizaProduto(Produto produto) {
        return produtoRepository.saveAndFlush(produto);
    }

    public void deletarProduto(Long codigo) {
        produtoRepository.deleteById(codigo);
    }
}
