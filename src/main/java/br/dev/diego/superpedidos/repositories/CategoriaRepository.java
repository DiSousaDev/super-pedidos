package br.dev.diego.superpedidos.repositories;

import br.dev.diego.superpedidos.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    @Query("SELECT obj FROM Categoria obj LEFT JOIN obj.produtos WHERE obj.id = :id")
    Optional<Categoria> buscarCategoriaComProdutos(Integer id);

}
