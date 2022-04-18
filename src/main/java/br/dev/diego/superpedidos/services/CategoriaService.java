package br.dev.diego.superpedidos.services;

import br.dev.diego.superpedidos.entities.Categoria;
import br.dev.diego.superpedidos.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria buscar(Integer id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada"));
    }


}
