public class App {

    public static void main(String[] args) {
        Circulo c = new Circulo(1, 0, 3);
        System.out.println("Detalhes sobre o circulo");
        System.out.println("  X    = "+c.getX());
        System.out.println("  Y    = "+c.getY());
        System.out.println("  Raio = "+c.getRaio());
        System.out.println("  Area = "+c.area());

        Retangulo r = new Retangulo(1, 0, 10, 20);
        System.out.println("Detalhes sobre o retangulo");
        System.out.println("  X      = "+r.getX());
        System.out.println("  Y      = "+r.getY());
        System.out.println("  Base   = "+r.getBase());
        System.out.println("  Altura = "+r.getAltura());
        System.out.println("  Area   = "+r.area());

        Quadrado q = new Quadrado(1, 0, 15);
        System.out.println("Detalhes sobre o quadrado");
        System.out.println("  X    = "+q.getX());
        System.out.println("  Y    = "+q.getY());
        System.out.println("  Lado = "+q.getLado());
        System.out.println("  Area = "+q.area());
    }
    
}
