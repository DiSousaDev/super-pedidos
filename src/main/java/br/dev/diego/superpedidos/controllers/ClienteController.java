package br.dev.diego.superpedidos.controllers;

import br.dev.diego.superpedidos.entities.dto.ClienteDtoWithTelefoneAndEndereco;
import br.dev.diego.superpedidos.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDtoWithTelefoneAndEndereco> find(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscar(id));
    }
}
