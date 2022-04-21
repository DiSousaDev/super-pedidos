package br.dev.diego.superpedidos.repositories;

import br.dev.diego.superpedidos.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query("SELECT obj FROM Produto obj JOIN FETCH obj.categorias WHERE obj IN :produtos")
    List<Produto> buscarProdutosComCategorias(List<Produto> produtos);

}
