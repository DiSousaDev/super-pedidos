package br.dev.diego.superpedidos.entities.dto;

import br.dev.diego.superpedidos.entities.ItemPedido;
import br.dev.diego.superpedidos.entities.Pagamento;
import br.dev.diego.superpedidos.entities.Pedido;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class PedidoDto {

    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private Instant instante;
    private Pagamento pagamento;
    private ClienteDtoWithTelefoneAndEndereco cliente;
    private EnderecoDto enderecoDeEntrega;
    private Set<ItemPedido> itens = new HashSet<>();

    public PedidoDto() {
    }

    public PedidoDto(Pedido entity) {
        id = entity.getId();
        instante = entity.getInstante();
        pagamento = entity.getPagamento();
        cliente = new ClienteDtoWithTelefoneAndEndereco(entity.getCliente());
        enderecoDeEntrega = new EnderecoDto(entity.getEnderecoDeEntrega());
        itens = entity.getItens();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getInstante() {
        return instante;
    }

    public void setInstante(Instant instante) {
        this.instante = instante;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public ClienteDtoWithTelefoneAndEndereco getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDtoWithTelefoneAndEndereco cliente) {
        this.cliente = cliente;
    }

    public EnderecoDto getEnderecoDeEntrega() {
        return enderecoDeEntrega;
    }

    public void setEnderecoDeEntrega(EnderecoDto enderecoDeEntrega) {
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    public Set<ItemPedido> getItens() {
        return itens;
    }
}
