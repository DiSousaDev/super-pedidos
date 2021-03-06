package br.dev.diego.superpedidos.controllers;

import br.dev.diego.superpedidos.entities.dto.ClienteDto;
import br.dev.diego.superpedidos.entities.dto.ClienteDtoWithTelefoneAndEndereco;
import br.dev.diego.superpedidos.entities.dto.ClienteInsertDto;
import br.dev.diego.superpedidos.entities.dto.ClienteUpdateDto;
import br.dev.diego.superpedidos.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDtoWithTelefoneAndEndereco> find(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscar(id));
    }

    @PostMapping
    public ResponseEntity<ClienteDto> insert(@Valid @RequestBody ClienteInsertDto clienteInsertDto) {
        ClienteDto cliente = service.save(clienteInsertDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDtoWithTelefoneAndEndereco> update(@PathVariable Integer id, @Valid @RequestBody ClienteUpdateDto clienteUpdateDto) {
        ClienteDtoWithTelefoneAndEndereco categoriaDto = service.update(id, clienteUpdateDto);
        return ResponseEntity.ok().body(categoriaDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public ResponseEntity<Page<ClienteDto>> findAllPaged(Pageable pageable) {
        return ResponseEntity.ok(service.findAllPaged(pageable));
    }
}
