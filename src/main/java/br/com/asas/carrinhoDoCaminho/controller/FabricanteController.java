package br.com.asas.carrinhoDoCaminho.controller;

import br.com.asas.carrinhoDoCaminho.VO.FabricanteListVO;
import br.com.asas.carrinhoDoCaminho.VO.FabricanteVO;
import br.com.asas.carrinhoDoCaminho.model.Fabricante;
import br.com.asas.carrinhoDoCaminho.service.FabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("fabricante")
public class FabricanteController {

    private final static Logger log = Logger.getLogger(FabricanteController.class.getName());

    @Autowired
    private FabricanteService fabricanteService;

    @GetMapping("listar-todos")
    private ResponseEntity<?> listarTodos() {
        log.info("Acessou listar todos os fabricantes.");
        List<Fabricante> fabricantes = fabricanteService.listaFabricantes();
        if(fabricantes.isEmpty() || fabricantes == null) {
            return ResponseEntity.ok(new FabricanteVO(400, "Não há fabricantes cadastrados."));
        }
        return ResponseEntity.ok(new FabricanteListVO(600, "fabricantes encontrados com sucesso", fabricantes));
    }

    @GetMapping("buscar/{codigo}")
    private ResponseEntity<?> fabricantePorCodigo(@PathVariable("codigo") Integer codigo) {
        log.info("Buscando fabricante por código: " +codigo);
        Fabricante fabricante = fabricanteService.buscaFabricantePorCodigo(codigo);
        if(fabricante == null) {
            return ResponseEntity.ok(new FabricanteVO(400, "Não foi possível encontrar o " +
                    "fabricante por código."));
        }
        return ResponseEntity.ok(new FabricanteVO(600, "Fabricante encontrado com sucesso.", fabricante));
    }

    @GetMapping("buscar/{nome}")
    private ResponseEntity<?> fabricantePorNome(@PathVariable("nome") String nome) {
        log.info("Buscando fabricante por nome: " +nome);
        Fabricante fabricante = fabricanteService.buscaFabricantePorNome(nome);
        if(fabricante == null) {
            return ResponseEntity.ok(new FabricanteVO(400, "Não foi possível encontrar o " +
                    "fabricante por nome."));
        }
        return ResponseEntity.ok(new FabricanteVO(600, "Fabricante encontrado com sucesso.", fabricante));
    }

    @GetMapping("salvar")
    private ResponseEntity<?> salvarFabricante(@Valid @RequestBody Fabricante fabricante, Errors errors) {
        log.info("Salvando Fabricante: " +fabricante.toString());
        if(errors.hasErrors()) {
            return ResponseEntity.ok(new FabricanteVO(400, errors.getFieldError().getDefaultMessage()));
        }
        Fabricante fabricanteSalvo = fabricanteService.salvar(fabricante);
        return ResponseEntity.ok(new FabricanteVO(600, "Fabricante salvo com sucesso.", fabricante));
    }

    @GetMapping("atualizar")
    private ResponseEntity<?> atualizarFabricante(@Valid @RequestBody Fabricante fabricante, Errors errors) {
        log.info("Atualizando fabricante: " +fabricante.toString());
        if (errors.hasErrors()) {
            return ResponseEntity.ok(new FabricanteVO(400, errors.getFieldError().getDefaultMessage()));
        }
        Fabricante fabricanteAtualizado = fabricanteService.atualizar(fabricante);
        return ResponseEntity.ok(new FabricanteVO(600, "Fabricante atualizado com sucesso.", fabricante));
    }

    @GetMapping("excluir")
    private ResponseEntity<?> excluirFabricante(@PathVariable("codigo") Integer codigo) {
        log.info("Excluindo fabricante por código: " + codigo);
        Fabricante fabricante = fabricanteService.buscaFabricantePorCodigo(codigo);
        if(fabricante != null) {
            fabricanteService.deletar(codigo);
            return ResponseEntity.ok(new FabricanteVO(600, "Fabricante excluido com sucesso.", fabricante));
        }
        return ResponseEntity.ok(new FabricanteVO(400, "Não foi possível encontrar o fabricante a ser excuido"));
    }
}