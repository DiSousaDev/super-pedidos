package br.dev.diego.superpedidos.repositories;

import br.dev.diego.superpedidos.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
