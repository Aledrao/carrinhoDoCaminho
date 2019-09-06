package br.com.asas.carrinhoDoCaminho.repository;

import br.com.asas.carrinhoDoCaminho.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Item findByCodigo(Long codigo);

}
