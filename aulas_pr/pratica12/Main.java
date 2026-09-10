package aulas_pr.pratica12;

public class Main {
    public static void main(String[] args) {

        int[] numeros = {5, -2, 10, -8, 3, 0, 7};

        int positivos = 0;

        for (int numero : numeros) {
            if (numero > 0) {
                positivos++;
            }
        }

        System.out.println("Quantidade de números positivos: " + positivos);
    }
}