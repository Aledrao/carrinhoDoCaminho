package br.com.asas.carrinhoDoCaminho.repository;


import br.com.asas.carrinhoDoCaminho.model.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Integer> {

    Fabricante findByCodigo(Integer codigo);

    Fabricante findByNome(String nome);
}
