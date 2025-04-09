public class Professor extends Funcionario{

    private String departamento;
    
    public Professor(String nome, String cpf, String endereco, String codigo, double salario, String departamento) {
            super(nome, cpf, endereco, codigo, salario);
            this.departamento=departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Departamento: "+this.departamento+"\n");
        return super.toString()+sb.toString();
    }    
    
}