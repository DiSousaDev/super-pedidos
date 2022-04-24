package br.dev.diego.superpedidos.services;

import br.dev.diego.superpedidos.entities.dto.PedidoDto;
import br.dev.diego.superpedidos.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Transactional(readOnly = true)
    public PedidoDto buscarPorId(Integer id) {
        return new PedidoDto(repository.buscarPorId(id).orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado id " + id)));
    }
}
