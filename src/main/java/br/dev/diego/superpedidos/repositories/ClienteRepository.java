package br.dev.diego.superpedidos.repositories;

import br.dev.diego.superpedidos.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query("SELECT obj " +
            "FROM Cliente obj " +
            "JOIN FETCH obj.telefones " +
            "JOIN FETCH obj.enderecos " +
            "WHERE obj.id = :id")
    Optional<Cliente> buscarClienteComTelefoneEEndereco(Integer id);

}
