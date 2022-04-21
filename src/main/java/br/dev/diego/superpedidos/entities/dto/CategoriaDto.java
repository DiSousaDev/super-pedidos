package br.dev.diego.superpedidos.entities.dto;

import br.dev.diego.superpedidos.entities.Categoria;

public class CategoriaDto {

    private Integer id;
    private String nome;

    public CategoriaDto() {
    }

    public CategoriaDto(Integer id, String nome) {
        this.id = id;
        this.nome = nome;

    }

    public CategoriaDto(Categoria entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}
