import java.util.ArrayList;

public class CadastroFuncionarios{
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<FuncionarioRisco> funcionariosRiscos;

    private void carregaFuncionarios(){
        funcionarios.add(new Funcionario("A3212","Huguinho Pato",1890.0));
        funcionarios.add(new Funcionario("A3312","Zezinho Pato",3720.0));
        funcionarios.add(new Funcionario("A3412","Luizinho Pato",8940.0));
        funcionarios.add(new Funcionario("B9931","Lala Pata",4220.0));
        funcionarios.add(new Funcionario("B9932","Lele Pata",1283.0));
        funcionarios.add(new Funcionario("B9933","Lili Pata",12438.0));

        funcionariosRiscos.add(new FuncionarioRisco("C9931","Lala Risco",1243.0));
        funcionariosRiscos.add(new FuncionarioRisco("C9932","Leli Risco",2438.0));
        funcionariosRiscos.add(new FuncionarioRisco("C9933","Lili Risco",8438.0));

    }

    public CadastroFuncionarios(){
        funcionarios = new ArrayList<>();
        funcionariosRiscos = new ArrayList<>();
        carregaFuncionarios();
    }

    public void cadastraFuncionario(Funcionario funcionario){
        funcionarios.add(funcionario);
    }

    public Funcionario recuperaFuncionarioPorMatricula(String matricula){
        for(Funcionario func:funcionarios){
            if (func.getMatricula().equals(matricula)){
                return func;
            }
        }
        return null;
    }

    public FuncionarioRisco recuperaFuncionarioRiscoPorMatricula(String matricula){
        for(FuncionarioRisco func:funcionariosRiscos){
            if (func.getMatricula().equals(matricula)){
                return func;
            }
        }
        return null;
    }

    
}