import java.util.ArrayList;
import java.util.Iterator;

public class Zoo <T extends Animal> {

    private ArrayList<T> animais;

    private ArrayList<? extends Mamifero> jaulaMamifero;
    private ArrayList<? extends Anfibio>  jaulaAnfibio;
    private ArrayList<? extends Reptil>   jaulaRepteis;
    private ArrayList<? extends Peixe>    jaulaPeixe;
    private ArrayList<? extends Ave>      jaulaAve;

    public Zoo() {
        animais = new ArrayList<>();

        jaulaAnfibio= new ArrayList<>();
        jaulaAve=new ArrayList<>();
        jaulaMamifero=new ArrayList<>();
        jaulaPeixe=new ArrayList<>();
        jaulaRepteis=new ArrayList<>();
    }

    public Iterator<T> getAnimais(){
        return animais.iterator();
    }
    
    public void distribuiAnimais(){
        // TBD
    }
}