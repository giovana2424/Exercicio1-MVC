Tabelas Identificadas:
   * model.Cliente - Nome, Telefone 
   * Horário - Hora, Valor, Disponivel 
   * model.Aluguel - model.Cliente, Horários, Data, Valor Total

Regras de Negócio:
* Não permitir cadastrar clientes com nome vazio.
* Não permitir cadastrar horários com valor negativo.
* Não permitir reservar um horário já ocupado.
* Um aluguel deve estar vinculado a:
     * 1 cliente.
     * 1 ou mais horários.
     * 1 data.
* Calcular automaticamente o valor total caso o cliente alugue mais de um horário no mesmo dia.
* Deve ser possível listar todos os aluguéis de um dia específico.
