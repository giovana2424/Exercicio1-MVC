package model;

import java.math.BigDecimal;

public class Horario {
    private String hora;
    private BigDecimal preco;
    private boolean disponivel;

    public Horario(String hora, BigDecimal preco, boolean disponivel){
        if (hora == null || hora.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        if (preco == null || preco.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        this.hora = hora;
        this.preco = preco;
        this.disponivel = disponivel;
    }

    public String getHora() {
        return hora;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
