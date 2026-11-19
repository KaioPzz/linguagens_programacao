public class Caminhonete extends Veiculo {
    public Caminhonete(String placa, String marca, String modelo) { super(placa, marca, modelo); }
    @Override public String getTipo() { return "Caminhonete"; }
    @Override public double getValorHora() { return 18.00; }
}
