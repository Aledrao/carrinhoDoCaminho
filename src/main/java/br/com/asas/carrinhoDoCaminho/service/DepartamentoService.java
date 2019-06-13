package br.com.asas.carrinhoDoCaminho.service;

import br.com.asas.carrinhoDoCaminho.model.Departamento;
import br.com.asas.carrinhoDoCaminho.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public Departamento buscaDepartamento(Integer codigoDepartamento) {
        return departamentoRepository.getOne(codigoDepartamento);
    }

    public List<Departamento> listaDepartamentos() {
        return departamentoRepository.findAll();
    }

    public Departamento salvar(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public Departamento atualiza(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public void excluir(Integer codigoDepartamento) {
        departamentoRepository.deleteById(codigoDepartamento);
    }
}
