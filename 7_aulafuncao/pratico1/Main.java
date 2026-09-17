public class Main{

    static void analisar(int num){
        if (num > 0)
    System.out.println("Numero eh menor que zero.");

        if (num < 0)
    System.out.println("Numero eh maior que zero.");

        if (num == 0)
    System.out.println("Numero eh igual a zero.");
    } 

    public static void main(String[] args){
        analisar(5);
    }
}