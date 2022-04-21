package br.dev.diego.superpedidos.entities.dto;

import br.dev.diego.superpedidos.entities.Cidade;

public class CidadeDto {

    private Integer id;
    private String nome;

    public CidadeDto() {
    }

    public CidadeDto(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CidadeDto(Cidade entity) {
        id = entity.getId();
        nome = entity.getNome();
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

}
