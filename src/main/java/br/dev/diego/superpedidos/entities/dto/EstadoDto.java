package br.dev.diego.superpedidos.entities.dto;

import br.dev.diego.superpedidos.entities.Estado;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EstadoDto {

    private Integer id;
    private String nome;
    private List<CidadeDto> cidades = new ArrayList<>();

    public EstadoDto() {
    }

    public EstadoDto(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public EstadoDto(Estado entity) {
        id = entity.getId();
        nome = entity.getNome();
        cidades = entity.getCidades().stream().map(cidade -> new CidadeDto(cidade)).collect(Collectors.toList());
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<CidadeDto> getCidades() {
        return cidades;
    }
}
