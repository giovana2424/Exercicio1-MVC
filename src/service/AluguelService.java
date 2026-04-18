package service;

import model.Aluguel;
import model.Cliente;
import model.Horario;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AluguelService {
    public Aluguel realizarAgendamento(Cliente cliente, LocalDate dataAluguel){
        return new Aluguel(cliente, dataAluguel);
    }
    public void adicionarHorario(Aluguel aluguel, Horario hora) {
        if(!hora.isDisponivel()){
            throw new IllegalArgumentException("O horário escolhido está indisponível.");
        }

        hora.setDisponivel(false);
        aluguel.getHorarios().add(hora);
        recalcularTotal(aluguel);

        BigDecimal novoValorTotal = recalcularTotal(aluguel);
        aluguel.setValorTotal(novoValorTotal);
    }

    private BigDecimal recalcularTotal(Aluguel aluguel) {
        return aluguel.getHorarios().stream()
                .map(Horario::getPreco)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
