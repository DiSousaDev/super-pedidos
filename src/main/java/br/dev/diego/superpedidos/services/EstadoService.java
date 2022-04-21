package br.dev.diego.superpedidos.services;

import br.dev.diego.superpedidos.entities.dto.EstadoDto;
import br.dev.diego.superpedidos.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EstadoService {

    @Autowired
    private EstadoRepository repository;

    @Transactional(readOnly = true)
    public List<EstadoDto> listar() {
        return repository.listarComCidade().stream().map(EstadoDto::new).collect(Collectors.toList());
    }
}
