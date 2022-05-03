package br.dev.diego.superpedidos.entities;

import br.dev.diego.superpedidos.entities.dto.PedidoInsertDto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_pedido")
public class Pedido extends AbstractEntity<Integer>{

    private Instant instante;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamento;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "endereco_de_entrega_id")
    private Endereco enderecoDeEntrega;

    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> itens = new HashSet<>();

    public Pedido() {
    }

    public Pedido(Integer id, Instant instante, Cliente cliente, Endereco enderecoDeEntrega) {
        super(id);
        this.instante = instante;
        this.cliente = cliente;
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    public Pedido(PedidoInsertDto entity) {
        super(entity.getId());
        instante = entity.getInstante();
        pagamento = entity.getPagamento();
        cliente = new Cliente(entity.getCliente());
        enderecoDeEntrega = new Endereco(entity.getEnderecoDeEntrega());
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEnderecoDeEntrega() {
        return enderecoDeEntrega;
    }

    public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    public Set<ItemPedido> getItens() {
        return itens;
    }

    public double getTotalPedido() {
        double totalPedido = 0.0;
        for (ItemPedido i : itens) {
            totalPedido += i.getSubTotal();
        }
        return totalPedido;
    }

}
