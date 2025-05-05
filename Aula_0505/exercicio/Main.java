import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Set<Integer> conjunto;
        Set<Integer> compara;

        // item 1.1 => 1 pertence a {1,2,3}
        conjunto = new HashSet<>(Arrays.asList(1,2,3));
        compara = new HashSet<>(Arrays.asList(1));
        System.out.println("1 pertence a em "+conjunto+": "+conjunto.contains(1));

        // item 1.2 => vazio está contido em {1,2,3}
        compara = new HashSet<>();
        System.out.println("vazio está contido em "+conjunto+": "+conjunto.containsAll(compara));
        //System.out.println("vazio está contido em {1,2,3}: "+conjunto.containsAll(Arrays.asList()));
        //System.out.println("vazio está contido em {1,2,3}: "+conjunto.containsAll(Collections.emptySet()));

        // item 1.3 => {1,2} ⊆ {1,2,3,4}
        conjunto.add(4);
        compara = new HashSet<>(Arrays.asList(1,2));
        System.out.println("{1,2} não está contido em "+conjunto+": "+!conjunto.containsAll(compara));

        // item 1.4 => {1,2,3,4} − {1,2,5} = {3,4}
        compara = new HashSet<>(Arrays.asList(1,2,5));
        System.out.print("A diferença entre "+conjunto+" - "+compara+" = ");
        conjunto.removeAll(compara);
        System.out.println(conjunto);

        // item 1.5 => {1,2}x{3,4} − {(1,3),(1,4),(2,3),(2,4)}
        HashSet<HashSet<Integer>> conjuntos = new HashSet<>();
        HashSet<Integer> conjA = new HashSet<>(Arrays.asList(1,2));
        HashSet<Integer> conjB = new HashSet<>(Arrays.asList(3,4));
        for(Integer x: conjA)
          for(Integer y: conjB)
            conjuntos.add(new HashSet<>(Arrays.asList(x,y)));
        System.out.print("Resultado: {");
        for(HashSet<Integer> x: conjuntos)
            System.out.print("("+x+"),");
        System.out.println("}");
    }
}