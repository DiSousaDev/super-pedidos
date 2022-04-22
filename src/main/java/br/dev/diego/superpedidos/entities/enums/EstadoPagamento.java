package br.dev.diego.superpedidos.entities.enums;

public enum EstadoPagamento {

    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private int cod;
    private String descricao;

    EstadoPagamento(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EstadoPagamento toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }
        for(EstadoPagamento t : EstadoPagamento.values()) {
            if(cod.equals(t.getCod())) {
                return t;
            }
        }
        throw new IllegalArgumentException("Código enum inválido. " + cod);
    }
}
