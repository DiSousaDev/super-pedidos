package br.dev.diego.superpedidos.services;

import br.dev.diego.superpedidos.entities.Categoria;
import br.dev.diego.superpedidos.entities.Produto;
import br.dev.diego.superpedidos.entities.dto.ProdutoDto;
import br.dev.diego.superpedidos.entities.dto.ProdutoDtoWithCategory;
import br.dev.diego.superpedidos.repositories.CategoriaRepository;
import br.dev.diego.superpedidos.repositories.ProdutoRepository;
import br.dev.diego.superpedidos.services.exceptions.DatabaseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional(readOnly = true)
    public Page<ProdutoDtoWithCategory> findAllPaged(Pageable pageable) {
        Page<Produto> produtosPaged = repository.findAll(pageable);
        repository.buscarProdutosComCategorias(produtosPaged.toList());
        return produtosPaged.map(produto -> new ProdutoDtoWithCategory(produto));
    }

    @Transactional(readOnly = true)
    public Page<ProdutoDto> search(String nome, List<Integer> ids, Pageable pageable) {
        List<Categoria> categorias = categoriaRepository.findAllById(ids);
        return repository.search(nome, categorias, pageable);
    }

    @Transactional(readOnly = true)
    public ProdutoDto buscarPorId(Integer id) {
        return new ProdutoDto(repository.findById(id)
                .orElseThrow(() -> new DatabaseNotFoundException("Produto não encontrado id: " + id + " Objeto " + Produto.class.getName())));
    }

}
