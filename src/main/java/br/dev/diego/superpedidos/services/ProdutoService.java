package br.dev.diego.superpedidos.services;

import br.dev.diego.superpedidos.entities.Produto;
import br.dev.diego.superpedidos.entities.dto.ProdutoDtoWithCategory;
import br.dev.diego.superpedidos.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;


    @Transactional(readOnly = true)
    public Page<ProdutoDtoWithCategory> findAllPaged(Pageable pageable) {
        Page<Produto> page = repository.findAll(pageable);
        repository.buscarProdutosComCategorias(page.toList());
        return page.map(produto -> new ProdutoDtoWithCategory(produto));
    }
}
