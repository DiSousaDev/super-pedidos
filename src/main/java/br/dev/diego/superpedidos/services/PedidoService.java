package br.dev.diego.superpedidos.services;

import br.dev.diego.superpedidos.entities.ItemPedido;
import br.dev.diego.superpedidos.entities.PagamentoComBoleto;
import br.dev.diego.superpedidos.entities.Pedido;
import br.dev.diego.superpedidos.entities.dto.PedidoCreatedResponseDto;
import br.dev.diego.superpedidos.entities.dto.PedidoInsertDto;
import br.dev.diego.superpedidos.entities.dto.PedidoResponseDto;
import br.dev.diego.superpedidos.entities.enums.EstadoPagamento;
import br.dev.diego.superpedidos.repositories.ItemPedidoRepository;
import br.dev.diego.superpedidos.repositories.PagamentoRepository;
import br.dev.diego.superpedidos.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private BoletoService boletoService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Transactional(readOnly = true)
    public PedidoResponseDto buscarPorId(Integer id) {
        return new PedidoResponseDto(repository.buscarPorId(id).orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado id " + id)));
    }

    @Transactional
    public PedidoCreatedResponseDto save(PedidoInsertDto obj) {

        Pedido pedido = new Pedido(obj);
        pedido.setId(null);
        pedido.setInstante(Instant.now());
        pedido.getPagamento().setEstado(EstadoPagamento.PENDENTE);
        pedido.getPagamento().setPedido(pedido);

        if(obj.getPagamento() instanceof PagamentoComBoleto) {
            PagamentoComBoleto pagamento = (PagamentoComBoleto) obj.getPagamento();
            boletoService.preencherPagamentoComBoleto(pagamento, obj.getInstante());
        }

        pedido = repository.save(pedido);
        pagamentoRepository.save(obj.getPagamento());

        for(ItemPedido ip : obj.getItens()) {
            ip.setDesconto(0.0);
            ip.setPreco(produtoService.buscarPorId(ip.getProduto().getId()).getPreco());
            ip.setPedido(pedido);
        }

        itemPedidoRepository.saveAll(obj.getItens());

        return new PedidoCreatedResponseDto(pedido);

    }
}
