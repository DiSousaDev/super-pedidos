package br.dev.diego.superpedidos.repositories;

import br.dev.diego.superpedidos.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
