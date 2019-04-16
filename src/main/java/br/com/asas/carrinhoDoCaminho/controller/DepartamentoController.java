package br.com.asas.carrinhoDoCaminho.controller;

import br.com.asas.carrinhoDoCaminho.model.Departamento;
import br.com.asas.carrinhoDoCaminho.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping(value = "listar")
    public List<Departamento> Listaepartamentos() {
        return departamentoService.listaDepartamentos();
    }

    @GetMapping(value = "buscar/{id}")
    public Departamento buscaDepartamento(@PathVariable("id") Integer id) {
        return departamentoService.buscaDepartamento(id);
    }

    @PostMapping(value = "salvar")
    public Departamento salvaDepartamento(@RequestBody Departamento departamento) {
        return departamentoService.salvar(departamento);
    }

    @PutMapping(value = "atualizar")
    public Departamento atualizaDepartamento(@RequestBody Departamento departamento) {
        return departamentoService.atualiza(departamento);
    }

    @DeleteMapping(value = "excluir")
    public void excluirDepartamento(Integer codigoDepartamento) {
        departamentoService.excluir(codigoDepartamento);
    }
}
