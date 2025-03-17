public class Cofrinho {

    private Moeda [] listaDeMoedas;
    private int posicaoLivre;

    public Cofrinho(){
        this.listaDeMoedas = new Moeda[10];
        this.posicaoLivre=0;
    }

    public boolean insere(Moeda moeda){
        if(posicaoLivre>=listaDeMoedas.length)
            return false;
        listaDeMoedas[posicaoLivre]=moeda;
        posicaoLivre++;
        return true;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();

        result.append("Lista de moedas:\n");
        for(int i=0; i<posicaoLivre; i++)
          result.append("  "+listaDeMoedas[i].toString()+"\n");

        return result.toString();
    }

    public Moeda retira(){
        if(posicaoLivre==0)
            return null;

        posicaoLivre--;
        return listaDeMoedas[posicaoLivre];

    }

    public int getQtdadeMoedas(){
        return posicaoLivre;
    }

    public int getQtdadeMoedasTipo(NomeMoeda nomeMoeda){
        int qtde=0;

        for(int i=0; i<posicaoLivre; i++)
          if(listaDeMoedas[i].getNomeMoeda()==nomeMoeda)
            qtde++;

        return qtde;
    }


    public int getValorTotalCentavos(){
        int valorTotalEmCentavos=0;

//        for (Moeda moeda : listaDeMoedas);
        for(int i=0; i<posicaoLivre; i++)
            valorTotalEmCentavos+=listaDeMoedas[i].getValorCentavos();

        return valorTotalEmCentavos;

    }

    public double getValorTotalReais(){
        double valorTotalEmReais=0;

//        for (Moeda moeda : listaDeMoedas);
        for(int i=0; i<posicaoLivre; i++)
            valorTotalEmReais+=listaDeMoedas[i].getValorReais();

        return valorTotalEmReais;
    }
    
}
