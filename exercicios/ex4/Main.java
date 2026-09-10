package ex4;
public class Main {
    public static void main(String[] args){
    for (int i = 100; i > 0; i--) {
        System.out.println(i);
    }
    for (int x = 0; x < 10; x++){
        System.out.println("#");
        for (int y = 0; y < 2; y++){
            System.out.print("#");
        }
        System.out.println("");
    }
 }
}