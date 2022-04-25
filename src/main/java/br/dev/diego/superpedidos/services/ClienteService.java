package br.dev.diego.superpedidos.services;

import br.dev.diego.superpedidos.entities.Cliente;
import br.dev.diego.superpedidos.entities.dto.ClienteDto;
import br.dev.diego.superpedidos.entities.dto.ClienteDtoWithTelefoneAndEndereco;
import br.dev.diego.superpedidos.entities.dto.ClienteUpdateDto;
import br.dev.diego.superpedidos.repositories.ClienteRepository;
import br.dev.diego.superpedidos.services.exceptions.DataIntegrityException;
import br.dev.diego.superpedidos.services.exceptions.DatabaseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Transactional
    public ClienteDtoWithTelefoneAndEndereco update(Integer id, ClienteUpdateDto clienteUpdateDto) {
        Cliente cliente = findById(id);
        cliente.setNome(clienteUpdateDto.getNome());
        cliente.setEmail(clienteUpdateDto.getEmail());
        repository.save(cliente);
        return new ClienteDtoWithTelefoneAndEndereco(cliente);
    }

    public void deleteById(Integer id){
        try {
            Cliente cliente = findById(id);
            repository.delete(cliente);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Erro ao excluir id: " + id);
        }
    }

    @Transactional(readOnly = true)
    public Page<ClienteDto> findAllPaged(Pageable pageable) {
        return repository.findAll(pageable).map(ClienteDto::new);
    }

    private Cliente clienteDtoToCliente(ClienteDto clienteDto) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteDto.getId());
        cliente.setNome(clienteDto.getNome());
        cliente.setEmail(clienteDto.getEmail());
        return cliente;
    }

    private Cliente findById(Integer id){
        return repository.findById(id).orElseThrow(() -> new DatabaseNotFoundException("Cliente não encontrado id: " + id + " Objeto " + Cliente.class.getName()));
    }
}
