package br.dev.diego.superpedidos.controllers;

import br.dev.diego.superpedidos.entities.dto.EstadoDto;
import br.dev.diego.superpedidos.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public ResponseEntity<List<EstadoDto>> findAll() {
        return ResponseEntity.ok(estadoService.listar());
    }
}
