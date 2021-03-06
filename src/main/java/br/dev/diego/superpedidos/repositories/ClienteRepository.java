package br.dev.diego.superpedidos.repositories;

import br.dev.diego.superpedidos.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query("SELECT obj " +
            "FROM Cliente obj " +
            "LEFT JOIN obj.telefones " +
            "LEFT JOIN obj.enderecos " +
            "WHERE obj.id = :id")
    Optional<Cliente> buscarClienteComTelefoneEEndereco(Integer id);

    @Transactional(readOnly = true)
    Optional<Cliente> findByEmail(String email);

}
