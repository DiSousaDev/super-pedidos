package br.dev.diego.superpedidos.controllers;

import br.dev.diego.superpedidos.entities.dto.PedidoCreatedResponseDto;
import br.dev.diego.superpedidos.entities.dto.PedidoInsertDto;
import br.dev.diego.superpedidos.entities.dto.PedidoResponseDto;
import br.dev.diego.superpedidos.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PedidoResponseDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<PedidoCreatedResponseDto> insert(@Valid @RequestBody PedidoInsertDto pedidoInsertDto) {
        PedidoCreatedResponseDto pedido = service.save(pedidoInsertDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(uri).body(pedido);
    }

}
