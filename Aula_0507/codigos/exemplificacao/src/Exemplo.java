public class Exemplo {

    public static void main(String[] args) {
        Par<Integer, String> p1 = new Par<>(1, "Edson Moreno");
        Par<Integer, String> p2 = new Par<Integer, String> (2, "Sílvia");

        System.out.println("p1.componente1 = "+p1.getComponente1());
        System.out.println("p1.componente2 = "+p1.getComponente2());

        System.out.println("p2.componente1 = "+p2.getComponente1());
        System.out.println("p2.componente2 = "+p2.getComponente2());

        System.out.println("p1 = p2? "+compara(p1, p2));

        Par<Integer, Integer> p3 = new Par<Integer,Integer>(1, 1);
        Par<Integer, Integer> p4 = new Par<Integer,Integer>(2, 2);

        System.out.println("p3 = p4? "+compara(p3, p4));

        Par<Boolean, Boolean> p5 = new Par<>(false, true);
        Par<Boolean, Boolean> p6 = new Par<>(false, true);

        System.out.println("p5 = p6? "+compara(p5, p6));

    }

    private static <T,U> boolean compara(Par<T, U> par1, Par<T, U> par2){
        boolean result=true;

        result &= par1.getComponente1().equals(par2.getComponente1());
        result &= par1.getComponente2().equals(par2.getComponente2());

        return result;
    }

    
}