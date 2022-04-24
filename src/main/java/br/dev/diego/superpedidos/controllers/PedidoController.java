package br.dev.diego.superpedidos.controllers;

import br.dev.diego.superpedidos.entities.dto.PedidoDto;
import br.dev.diego.superpedidos.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PedidoDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }
}
