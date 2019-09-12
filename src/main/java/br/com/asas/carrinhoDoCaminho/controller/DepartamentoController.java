package br.com.asas.carrinhoDoCaminho.controller;

import br.com.asas.carrinhoDoCaminho.VO.DepartamentoLIstVO;
import br.com.asas.carrinhoDoCaminho.VO.DepartamentoVO;
import br.com.asas.carrinhoDoCaminho.model.Departamento;
import br.com.asas.carrinhoDoCaminho.service.DepartamentoService;
import br.com.asas.carrinhoDoCaminho.utils.Constantes;
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

    @GetMapping(value = "listar-todos")
    public ResponseEntity<?> listarTodos() {
        List<Departamento> departamentos = departamentoService.listaDepartamentos();
        log.info("Acessou  listar departamentos");
        if(departamentos == null || departamentos.isEmpty()) {
            return ResponseEntity.ok(new DepartamentoVO(Constantes.RESPOSTA_ERRO, Constantes.NAO_FORAM_ENCONTRADOS + Constantes.DEPARTAMENTO));
        }
        return ResponseEntity.ok(new DepartamentoLIstVO(Constantes.RESPOSTA_ACERTO, Constantes.DEPARTAMENTO + Constantes.ENCONTRADOS_COM_SUCESSO, departamentos));
    }

    @GetMapping(value = "buscar/{codigo}")
    public Departamento buscaDepartamento(@PathVariable("odigo") Integer id) {
        log.info("Busca departamento por Id - Id: " +id);
        return departamentoService.buscaDepartamento(id);
    }

    @PostMapping(value = "salvar")
    public ResponseEntity<?> salvaDepartamento(@Valid @RequestBody Departamento departamento, Errors errors) {
        log.info("Acessando salvar departamento - Departamento: " +departamento.toString());
        if(errors.hasErrors()) {
            return ResponseEntity.ok(new DepartamentoVO(Constantes.RESPOSTA_ERRO, errors.getFieldError().getDefaultMessage()));
        }
        Departamento departamentoSalvo = departamentoService.salvar(departamento);
        return ResponseEntity.ok(new DepartamentoVO(Constantes.RESPOSTA_ACERTO, Constantes.DEPARTAMENTO + Constantes.SALVOS_COM_SUCESSO, departamento));
    }

    @PutMapping(value = "atualizar")
    public ResponseEntity<?> atualizaDepartamento(@Valid @RequestBody Departamento departamento, Errors errors) {
        log.info("Acessou atualizar departamento - departamento: " +departamento.toString());
        if(errors.hasErrors()) {
            return ResponseEntity.ok(new DepartamentoVO(Constantes.RESPOSTA_ERRO, errors.getFieldError().getDefaultMessage()));
        }
        Departamento departamentoAtualizado = departamentoService.atualiza(departamento);
        return ResponseEntity.ok(new DepartamentoVO(Constantes.RESPOSTA_ACERTO, Constantes.DEPARTAMENTO + Constantes.ATUALIZADOS_COM_SUCESSO, departamento));
    }

    @DeleteMapping(value = "excluir/{id}")
    public ResponseEntity<?> excluirDepartamento(@PathVariable("id") Integer codigoDepartamento) {
        log.info("Excluir departamento - código departamento: " + codigoDepartamento);
        Departamento departamento = departamentoService.buscaDepartamento(codigoDepartamento);
        if(departamento != null) {
            departamentoService.excluir(codigoDepartamento);
            return ResponseEntity.ok(new DepartamentoVO(Constantes.RESPOSTA_ACERTO, Constantes.DEPARTAMENTO + Constantes.EXCLUIDO_COM_SUCESSO));
        } else {
            return ResponseEntity.ok(new DepartamentoVO(Constantes.RESPOSTA_ERRO, Constantes.DEPARTAMENTO + Constantes.EXCLUIDO_NAO_ENCONTRADO));
        }
    }
}
