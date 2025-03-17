import java.util.ArrayList;

public class Cofrinho {

    private ArrayList<Moeda> listaDeMoedas;

    public Cofrinho(){
        this.listaDeMoedas = new ArrayList<>();
    }

    public boolean insere(Moeda moeda){
        return listaDeMoedas.add(moeda);
    }

    public String toString(){
        StringBuilder result = new StringBuilder();

        result.append("Lista de moedas:\n");
        for(int i=0; i<listaDeMoedas.size(); i++)
          result.append("  "+listaDeMoedas.get(i).toString()+"\n");

        return result.toString();
    }

    public Moeda retira(){
        return listaDeMoedas.removeLast();
    }

    public int getQtdadeMoedas(){
        return listaDeMoedas.size();
    }

    public int getQtdadeMoedasTipo(NomeMoeda nomeMoeda){
        int qtde=0;

        for (Moeda moeda : listaDeMoedas)
            if(moeda.getNomeMoeda()==nomeMoeda)
                qtde++;

        return qtde;
    }


    public int getValorTotalCentavos(){
        int valorTotalEmCentavos=0;

        for (Moeda moeda : listaDeMoedas)
            valorTotalEmCentavos+=moeda.getValorCentavos();

        return valorTotalEmCentavos;

    }

    public double getValorTotalReais(){
        double valorTotalEmReais=0;

        for (Moeda moeda : listaDeMoedas)
            valorTotalEmReais+=moeda.getValorReais();

        return valorTotalEmReais;
    }
    
}
