package br.dev.diego.superpedidos.repositories;

import br.dev.diego.superpedidos.entities.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EstadoRepository extends JpaRepository<Estado, Integer> {

    @Query("SELECT obj FROM Estado obj JOIN FETCH obj.cidades")
    List<Estado> listarComCidade();

}
