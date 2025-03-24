import java.util.ArrayList;

public class CadastroFuncionarios{
    private ArrayList<Funcionario> funcionarios;

    private void carregaFuncionarios(){
        funcionarios.add(new Funcionario("A3212","Huguinho Pato",1890.0));
        funcionarios.add(new Funcionario("A3312","Zezinho Pato",3720.0));
        funcionarios.add(new Funcionario("A3412","Luizinho Pato",8940.0));
        funcionarios.add(new Funcionario("B9931","Lala Pata",4220.0));
        funcionarios.add(new Funcionario("B9932","Lele Pata",1283.0));
        funcionarios.add(new Funcionario("B9933","Lili Pata",12438.0));
        funcionarios.add(new Funcionario("C9931","Lala Risco",1500.0, "risco"));
        funcionarios.add(new Funcionario("C9932","Lele Risco",2500.0, "Risco"));
        funcionarios.add(new Funcionario("C9933","Lili Risco",8000.0, "RISCO"));
    }

    public CadastroFuncionarios(){
        funcionarios = new ArrayList<>();
        carregaFuncionarios();
    }

    public void cadastraFuncionario(Funcionario funcionario){
        funcionarios.add(funcionario);
    }

    public Funcionario recuperaPorMatricula(String matricula){
        for(Funcionario func:funcionarios){
            if (func.getMatricula().equals(matricula)){
                return func;
            }
        }
        return null;
    }
}