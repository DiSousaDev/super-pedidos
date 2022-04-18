package br.dev.diego.superpedidos.entities;

public class Categoria extends AbstractEntity<Integer>{

    private String nome;

    public Categoria(Integer id, String nome) {
        super(id);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
