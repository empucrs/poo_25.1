public class Aluno extends Pessoa{
    private String curso;

    public Aluno(String matricula, String nome, Integer idade, Double peso, String curso) {
        super(matricula, nome, idade, peso);
        this.curso=curso;
    }

    public String getCurso() {
        return curso;
    }
    
}