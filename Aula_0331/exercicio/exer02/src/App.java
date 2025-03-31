public class App {

    public static void main(String[] args) {
        Passagem p = new Passagem("999.999.999-99", "Edson Moreno", null, 1500);
        System.out.println(p);
        int bagagens[] = {10,3,25};
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

        Executive x = new Executive(2000, "01A", "Bill Wisdom", "919.191.999-11");
        System.out.println(x);
        System.out.println("O custo da passagem é R$"+(x.custoBagagem(3, bagagens) + x.defineAssento("15F") + x.getCustoPassagem() ) );
        System.out.println("O custo da bagagem é R$"+x.custoBagagem(3, bagagens) );
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        Premier r = new Premier("191.919.111-99", "Peter Cloud", "000X", 2000);
        System.out.println(r);
        System.out.println("O custo da passagem é R$"+(r.custoBagagem(3, bagagens) + r.defineAssento("15F") + r.getCustoPassagem() ) );
        System.out.println("O custo da bagagem é R$"+r.custoBagagem(3, bagagens) );
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");


    }
    
}
