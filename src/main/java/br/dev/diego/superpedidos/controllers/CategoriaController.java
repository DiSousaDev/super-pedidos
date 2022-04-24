package br.dev.diego.superpedidos.controllers;

import br.dev.diego.superpedidos.entities.dto.CategoriaDto;
import br.dev.diego.superpedidos.entities.dto.CategoriaDtoWithProdutos;
import br.dev.diego.superpedidos.entities.dto.CategoriaInsertDto;
import br.dev.diego.superpedidos.entities.dto.CategoriaUpdateDto;
import br.dev.diego.superpedidos.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriaDtoWithProdutos> find(@PathVariable Integer id) {
        return ResponseEntity.ok(categoriaService.buscar(id));
    }

    @PostMapping
    public ResponseEntity<CategoriaDto> insert(@RequestBody CategoriaInsertDto categoriaInsertDto) {
        CategoriaDto categoria = categoriaService.save(categoriaInsertDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).body(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDto> update(@PathVariable Integer id, @RequestBody CategoriaUpdateDto categoriaUpdateDto) {
        CategoriaDto categoriaDto = categoriaService.update(id, categoriaUpdateDto);
        return ResponseEntity.ok().body(categoriaDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id){
        categoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
