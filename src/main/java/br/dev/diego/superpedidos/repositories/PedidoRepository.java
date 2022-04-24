package br.dev.diego.superpedidos.repositories;

import br.dev.diego.superpedidos.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    @Query("SELECT obj " +
            "FROM Pedido obj " +
            "JOIN FETCH obj.cliente " +
            "JOIN FETCH obj.itens " +
            "JOIN FETCH obj.pagamento " +
            "WHERE obj.id = :id")
    Optional<Pedido> buscarPorId(Integer id);


}
