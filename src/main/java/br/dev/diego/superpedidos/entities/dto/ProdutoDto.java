package br.dev.diego.superpedidos.entities.dto;

import br.dev.diego.superpedidos.entities.Produto;

public class ProdutoDto {

    private Integer id;
    private String nome;
    private Double preco;

    public ProdutoDto() {
    }

    public ProdutoDto(Integer id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public ProdutoDto(Produto entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.preco = entity.getPreco();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

}
