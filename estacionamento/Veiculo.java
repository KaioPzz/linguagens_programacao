/** Classe abstrata base. Subclasses definem tipo e tarifa (polimorfismo). */
public abstract class Veiculo implements Tarifavel {
    private final String placa;
    private final String marca;
    private final String modelo;

    protected Veiculo(String placa, String marca, String modelo) {
        this.placa = placa.trim().toUpperCase();
        this.marca = marca.trim();
        this.modelo = modelo.trim();
    }

    public String getPlaca()  { return placa; }
    public String getMarca()  { return marca; }
    public String getModelo() { return modelo; }

    public abstract String getTipo();

    /** Primeira hora = valor da categoria; cada hora adicional também. */
    @Override
    public double calcularValor(long horasCobradas) {
        return horasCobradas * getValorHora();
    }

    @Override
    public String toString() {
        return String.format("%s | %s %s | %s", placa, marca, modelo, getTipo());
    }
}
