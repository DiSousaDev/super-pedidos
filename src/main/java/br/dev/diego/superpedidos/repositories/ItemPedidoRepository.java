package br.dev.diego.superpedidos.repositories;

import br.dev.diego.superpedidos.entities.ItemPedido;
import br.dev.diego.superpedidos.entities.ItemPedidoPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPK> {

}
