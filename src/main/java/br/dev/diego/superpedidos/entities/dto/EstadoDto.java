package br.dev.diego.superpedidos.entities.dto;

import br.dev.diego.superpedidos.entities.Estado;

public class EstadoDto {

    private Integer id;
    private String nome;

    public EstadoDto() {
    }

    public EstadoDto(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public EstadoDto(Estado entity) {
        id = entity.getId();
        nome = entity.getNome();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}
