package br.dev.diego.superpedidos.entities.dto;

import br.dev.diego.superpedidos.entities.Categoria;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CategoriaDto {

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório.")
    @Size(min = 5, max = 80, message = "O tamanho deve estar entre {min} e {max} caracteres.")
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
