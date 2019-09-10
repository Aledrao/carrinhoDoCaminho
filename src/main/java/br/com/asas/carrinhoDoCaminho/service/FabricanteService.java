package br.com.asas.carrinhoDoCaminho.service;

import br.com.asas.carrinhoDoCaminho.model.Fabricante;
import br.com.asas.carrinhoDoCaminho.repository.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FabricanteService {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    public Fabricante buscaFabricante(Integer codigo) {
        return fabricanteRepository.findByCodigo(codigo);
    }

    public List<Fabricante> listaFabricantes() {
        return fabricanteRepository.findAll();
    }

    public Fabricante salvar(Fabricante fabricante) {
        return fabricanteRepository.save(fabricante);
    }

    public Fabricante atualizar(Fabricante fabricante) {
        return fabricanteRepository.saveAndFlush(fabricante);
    }

    public void deletar(Integer codigo) {
        fabricanteRepository.deleteById(codigo);
    }
}
