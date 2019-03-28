package br.com.asas.carrinhoDoCaminho.repository;

import br.com.asas.carrinhoDoCaminho.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
}
