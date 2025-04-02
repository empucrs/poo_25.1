public class App {

    public static void main(String[] args) {
        Circulo c = new Circulo(1, 0, 3);
        System.out.println("Detalhes sobre o circulo");
        System.out.println("  X    = "+c.getX());
        System.out.println("  Y    = "+c.getY());
        System.out.println("  Raio = "+c.getRaio());
        System.out.println("  Area = "+c.area());
    }
    
}
