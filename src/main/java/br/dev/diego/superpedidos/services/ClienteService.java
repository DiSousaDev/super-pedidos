package br.dev.diego.superpedidos.services;

import br.dev.diego.superpedidos.entities.Cidade;
import br.dev.diego.superpedidos.entities.Cliente;
import br.dev.diego.superpedidos.entities.Endereco;
import br.dev.diego.superpedidos.entities.dto.ClienteDto;
import br.dev.diego.superpedidos.entities.dto.ClienteDtoWithTelefoneAndEndereco;
import br.dev.diego.superpedidos.entities.dto.ClienteInsertDto;
import br.dev.diego.superpedidos.entities.dto.ClienteUpdateDto;
import br.dev.diego.superpedidos.entities.enums.TipoCliente;
import br.dev.diego.superpedidos.repositories.ClienteRepository;
import br.dev.diego.superpedidos.repositories.EnderecoRepository;
import br.dev.diego.superpedidos.services.exceptions.DataIntegrityException;
import br.dev.diego.superpedidos.services.exceptions.DatabaseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;
    @Autowired
    private EnderecoRepository enderecoRepository;


    @Transactional(readOnly = true)
    public ClienteDtoWithTelefoneAndEndereco buscar(Integer id) {
        return new ClienteDtoWithTelefoneAndEndereco(repository.buscarClienteComTelefoneEEndereco(id)
                .orElseThrow(() -> new DatabaseNotFoundException("Cliente não encontrado id: " + id + " Objeto " + Cliente.class.getName())));
    }

    @Transactional
    public ClienteDto save(ClienteInsertDto clienteInsertDto) {
        Cliente cliente = repository.save(clienteInsertDtoToCliente(clienteInsertDto));
        enderecoRepository.saveAll(cliente.getEnderecos());
        return new ClienteDto(cliente);
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
            throw new DataIntegrityException("Erro ao excluir cliente com pedido(s) associados id: " + id);
        }
    }

    @Transactional(readOnly = true)
    public Page<ClienteDto> findAllPaged(Pageable pageable) {
        return repository.findAll(pageable).map(ClienteDto::new);
    }

    private Cliente findById(Integer id){
        return repository.findById(id).orElseThrow(() -> new DatabaseNotFoundException("Cliente não encontrado id: " + id + " Objeto " + Cliente.class.getName()));
    }

    private Cliente clienteInsertDtoToCliente(ClienteInsertDto clienteInsertDto) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteInsertDto.getNome());
        cliente.setEmail(clienteInsertDto.getEmail());
        cliente.setCpfOuCnpj(clienteInsertDto.getCpfOuCnpj());
        cliente.setTipoCliente(TipoCliente.toEnum(clienteInsertDto.getTipo()));

        Endereco endereco = new Endereco();
        endereco.setLogradouro(clienteInsertDto.getLogradouro());
        endereco.setNumero(clienteInsertDto.getNumero());
        endereco.setComplemento(clienteInsertDto.getComplemento());
        endereco.setBairro(clienteInsertDto.getBairro());
        endereco.setCep(clienteInsertDto.getCep());
        endereco.setCidade(new Cidade(clienteInsertDto.getCidadeId()));
        endereco.setCliente(cliente);

        cliente.getEnderecos().add(endereco);
        cliente.getTelefones().add(clienteInsertDto.getTelefone1());

        if (clienteInsertDto.getTelefone2() != null) {
            cliente.getTelefones().add(clienteInsertDto.getTelefone2());
        }
        if (clienteInsertDto.getTelefone3() != null) {
            cliente.getTelefones().add(clienteInsertDto.getTelefone3());
        }
        return cliente;
    }


}
