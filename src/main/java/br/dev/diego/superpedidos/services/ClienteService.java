package br.dev.diego.superpedidos.services;

import br.dev.diego.superpedidos.entities.dto.ClienteDtoWithTelefoneAndEndereco;
import br.dev.diego.superpedidos.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Transactional(readOnly = true)
    public ClienteDtoWithTelefoneAndEndereco buscar(Integer id) {
        return new ClienteDtoWithTelefoneAndEndereco(repository.buscarClienteComTelefoneEEndereco(id)
                .orElseThrow(() -> new EntityNotFoundException("Nenhum Cliente não encontrado id: " + id)));
    }
}
