import java.util.List;

public class Exerc02 {

    public static void main(String[] args) {
        CadastroFuncionariosOriginal cfo = new CadastroFuncionariosOriginal();

        System.out.println("Item a");
        cfo.getInsalubridadeDependentes().forEach(System.out::println);


        System.out.println("Item b");
        System.out.println("Dos "+cfo.getFuncionarios().size()+" funcionários, "+ cfo.quantidadeFuncionariosComDependentes()+ " tem dependentes.");

        System.out.println("Item c");
        System.out.println("Os valores pagos a qm ganham mais de R% 5.000,00 são R$"+cfo.somatorioSalarioBruto());

        System.out.println("Item d");
        System.out.println("Lista de funcionarios pré aumento");
        for(Funcionario f: cfo.getFuncionarios())
            if(f.getInsalubridade())
              System.out.println("  "+f.getNome()+" => R$"+f.getSalarioBruto());
        System.out.println("-=-=-=-=-");
        System.out.println("Lista de funcionarios pós aumento");
        cfo.aumentaSalarioInsalubres();
        for(Funcionario f: cfo.getFuncionarios())
            if(f.getInsalubridade())
              System.out.println("  "+f.getNome()+" => R$"+f.getSalarioBruto());


        System.out.println("Item e");
        //Retornar uma lista de strings com nome e a matrícula de todos 
        //  os funcionários cujo salário bruto é mais de 10% maior que 
        //  o salário base.
        List<String> detalhes = cfo.getNomeMatriculaSalarioBrutoMaiorQueBase();
        detalhes.forEach(System.out::println);


    }
    
}
