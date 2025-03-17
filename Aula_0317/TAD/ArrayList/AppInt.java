import java.util.ArrayList;

public class AppInt {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(10);
        lista.add(5);
        lista.add(15);
        lista.add(12);
        lista.add(7);
        lista.add(19);

        System.out.println(lista);

        lista.remove(2);
        System.out.println(lista);

        lista.remove(0);
        System.out.println(lista);

        lista.remove(3);
        System.out.println(lista);
    }
}
