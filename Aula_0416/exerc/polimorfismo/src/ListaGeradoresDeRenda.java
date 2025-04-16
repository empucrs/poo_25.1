public class ListaGeradoresDeRenda {

    private iGeraRenda[] lista;
    private int nObjetos;

    public ListaGeradoresDeRenda() {
        lista = new iGeraRenda[100];
        nObjetos=0;
    }

    public boolean adicionarObjeto(iGeraRenda o){
        if((o!=null) &&(nObjetos<lista.length)){
            lista[nObjetos++]=o;
        }
        return false;
    }
    
    public void listarObjetos(){
        for(int i=0; i<nObjetos; i++){
            System.out.println(lista[i]);
        }
    }

    public int numeroDeObjetos(){
        return nObjetos;
    }

    public Object retornaObjetoEspecifico(int idx){
        if((idx<nObjetos)&&(idx>=0))
            return lista[idx];

        return null;

    }



}