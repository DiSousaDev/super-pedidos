package br.dev.diego.superpedidos.repositories;

import br.dev.diego.superpedidos.entities.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
