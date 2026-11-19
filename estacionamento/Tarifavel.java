/** Interface: qualquer coisa que possa ser cobrada por hora. */
public interface Tarifavel {
    double getValorHora();
    double calcularValor(long horasCobradas);
}
