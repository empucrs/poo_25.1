import java.util.ArrayList;

public class AppStr {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Edson");
        lista.add("Francisco");
        lista.add("Silvia");
        lista.add("Antonio");
        lista.add("Augusto");
        lista.add("Carolina");

        System.out.println(lista);

        lista.remove(2);
        System.out.println(lista);

        lista.remove(0);
        System.out.println(lista);

        lista.remove(3);
        System.out.println(lista);
    }
}
