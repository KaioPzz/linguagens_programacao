import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/** Uma passagem do veículo pelo estacionamento (entrada -> saída). */
public class Registro {
    private static final DateTimeFormatter HORA = DateTimeFormatter.ofPattern("HH:mm");
    private static final DateTimeFormatter DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private final Veiculo veiculo;
    private final Vaga vaga;
    private final LocalDateTime entrada;
    private LocalDateTime saida;
    private double valorPago;

    public Registro(Veiculo veiculo, Vaga vaga, LocalDateTime entrada) {
        this.veiculo = veiculo;
        this.vaga = vaga;
        this.entrada = entrada;
    }

    public Veiculo getVeiculo()       { return veiculo; }
    public Vaga getVaga()             { return vaga; }
    public LocalDateTime getEntrada() { return entrada; }
    public LocalDateTime getSaida()   { return saida; }
    public double getValorPago()      { return valorPago; }
    public boolean isAberto()         { return saida == null; }

    /** Qualquer fração de hora conta como hora completa (mínimo 1). */
    public static long horasCobradas(LocalDateTime ent, LocalDateTime sai) {
        long minutos = Duration.between(ent, sai).toMinutes();
        long horas = (long) Math.ceil(minutos / 60.0);
        return Math.max(1, horas);
    }

    public void finalizar(LocalDateTime saida) {
        this.saida = saida;
        this.valorPago = veiculo.calcularValor(horasCobradas(entrada, saida)); // polimorfismo
    }

    public String getEntradaFormatada() { return entrada.format(HORA); }
    public String getSaidaFormatada()   { return saida == null ? "-" : saida.format(HORA); }

    @Override
    public String toString() {
        String s = saida == null ? "ainda estacionado" : saida.format(DATA_HORA)
                + String.format(" | R$ %.2f", valorPago);
        return String.format("%s | Vaga %02d | Entrada %s | Saída %s",
                veiculo, vaga.getNumero(), entrada.format(DATA_HORA), s);
    }
}
