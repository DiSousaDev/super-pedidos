package br.dev.diego.superpedidos.entities.dto;

import br.dev.diego.superpedidos.entities.Cliente;
import br.dev.diego.superpedidos.services.validation.ClienteUpdate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ClienteUpdate
public class ClienteUpdateDto {

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório.")
    @Size(min = 2, max = 120, message = "O tamanho deve estar entre {min} e {max} caracteres.")
    private String nome;

    @NotEmpty(message = "Preenchimento obrigatório.")
    @Email(message = "E-mail inválido.")
    private String email;

    public ClienteUpdateDto() {
    }

    public ClienteUpdateDto(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public ClienteUpdateDto(Cliente entity) {
        id = entity.getId();
        nome = entity.getNome();
        email = entity.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
