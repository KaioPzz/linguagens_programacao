public class Carro extends Veiculo {
    public Carro(String placa, String marca, String modelo) { super(placa, marca, modelo); }
    @Override public String getTipo() { return "Carro"; }
    @Override public double getValorHora() { return 12.00; }
}
