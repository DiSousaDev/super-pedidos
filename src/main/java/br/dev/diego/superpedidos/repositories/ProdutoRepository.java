package br.dev.diego.superpedidos.repositories;

import br.dev.diego.superpedidos.entities.Categoria;
import br.dev.diego.superpedidos.entities.Produto;
import br.dev.diego.superpedidos.entities.dto.ProdutoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query("SELECT obj FROM Produto obj JOIN FETCH obj.categorias WHERE obj IN :produtos")
    List<Produto> buscarProdutosComCategorias(List<Produto> produtos);


    @Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE lower(obj.nome) LIKE lower(concat('%', :nome, '%'))  AND cat IN :categorias")
    Page<ProdutoDto> search(@Param("nome") String nome, @Param("categorias") List<Categoria> categorias, Pageable pageable);
    // named Query mesma consulta
    // findDistinctByNomeContainingAndCategoriasIn

}
