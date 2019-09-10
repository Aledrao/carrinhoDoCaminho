package br.com.asas.carrinhoDoCaminho.controller;

import br.com.asas.carrinhoDoCaminho.VO.FabricanteListVO;
import br.com.asas.carrinhoDoCaminho.VO.FabricanteVO;
import br.com.asas.carrinhoDoCaminho.model.Fabricante;
import br.com.asas.carrinhoDoCaminho.service.FabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("fabricante")
public class FabricanteController {

    private final static Logger log = Logger.getLogger(FabricanteController.class.getName());

    @Autowired
    private FabricanteService fabricanteService;

    @GetMapping("")
    private ResponseEntity<?> listarTodos() {
        log.info("Acessou listar todos os fabricantes.");
        List<Fabricante> fabricantes = fabricanteService.listaFabricantes();
        if(fabricantes.isEmpty() || fabricantes == null) {
            return ResponseEntity.ok(new FabricanteVO(400, "Não há fabricantes cadastrados."));
        }
        return ResponseEntity.ok(new FabricanteListVO(600, "fabricantes encontrados com sucesso", fabricantes));
    }
}
