package br.dev.diego.superpedidos.entities.dto;

import br.dev.diego.superpedidos.entities.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProdutoDtoWithCategory {

    private Integer id;
    private String nome;
    private Double preco;

    private List<CategoriaDto> categorias = new ArrayList<>();

    public ProdutoDtoWithCategory() {
    }

    public ProdutoDtoWithCategory(Integer id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public ProdutoDtoWithCategory(Produto entity) {
        id = entity.getId();
        nome = entity.getNome();
        preco = entity.getPreco();
        categorias = entity.getCategorias().stream().map(categoria -> new CategoriaDto(categoria)).collect(Collectors.toList());
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

    public List<CategoriaDto> getCategorias() {
        return categorias;
    }
}
