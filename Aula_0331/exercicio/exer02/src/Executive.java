import java.util.Arrays;

public class Executive extends Passagem{

    public Executive(double custoNaEconomy, String assentoDaEconomy, String nomeQualquer, String cpfValido) {
        super(cpfValido, nomeQualquer, assentoDaEconomy, custoNaEconomy);
    }

    public int getMilhas(){
        return (int)(getCustoPassagem()*0.1);
    }

    @Override
    public double custoBagagem(int qtde, int[] pesos) {
        if(pesos==null || pesos.length<=2) return 0;

        int acum=0;
        Arrays.sort(pesos);
        for(int idx=0; idx<pesos.length-2; idx++)
            acum+=pesos[idx];
        return acum*0.5;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("  Milhas:  "+getMilhas()+"\n");
        return sb.toString();
    }
    
}
