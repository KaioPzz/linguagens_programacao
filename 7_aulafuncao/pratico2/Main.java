public class Main{
    static void analisar(String nome, int nota){
     if (nota >= 7)
        System.out.println("O aluno(a): " + nome + "Esta aprovado com nota: " + nota);
        else
        System.out.println("O aluno(a)" + nome + "Esta reprovado com nota: " + nota);
    }

    public static void main(String[] args) {
        analisar("Joao", 7);
        analisar("Luiz", 5);
    }
}