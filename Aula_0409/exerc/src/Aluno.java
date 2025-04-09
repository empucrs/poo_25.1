public class Aluno extends Pessoa{

    private String matricula;

    public String getMatricula() {
        return matricula;
    }

    public Aluno(String nome, String cpf, String endereco, String matricula) {
        super(nome, cpf, endereco);
        this.matricula=matricula;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Matricula: "+this.matricula+"\n");
        return super.toString()+sb.toString();
    }
    
}