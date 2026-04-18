package controller;

import model.Aluguel;
import model.Cliente;
import model.Horario;
import service.AluguelService;

import java.time.LocalDate;

public class AluguelController {
    private AluguelService aluguelService;

    public  AluguelController(AluguelService aluguelService){
        this.aluguelService = aluguelService;
    }

    public Aluguel realizarAgendamento(Cliente cliente, LocalDate dataAluguel, Horario horario){
        Aluguel aluguel = aluguelService.realizarAgendamento(cliente, dataAluguel);
        aluguelService.adicionarHorario(aluguel, horario);
        return aluguel;
    }

    public void adicionarMaisHorario(Aluguel aluguel, Horario novoHorario) {
        aluguelService.adicionarHorario(aluguel, novoHorario);
    }



}
