public class App {
    public static void main(String[] args) {
        iTest a = new Abc();

        a.testa();

        ((Abc) a).qqCoisa();

        System.out.println("-=-=-=-=-");
        ClasseFilha cf = new ClasseFilha();
        cf.algumaCoisa();
        System.out.println("==");
        cf.metodo01();
        System.out.println("==");
        cf.metodo02();
        System.out.println("==");
        cf.metodo03();
        System.out.println("==");
        cf.testa();
        System.out.println("==");
    }
}
