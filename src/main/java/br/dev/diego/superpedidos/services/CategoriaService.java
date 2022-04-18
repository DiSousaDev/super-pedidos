package br.dev.diego.superpedidos.services;

import br.dev.diego.superpedidos.entities.Categoria;
import br.dev.diego.superpedidos.repositories.CategoriaRepository;
import br.dev.diego.superpedidos.services.exceptions.DatabaseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria buscar(Integer id) {
        return repository.findById(id).orElseThrow(() -> new DatabaseNotFoundException("Categoria não encontrada id: " + id + " Objeto " + Categoria.class.getName()));
    }


}
