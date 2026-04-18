import controller.AluguelController;
import model.Aluguel;
import model.Cliente;
import model.Horario;
import service.AluguelService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static List<Aluguel> bancoDeDadosAlugueis = new ArrayList<>();

    public static void main(String[] args) {
        AluguelService aluguelService = new AluguelService();
        AluguelController aluguelController = new AluguelController(aluguelService);

        Horario primeiroHorario = new Horario("10:00", new BigDecimal("100.00"), true);
        Horario segundoHorario = new Horario("11:00", new BigDecimal("100.00"), true);

        Cliente cliente = new Cliente("Ian", "88123456789");

        Aluguel aluguel = aluguelController.realizarAgendamento(cliente, LocalDate.of(2026, 4, 14), primeiroHorario);
        aluguelController.adicionarMaisHorario(aluguel, segundoHorario);
        bancoDeDadosAlugueis.add(aluguel);

        consultarPorData(LocalDate.of(2026, 4, 14));
    }

    public static void consultarPorData(LocalDate dataConsultada) {
        List<Aluguel> resultados = bancoDeDadosAlugueis.stream()
                .filter(a -> a.getDataAluguel().equals(dataConsultada))
                .collect(Collectors.toList());

        if (resultados.isEmpty()) {
            System.out.println("Nenhum aluguel encontrado para esta data.");
        } else {
            resultados.forEach(aluguel -> {
                System.out.println("Data: " + dataConsultada);
                System.out.println("Cliente: " + aluguel.getCliente().getNome());
                for (Horario horario : aluguel.getHorarios()){
                    System.out.println(horario.getHora());
                }
                System.out.println("Total: R$ " + aluguel.getValorTotal());
            });
        }
    }
}