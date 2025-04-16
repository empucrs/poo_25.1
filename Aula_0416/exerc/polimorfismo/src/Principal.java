import java.security.SecureRandom;

public class Principal {

    public static void main(String[] args) {
        ListaDePessoas lp = new ListaDePessoas();

        // INSTANCIADA UMA PESSOA
        lp.adicionarPessoa(
                new Pessoa("Edson Moreno", 
                            "999.999.999-99", 
                       "Rua 1")
                    );

        // INSTANCIADO UM ALUNO
        lp.adicionarPessoa(
            new Aluno( "Anderson", 
                        "000.000.000-00", 
                   "Rua 2", 
                  "20100000")
                  );

        // INSTANCIADO UM FUNCIONARIO
        lp.adicionarPessoa(
            new Funcionario( "Josberto", 
                             "000.000.000-00", 
                             "Rua 3",  
                             "COD001",
                             1500.01
                             )
                  );

        // INSTANCIADO UM COORDENADOR
        lp.adicionarPessoa(
            new Coordenador( "Alexandre Agustini", 
                             "111.111.111-11", 
                             "Rua 4",  
                             "COD002",
                             15000.02,
                             "Ciência da computação"
                             )
                  );

        // INSTANCIADO UM PROFESSOR
        lp.adicionarPessoa(
            new Professor( "Marcelo Cohen", 
                             "222.222.222-22", 
                             "Rua 5",  
                             "COD003",
                             150000.02,
                             "Computação"
                             )
                  );

        lp.listarPessoas();

        // sorteia "uma pessoa" da lista de pessoas
        SecureRandom sr = new SecureRandom();
        int idx = sr.nextInt(lp.numeroDePessoas());
        Object p = lp.retornaPessoaEspecifica(idx);

        detalhaPessoa(p);

        // TRABALHANDO COM A LISTA DE IGERARENDA
        ListaGeradoresDeRenda lgr = new ListaGeradoresDeRenda();
        lgr.adicionarObjeto(new MaquinaDeRefrigerante(1000, 20000));
        lgr.adicionarObjeto(new Funcionario("Adroaldo", "444.444.444-44", "Rua 6", "COD003", 3002.15));
        lgr.adicionarObjeto(new Coordenador("Alessandra Dutra", "555.555.555-55", "Rua 7", "COD004", 4002.15, "Sistemas de informação"));
        lgr.adicionarObjeto(new Professor("Sergio Filho", "666.666.666-66", "Rua 8", "COD005", 5002.15, "Computação"));
        lgr.listarObjetos();
        idx = sr.nextInt(lgr.numeroDeObjetos());
        p = lgr.retornaObjetoEspecifico(idx);

        detalhaObjeto(p);


    }

    public static void detalhaObjeto(Object p){
        System.out.println("-=-=-=-=-=-");
        System.out.println("Class: "+p.getClass().getName());
        System.out.println(p);
        System.out.println("Renda Gerada: "+((iGeraRenda) p).retornaRenda());
        System.out.println("-=-=-=-=-=-");
    }



    public static void detalhaPessoa(Object p){

        if(p instanceof Professor)
            System.out.println("Eh um Professor");
        else if (p instanceof Coordenador)
            System.out.println("Eh um Coordenador");
        else if (p instanceof Aluno)
            System.out.println("Eh um Aluno");
        else if (p instanceof Funcionario)
            System.out.println("Eh um Funcionario");
        else if (p instanceof Pessoa)
            System.out.println("Eh um Pessoa");
        else
            System.out.println("Isto nunca poderia ter acontecido");

        System.out.println(p);

    }
    
}
