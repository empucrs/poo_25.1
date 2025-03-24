public class Funcionario{
    public static final double LIM_ISENCAO_IR = 2000;
    private String matricula;
    private String nome;
    private double salarioBruto;
    private String categoria;
    
    public Funcionario(String matricula, String nome, double salarioBruto){
        this(matricula, nome, salarioBruto, "");
    }

    public Funcionario(String matricula, String nome, double salarioBruto, String categoria){
        this.matricula = matricula;
        this.nome = nome;
        this.salarioBruto = salarioBruto;
        if((categoria!=null)&&(categoria.toLowerCase().equals("risco")))
            this.categoria="RISCO";
        else   
            this.categoria="";
    }

	public String getMatricula() {
		return matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public double getSalarioBruto() {
		return salarioBruto;
	}
    
    public double getINSS(){
        return salarioBruto*0.1;
    }

    public double getImpRenda(){
        double novoSB=salarioBruto;

        if(this.categoria.equals("RISCO"))
            novoSB=salarioBruto-getINSS()+adicional();


        if (novoSB <= LIM_ISENCAO_IR){
            return 0.0;
        }else{
            double aux = novoSB - LIM_ISENCAO_IR;
            double ir = aux * 0.2;
            return ir;
        }
    }

    public double adicional(){
        if(! this.categoria.equals("RISCO"))
            return 0;
        
        return (salarioBruto - getINSS())*0.25;

    }

    public double getSalarioLiquido(){        
        return salarioBruto - getINSS() + adicional() - getImpRenda();
    }

    public String toString() {
        String aux = "";
        aux += "Categoria: "+this.getClass().getName()+(" "+this.categoria)+"\n";
        aux += "Matricula: "+this.getMatricula()+"\n";
        aux += "Nome: "+this.getNome()+"\n";
        aux += "Salario bruto: "+this.getSalarioBruto()+"\n";
        aux += "(-) INSS: "+this.getINSS()+"\n";
        if(categoria.equals("RISCO"))
            aux += "(+) INSALUBRIDADE: "+this.adicional()+"\n";
        aux += "(-) IR: "+this.getImpRenda()+"\n";
        aux += "Salario liquido: "+this.getSalarioLiquido()+"\n";
        aux += "----------";
        return aux;    
    }
}