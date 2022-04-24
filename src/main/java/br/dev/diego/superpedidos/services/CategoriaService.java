package br.dev.diego.superpedidos.services;

import br.dev.diego.superpedidos.entities.Categoria;
import br.dev.diego.superpedidos.entities.dto.CategoriaDto;
import br.dev.diego.superpedidos.entities.dto.CategoriaDtoWithProdutos;
import br.dev.diego.superpedidos.entities.dto.CategoriaInsertDto;
import br.dev.diego.superpedidos.entities.dto.CategoriaUpdateDto;
import br.dev.diego.superpedidos.repositories.CategoriaRepository;
import br.dev.diego.superpedidos.services.exceptions.DatabaseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Transactional(readOnly = true)
    public CategoriaDtoWithProdutos buscar(Integer id) {
        Categoria categoria = repository.buscarCategoriaComProdutos(id).orElseThrow(() -> new DatabaseNotFoundException("Categoria não encontrada id: " + id + " Objeto " + Categoria.class.getName()));
        return new CategoriaDtoWithProdutos(categoria);
    }

    @Transactional
    public CategoriaDto save(CategoriaInsertDto categoriaInsertDto) {
        Categoria cat = repository.save(categoriaDtoToCategoria(categoriaInsertDto));
        return new CategoriaDto(cat);
    }

    @Transactional
    public CategoriaDto update(Integer id, CategoriaUpdateDto categoriaUpdateDto) {
        Categoria categoria = repository.findById(id).orElseThrow(() -> new DatabaseNotFoundException("Categoria não encontrada id: " + id + " Objeto " + Categoria.class.getName()));
        categoria.setNome(categoriaUpdateDto.getNome());
        repository.save(categoria);
        return new CategoriaDto(categoria);
    }

    private Categoria categoriaDtoToCategoria(CategoriaDto categoriaDto) {
        Categoria categoria = new Categoria();
        categoria.setId(categoriaDto.getId());
        categoria.setNome(categoriaDto.getNome());
        return categoria;
    }

}
