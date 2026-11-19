import java.time.Duration;
import java.util.Scanner;

public class Main {
    private static final Scanner in = new Scanner(System.in);
    private static final Estacionamento est = new Estacionamento(10);

    public static void main(String[] args) {
        int op;
        do {
            exibirMenu();
            op = lerInt("Escolha uma opção: ");
            switch (op) {
                case 1 -> entrada();
                case 2 -> saida();
                case 3 -> consultarVagas();
                case 4 -> listarEstacionados();
                case 5 -> consultarPlaca();
                case 6 -> historico();
                case 0 -> System.out.println("Encerrando o sistema. Até logo!");
                default -> System.out.println("Opção inválida! Escolha um número do menu.");
            }
        } while (op != 0);
    }

    private static void exibirMenu() {
        System.out.println("\n====================================");
        System.out.println(" SISTEMA DE ESTACIONAMENTO");
        System.out.println("====================================");
        System.out.println("1 - Registrar entrada de veículo");
        System.out.println("2 - Registrar saída de veículo");
        System.out.println("3 - Consultar vagas disponíveis");
        System.out.println("4 - Listar veículos estacionados");
        System.out.println("5 - Consultar veículo pela placa");
        System.out.println("6 - Histórico de entradas e saídas");
        System.out.println("0 - Sair");
    }

    private static void entrada() {
        titulo("ENTRADA DE VEÍCULO");
        System.out.print("Informe a placa: ");
        String placa = in.nextLine().trim();
        if (placa.isEmpty()) { System.out.println("Placa não pode ser vazia."); return; }
        try {
            Veiculo v = est.buscarCadastrado(placa);
            if (v == null) {
                System.out.print("Informe a marca: ");
                String marca = in.nextLine();
                System.out.print("Informe o modelo: ");
                String modelo = in.nextLine();
                System.out.println("Tipo de veículo:\n1 - Carro\n2 - Moto\n3 - Caminhonete");
                int tipo = lerInt("Escolha: ");
                v = switch (tipo) {
                    case 1 -> new Carro(placa, marca, modelo);
                    case 2 -> new Moto(placa, marca, modelo);
                    case 3 -> new Caminhonete(placa, marca, modelo);
                    default -> null;
                };
                if (v == null) { System.out.println("Tipo de veículo inválido."); return; }
                est.cadastrarVeiculo(v);
            } else {
                System.out.println("Veículo já cadastrado: " + v);
            }
            Registro r = est.registrarEntrada(v);
            System.out.println("Veículo registrado com sucesso!");
            System.out.printf("Vaga ocupada: %02d%n", r.getVaga().getNumero());
            System.out.println("Horário de entrada: " + r.getEntradaFormatada());
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void saida() {
        titulo("SAÍDA DE VEÍCULO");
        System.out.print("Informe a placa: ");
        String placa = in.nextLine();
        try {
            Registro r = est.registrarSaida(placa);
            long min = Duration.between(r.getEntrada(), r.getSaida()).toMinutes();
            long horas = Registro.horasCobradas(r.getEntrada(), r.getSaida());
            System.out.println("Horário de entrada: " + r.getEntradaFormatada());
            System.out.println("Horário de saída: " + r.getSaidaFormatada());
            System.out.printf("Tempo de permanência: %dh%02dmin (%d hora(s) cobrada(s))%n", min / 60, min % 60, horas);
            System.out.printf("Valor do estacionamento: R$ %.2f%n", r.getValorPago());
            System.out.printf("Vaga %02d liberada com sucesso!%n", r.getVaga().getNumero());
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void consultarVagas() {
        titulo("VAGAS");
        for (Vaga v : est.getVagas()) {
            System.out.printf("Vaga %02d - %s%n", v.getNumero(),
                    v.isOcupada() ? "OCUPADA (" + v.getVeiculo().getPlaca() + ")" : "Disponível");
        }
        System.out.println("Livres: " + est.contarLivres() + " de " + est.getVagas().size());
    }

    private static void listarEstacionados() {
        titulo("VEÍCULOS ESTACIONADOS");
        if (est.getEstacionados().isEmpty()) { System.out.println("Nenhum veículo estacionado."); return; }
        for (Registro r : est.getEstacionados())
            System.out.printf("Vaga %02d | %s | Entrada %s%n",
                    r.getVaga().getNumero(), r.getVeiculo(), r.getEntradaFormatada());
    }

    private static void consultarPlaca() {
        titulo("CONSULTAR VEÍCULO");
        System.out.print("Informe a placa: ");
        String placa = in.nextLine();
        Registro r = est.consultarEstacionado(placa);
        if (r != null) {
            System.out.println("Veículo estacionado: " + r.getVeiculo());
            System.out.printf("Vaga %02d | Entrada %s%n", r.getVaga().getNumero(), r.getEntradaFormatada());
        } else if (est.buscarCadastrado(placa) != null) {
            System.out.println("Veículo cadastrado, mas fora do estacionamento: " + est.buscarCadastrado(placa));
        } else {
            System.out.println("Nenhum veículo encontrado com essa placa.");
        }
    }

    private static void historico() {
        titulo("HISTÓRICO");
        if (est.getHistorico().isEmpty()) { System.out.println("Sem registros ainda."); return; }
        est.getHistorico().forEach(System.out::println);
    }

    private static void titulo(String t) {
        System.out.println("\n====================================");
        System.out.println(" " + t);
        System.out.println("====================================");
    }

    private static int lerInt(String msg) {
        System.out.print(msg);
        try { return Integer.parseInt(in.nextLine().trim()); }
        catch (NumberFormatException e) { return -1; }
    }
}
