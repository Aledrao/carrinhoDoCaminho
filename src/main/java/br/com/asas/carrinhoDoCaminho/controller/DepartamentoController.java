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
    public List<Departamento> departamentos() {
        return departamentoService.listaDepartamentos();
    }

    @PostMapping(value = "salvar")
    public Departamento salvaDepartamento(@RequestBody Departamento departamento) {
        return departamentoService.salvar(departamento);
    }
}
