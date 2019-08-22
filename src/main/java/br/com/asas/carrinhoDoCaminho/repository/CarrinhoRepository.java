package br.com.asas.carrinhoDoCaminho.repository;

import br.com.asas.carrinhoDoCaminho.model.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
}
