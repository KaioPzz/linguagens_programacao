public class Vaga {
    private final int numero;
    private Veiculo veiculo; // null = livre

    public Vaga(int numero) { this.numero = numero; }

    public int getNumero()      { return numero; }
    public boolean isOcupada()  { return veiculo != null; }
    public Veiculo getVeiculo() { return veiculo; }

    public void ocupar(Veiculo v) {
        if (isOcupada()) throw new IllegalStateException("Vaga " + numero + " já está ocupada.");
        this.veiculo = v;
    }

    public void liberar() { this.veiculo = null; }
}
