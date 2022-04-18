package br.dev.diego.superpedidos.repositories;

import br.dev.diego.superpedidos.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
