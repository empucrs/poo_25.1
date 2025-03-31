public class App {

    public static void main(String[] args) {
        Passagem p = new Passagem("999.999.999-99", "Edson Moreno", null, 1500);
        System.out.println(p);
        int bagagens[] = {3,10,25};
        System.out.println("O custo da passagem é R$"+(p.custoBagagem(3, bagagens) + p.defineAssento("15F") + p.getCustoPassagem() ) );
    }
    
}
