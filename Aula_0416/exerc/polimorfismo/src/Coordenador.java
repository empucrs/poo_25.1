public class Coordenador extends Funcionario{

    private String curso;

    public String getCurso() {
        return curso;
    }

    public Coordenador(String nome, String cpf, String endereco, String codigo, double salario, String curso) {
        super(nome, cpf, endereco, codigo, salario);
        this.curso=curso;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Curso: "+this.curso+"\n");
        return super.toString()+sb.toString();
    }
    
}