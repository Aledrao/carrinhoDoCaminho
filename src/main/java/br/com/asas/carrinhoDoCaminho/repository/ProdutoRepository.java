package br.com.asas.carrinhoDoCaminho.repository;

import br.com.asas.carrinhoDoCaminho.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Produto findByCodigo(Long codigo);
    Produto findByNome(String nome);
    Produto findByCodigoBarras(Long codigoBarras);
    List<Produto> findByValor(BigDecimal valor);
}
