import java.util.Scanner;

public class TerminalConsulta {
    private CadastroFuncionarios cadastro;

    public TerminalConsulta() {
        cadastro = new CadastroFuncionarios();
    }

    public void menu() {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("Entre a matricula do funcionario (0=fim): ");
            String matricula = s.nextLine();
            if (matricula.equals("0")){
                break; // Quebra o while
            }
            Funcionario func = cadastro.recuperaFuncionarioPorMatricula(matricula);
            FuncionarioRisco funcR=null;
            if(func==null) funcR = cadastro.recuperaFuncionarioRiscoPorMatricula(matricula);

            System.out.println("----------");
            if (func == null && funcR == null) {
                System.out.println("Funcionario nao encontrado !!");
            }else if(func != null){
                System.out.println(func.toString());
            }
            else{
                System.out.println(funcR.toString());
            }
            System.out.println("Digite qualquer tecla para continuar.\n");
            s.nextLine();
        }
        s.close();
    }
}