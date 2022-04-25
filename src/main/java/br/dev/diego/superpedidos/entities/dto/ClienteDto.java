package br.dev.diego.superpedidos.entities.dto;

import br.dev.diego.superpedidos.entities.Cliente;
import br.dev.diego.superpedidos.entities.enums.TipoCliente;

public class ClienteDto {

    private Integer id;
    private String nome;
    private String email;
    private String cpfOuCnpj;
    private Integer tipo;

    public ClienteDto() {
    }

    public ClienteDto(Integer id, String nome, String email, String cpfOuCnpj, Integer tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipo = tipo;
    }

    public ClienteDto(Cliente entity) {
        id = entity.getId();
        nome = entity.getNome();
        email = entity.getEmail();
        cpfOuCnpj = entity.getCpfOuCnpj();
        tipo = entity.getTipoCliente().getCod();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public TipoCliente getTipo() {
        return TipoCliente.toEnum(tipo);
    }

}
