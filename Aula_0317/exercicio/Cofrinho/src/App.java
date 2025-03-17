public class App {
    public static void main(String[] args) {
        Cofrinho c = new Cofrinho();

        Moeda m = new Moeda(NomeMoeda.UmReal);
        c.insere(m);
        m = new Moeda(NomeMoeda.Cinquenta);
        c.insere(m);
        m = new Moeda(NomeMoeda.VinteCinco);
        c.insere(m);
        System.out.println(c);
        System.out.println("Valor total em Centavos =    "+c.getValorTotalCentavos());
        System.out.println("Valor total em Reais    = R$ "+c.getValorTotalReais());
        

        System.out.println("Removendo 1 moeda");
        m=c.retira();
        System.out.println("==> Moeda retirada"+m.toString());
        System.out.println("Lista moedas restantes");
        System.out.println(c);
        System.out.println("Valor total em Centavos =    "+c.getValorTotalCentavos());
        System.out.println("Valor total em Reais    = R$ "+c.getValorTotalReais());

        System.out.println("Há "+c.getQtdadeMoedasTipo(NomeMoeda.UmReal)+ " moedas de um real");
        System.out.println("Há "+c.getQtdadeMoedasTipo(NomeMoeda.Cinquenta)+ " moedas de cinquenta centavos");
        System.out.println("Há "+c.getQtdadeMoedasTipo(NomeMoeda.VinteCinco)+ " moedas de vinte e cinco centavos");
        System.out.println("Há "+c.getQtdadeMoedasTipo(NomeMoeda.Dez)+ " moedas de dez centavos");
        System.out.println("Há "+c.getQtdadeMoedasTipo(NomeMoeda.Cinco)+ " moedas de cinco centavos");
        System.out.println("Há "+c.getQtdadeMoedasTipo(NomeMoeda.Um)+ " moedas de um centavo");
        System.out.println("Valor total em Centavos =    "+c.getValorTotalCentavos());
        System.out.println("Valor total em Reais    = R$ "+c.getValorTotalReais());

    }
}
