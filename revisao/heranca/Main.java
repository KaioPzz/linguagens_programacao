package revisao.heranca;
import java.util.List;
import java.util.ArrayList;

public class Main {
    private List<Professor> professores = new ArrayList<>();
    private List<Aluno> alunos = new ArrayList<>();

    public static void main(String[] args){
        professor.add(new Professor ("Aeronauta"));
        professor.add(new Professor("Joaquim"));

        alunos.add(new Aluno ("Amarildo"));
        alunos.add(new Aluno ("Thalita"));

        for (Professor prof : professores){
            System.out.println("Nome: "+prof.getNome());
        }

        for(Aluno al : alunos){
            System.out.println("Nome: "+al.getNome());
        }
    }
}