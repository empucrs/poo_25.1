public class Funcionario extends Pessoa implements iGeraRenda{
    private String codigo;
    private double salario;

    public String getCodigo() {
        return codigo;
    }

    public double getSalario() {
        return salario;
    }

    public Funcionario(String nome, String cpf, String endereco, String codigo, double salario) {
        super(nome, cpf, endereco);
        this.codigo=codigo;
        this.salario=salario;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Codigo: "+this.codigo+"\n");
        sb.append("Salario: R$"+this.salario+"\n");
        return super.toString()+sb.toString();
    }

    @Override
    public double retornaRenda() {
        return getSalario();
    }
}