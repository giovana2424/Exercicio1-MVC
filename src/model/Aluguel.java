package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aluguel {
    private Cliente cliente;
    private LocalDate dataAluguel;
    private List<Horario> horarios;
    private BigDecimal valorTotal;

    public Aluguel(Cliente cliente, LocalDate dataAluguel){
        this.cliente = cliente;
        this.dataAluguel = dataAluguel;
        this.horarios = new ArrayList<>();
        this.valorTotal = BigDecimal.ZERO;
    }

    public LocalDate getDataAluguel() {
        return dataAluguel;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public List<Horario> getHorarios(){
        return this.horarios;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
