import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exerc01 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot");

        // Item A
        //=======
        System.out.println("Item A");
        //list.forEach(x -> System.out.println(x));
        //list.stream().forEach(palavra -> System.out.println(palavra));
        list.stream().forEach(System.out::println);

        // Item B
        //=======
        System.out.println("Item B");
        System.out.println(list.stream().map(p -> (String) (p.charAt(0)+"")).collect(Collectors.joining("-")));

        // Item C/D
        //=========
        System.out.println("Item C/D");
        List<String> lstUp = list.stream().map(item -> item.toUpperCase()).toList();
        lstUp.forEach(System.out::println);        

        // Item E
        //=======
        System.out.println("Item E");
        List<String> lst6 = list.stream().filter(p->p.length()>=6).toList();
        lst6.forEach(System.out::println);
        System.out.println("São " + lst6.size()+" palavras");

        System.out.println("São "+list.stream().filter(p->p.length()>=6).count()+" palavras com 6 caracteres ou mais");
    }
}