package br.dev.diego.superpedidos.entities.dto;

import br.dev.diego.superpedidos.entities.Pedido;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;

public class PedidoCreatedResponseDto {

    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private Instant instante;

    public PedidoCreatedResponseDto() {
    }

    public PedidoCreatedResponseDto(Pedido entity) {
        id = entity.getId();
        instante = entity.getInstante();
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

}
