package br.dev.diego.superpedidos.entities.dto;

import br.dev.diego.superpedidos.entities.Categoria;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CategoriaDtoWithProdutos {

    private Integer id;
    private String nome;
    private List<ProdutoDto> produtos = new ArrayList<>();

    public CategoriaDtoWithProdutos() {
    }

    public CategoriaDtoWithProdutos(String nome) {
        this.nome = nome;

    }

    public CategoriaDtoWithProdutos(Categoria entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.produtos = entity.getProdutos().stream().map(produto -> new ProdutoDto(produto)).collect(Collectors.toList());
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<ProdutoDto> getProdutos() {
        return produtos;
    }
}
