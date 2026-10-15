
public class Personagem {

    String nome = "";
    int vida = 0;
    List<Tipo> tipo = "";
    List<Poder> poder;

    public Personagem(String nome, int vida, String tipo, String poder){
        this.nome = nome;
        this.vida = vida;
        Tipo tipo1 = new Tipo(tipo);
        this.tipo.add(tipo1);
        Poder poder1 = new Poder(poder);
        this.poder.add(poder1);
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void getNome(){
        return this.nome;

    }

    public int setVida(String vida){
        this.vida = vida;
    }

    public int getVida(){
        return this.vida;
    }
        public static void main(String args[]){
            Personagem person_1 = new Personagem("Batman" , 150, "Vigilante", "Super forca");
            Personagem person_2 = new Personagem("Coringa" , 100, "Palhaco", "Gas do riso");
            System.out.println(person_1.getNome());

            List<Personagem> personagens;
            personagens.add(person_1);
            personagens.add(person_2);
        }
}