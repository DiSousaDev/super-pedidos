package br.dev.diego.superpedidos.controllers;

import br.dev.diego.superpedidos.entities.dto.ProdutoDtoWithCategory;
import br.dev.diego.superpedidos.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<Page<ProdutoDtoWithCategory>> findAllPaged(Pageable pageable) {
        return ResponseEntity.ok(produtoService.findAllPaged(pageable));
    }
}
