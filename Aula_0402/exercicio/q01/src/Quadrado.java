public class Quadrado extends Retangulo{

    public Quadrado(int x, int y, int lado) {
        super(x, y, lado, lado);
    }

    public int getLado(){
        return getBase();
    }

    
}