public class Moto extends Veiculo {
    public Moto(String placa, String marca, String modelo) { super(placa, marca, modelo); }
    @Override public String getTipo() { return "Moto"; }
    @Override public double getValorHora() { return 7.00; }
}
