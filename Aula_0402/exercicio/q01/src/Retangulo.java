public class Retangulo extends FiguraBidimensional{
    //centrox e centro y será o ponto inferior esquerdo do retangulo
    private int base, altura;
    public Retangulo(int x, int y, int base, int altura) {
        super(x, y);
        this.base=base;
        this.altura=altura;
    }

    public int getAltura(){
        return altura;
    }

    public int getBase(){
        return base;
    }

    @Override
    public double area() {
        return base*altura;
    }

    
}