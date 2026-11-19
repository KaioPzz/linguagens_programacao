import java.time.LocalDateTime;

/** Teste rápido das regras (sem JUnit). Rode: java TesteCalculo */
public class TesteCalculo {
    public static void main(String[] args) {
        Estacionamento e = new Estacionamento(2);
        LocalDateTime base = LocalDateTime.of(2026, 11, 18, 14, 30);

        Veiculo carro = e.cadastrarVeiculo(new Carro("ABC1234", "Toyota", "Corolla"));
        e.registrarEntrada(carro);
        Registro r = e.registrarSaida("abc1234", LocalDateTime.now().plusHours(2).plusMinutes(20));
        System.out.println("Carro 2h20  -> R$ " + r.getValorPago() + " (esperado 36.0)");

        Veiculo moto = e.cadastrarVeiculo(new Moto("MOT0001", "Honda", "CG"));
        e.registrarEntrada(moto);
        System.out.println("Moto 10min  -> R$ " + e.registrarSaida("MOT0001", LocalDateTime.now().plusMinutes(10)).getValorPago() + " (esperado 7.0)");

        try { e.registrarSaida("ZZZ9999"); } catch (RuntimeException ex) { System.out.println("Saída inexistente: " + ex.getMessage()); }

        e.registrarEntrada(carro);
        try { e.registrarEntrada(carro); } catch (RuntimeException ex) { System.out.println("Duplicado: " + ex.getMessage()); }
        e.registrarEntrada(moto);
        try { e.registrarEntrada(new Caminhonete("CAM0001","Ford","Ranger")); } catch (RuntimeException ex) { System.out.println("Lotado: " + ex.getMessage()); }
    }
}
