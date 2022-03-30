package br.com.estoque.controllers;

import br.com.estoque.model.Estoque;
import br.com.estoque.services.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/estoques")
public class EstoqueController implements Serializable {

    @Autowired
    private EstoqueService estoqueService;

    @RequestMapping(value = "/{sku}", method= RequestMethod.GET)
    public ResponseEntity<Estoque> buscarPorSku(@PathVariable String sku) {
        Estoque estoqueSku = this.estoqueService.buscarPorSku(sku);
        return ResponseEntity.ok().body(estoqueSku);
    }

    @GetMapping
    public ResponseEntity<List<Estoque>> buscarTodos() {
        return ResponseEntity.ok(this.estoqueService.buscarTodos());
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Estoque> inserir(@RequestBody Estoque obj) {
            this.estoqueService.inserir(obj);
            URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{sku}")
                    .buildAndExpand(obj.getSku())
                    .toUri();
            return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{sku}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable String sku) {
            this.estoqueService.deletar(sku);
            return ResponseEntity.noContent().build();
    }
}
