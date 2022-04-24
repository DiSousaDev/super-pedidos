package br.dev.diego.superpedidos.entities.dto;

import br.dev.diego.superpedidos.entities.Cidade;

public class CidadeDto {

    private Integer id;
    private String nome;

    private EstadoDto estado;

    public CidadeDto() {
    }

    public CidadeDto(Integer id, String nome, EstadoDto estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }

    public CidadeDto(Cidade entity) {
        id = entity.getId();
        nome = entity.getNome();
        estado = new EstadoDto(entity.getEstado());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EstadoDto getEstado() {
        return estado;
    }
}
