package br.dev.diego.superpedidos.entities.dto;

import br.dev.diego.superpedidos.entities.Endereco;

public class EnderecoDto {

    private Integer id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    private CidadeDto cidade;

    public EnderecoDto() {
    }

    public EnderecoDto(Integer id, String logradouro, String numero, String complemento, String bairro, String cep, CidadeDto cidade) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
    }

    public EnderecoDto(Endereco entity) {
        id = entity.getId();
        logradouro = entity.getLogradouro();
        numero = entity.getNumero();
        complemento = entity.getComplemento();
        bairro = entity.getBairro();
        cep = entity.getCep();
        cidade = new CidadeDto(entity.getCidade());
    }

    public Integer getId() {
        return id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    public CidadeDto getCidade() {
        return cidade;
    }
}
