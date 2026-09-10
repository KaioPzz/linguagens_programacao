package aulas_pr.pratica10;

public class Main {
    public static void main(String[] args) {

        int soma = 0;

        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                soma = soma + i;
            }
        }

        System.out.println("A soma dos números pares é: " + soma);
    }
}