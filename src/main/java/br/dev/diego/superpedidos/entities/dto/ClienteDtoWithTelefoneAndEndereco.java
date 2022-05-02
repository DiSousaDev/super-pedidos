package br.dev.diego.superpedidos.entities.dto;

import br.dev.diego.superpedidos.entities.Cliente;
import br.dev.diego.superpedidos.entities.enums.TipoCliente;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ClienteDtoWithTelefoneAndEndereco {

    private Integer id;
    private String nome;
    private String email;
    private String cpfOuCnpj;
    private Integer tipo;
    private List<EnderecoDto> enderecos = new ArrayList<>();
    private Set<String> telefones = new HashSet<>();

    public ClienteDtoWithTelefoneAndEndereco() {
    }

    public ClienteDtoWithTelefoneAndEndereco(Integer id, String nome, String email, String cpfOuCnpj, Integer tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipo = tipo;
    }

    public ClienteDtoWithTelefoneAndEndereco(Cliente entity) {
        id = entity.getId();
        nome = entity.getNome();
        email = entity.getEmail();
        cpfOuCnpj = entity.getCpfOuCnpj();
        tipo = entity.getTipoCliente() == null ? null : entity.getTipoCliente().getCod();
        enderecos = entity.getEnderecos().stream().map(EnderecoDto::new).collect(Collectors.toList());
        telefones = entity.getTelefones();
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

    public List<EnderecoDto> getEnderecos() {
        return enderecos;
    }

    public Set<String> getTelefones() {
        return telefones;
    }
}
