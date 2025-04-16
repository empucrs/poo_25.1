import java.util.ArrayList;

public class ListaDePessoas {

    private Object[] listaDePessoas;
    private int nPessoas;

    public ListaDePessoas() {
        nPessoas=0;
        listaDePessoas = new Pessoa[100];
    }

    public boolean adicionarPessoa(Pessoa p){
        if(nPessoas<listaDePessoas.length){
            listaDePessoas[nPessoas++]=p;
            return true;
        }
        return false;
    }
    
    public void listarPessoas(){
        for(int i=0; i<nPessoas; i++){
            System.out.println(listaDePessoas[i]);
            System.out.println("-=-=-=-=-=-=\n");
        }
    }

    public int numeroDePessoas(){
        return nPessoas;
    }

    public Object retornaPessoaEspecifica(int idx){

        if((idx<nPessoas) && (idx>=0))
            return listaDePessoas[idx];

        return null;
    }
    
}
