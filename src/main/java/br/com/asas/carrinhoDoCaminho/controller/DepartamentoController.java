package br.com.asas.carrinhoDoCaminho.controller;

import br.com.asas.carrinhoDoCaminho.VO.DepartamentoLIstVO;
import br.com.asas.carrinhoDoCaminho.VO.DepartamentoVO;
import br.com.asas.carrinhoDoCaminho.model.Departamento;
import br.com.asas.carrinhoDoCaminho.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("departamento")
public class DepartamentoController {

    private static final Logger log = Logger.getLogger(DepartamentoController.class.getName());

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping(value = "listar")
    public ResponseEntity<?> Listaepartamentos() {
        List<Departamento> departamentos = departamentoService.listaDepartamentos();
        log.info("Acessou  listar departamentos");
        if(departamentos == null || departamentos.isEmpty()) {
            return ResponseEntity.ok(new DepartamentoVO(400, "Não há departamentos há departamentos cadastrados."));
        }
        return ResponseEntity.ok(new DepartamentoLIstVO(600, "Departamentos encontrados com sucesso.", departamentos));
    }

    @GetMapping(value = "buscar/{id}")
    public Departamento buscaDepartamento(@PathVariable("id") Integer id) {
        log.info("Busca departamento por Id - Id: " +id);
        return departamentoService.buscaDepartamento(id);
    }

    @PostMapping(value = "salvar")
    public ResponseEntity<?> salvaDepartamento(@Valid @RequestBody Departamento departamento, Errors errors) {
        log.info("Acessando salvar departamento - Departamento: " +departamento.toString());
        if(errors.hasErrors()) {
            return ResponseEntity.ok(new DepartamentoVO(400, errors.getFieldError().getDefaultMessage()));
        }
        Departamento departamentoSalvo = departamentoService.salvar(departamento);
        return ResponseEntity.ok(new DepartamentoVO(600, "Deparmtamento salvo com sucesso.", departamento));
    }

    @PutMapping(value = "atualizar")
    public ResponseEntity<?> atualizaDepartamento(@Valid @RequestBody Departamento departamento, Errors errors) {
        log.info("Acessou atualizar departamento - departamento: " +departamento.toString());
        if(errors.hasErrors()) {
            return ResponseEntity.ok(new DepartamentoVO(400, errors.getFieldError().getDefaultMessage()));
        }
        Departamento departamentoAtualizado = departamentoService.atualiza(departamento);
        return ResponseEntity.ok(new DepartamentoVO(600, "Departamento atualizado com sucesso.", departamento));
    }

    @DeleteMapping(value = "excluir/{id}")
    public ResponseEntity<?> excluirDepartamento(@PathVariable("id") Integer codigoDepartamento) {
        log.info("Excluir departamento - código departamento: " + codigoDepartamento);
        Departamento departamento = departamentoService.buscaDepartamento(codigoDepartamento);
        if(departamento != null) {
            departamentoService.excluir(codigoDepartamento);
            return ResponseEntity.ok(new DepartamentoVO(600, "Departamento excluido com sucesso."));
        } else {
            return ResponseEntity.ok(new DepartamentoVO(400, "O departamento a ser excluido não foi encontrado."));
        }
    }
}
