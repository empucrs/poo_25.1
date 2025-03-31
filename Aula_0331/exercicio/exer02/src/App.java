public class App {

    public static void main(String[] args) {
        Passagem p = new Passagem("999.999.999-99", "Edson Moreno", null, 1500);
        System.out.println(p);
        int bagagens[] = {3,10,25};
        System.out.println("O custo da passagem é R$"+(p.custoBagagem(3, bagagens) + p.defineAssento("15F") + p.getCustoPassagem() ) );
        System.out.println("O custo da bagagem é R$"+p.custoBagagem(3, bagagens) );
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");


        Economy e = new Economy();
        System.out.println(e);
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        e = new Economy("888.888.888-88", "Joao Figueiro", "03C", 1234.5);
        System.out.println(e);
        System.out.println("O custo da passagem é R$"+(e.custoBagagem(3, bagagens) + e.defineAssento("15F") + p.getCustoPassagem() ) );
        System.out.println("O custo da bagagem é R$"+e.custoBagagem(3, bagagens) );
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");


    }
    
}
