package aulas_pr.pratica3;

public class Main {
    public static void main(String[] args) {
        int nota = 5;

        if (nota >= 6) {
            System.out.println("Aprovado");
        } else if (nota >= 4) {
            System.out.println("Recuperação");
        } else {
            System.out.println("Reprovado");
        }
    }
}