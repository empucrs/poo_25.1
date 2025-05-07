public class Par <A, B> {
    private A componente1;
    private B componente2;

    public Par(A comp1, B comp2) {
        this.componente1=comp1;
        this.componente2=comp2;
    }

    public A getComponente1(){
        return componente1;
    }

    public B getComponente2(){
        return componente2;
    }    
}
