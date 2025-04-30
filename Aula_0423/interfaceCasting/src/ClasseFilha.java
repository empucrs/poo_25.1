public class ClasseFilha extends ClasseBase implements iTest, iCoisa {

    @Override
    public void algumaCoisa() {
        System.out.println("imprime alguma coisa vindo da interface iCoisa");        
    }

    @Override
    public void testa() {
        System.out.println("metodo implementado da interface");        
    }

    @Override
    public void metodo02() {
        System.out.println("metodo sobreescrito de metodo abstrato da classe abstrata");        
    }

    @Override
    public void metodo03() {
        super.metodo03();
        System.out.println("Alem do acesso ao metodo original, imprimo isto aqui");
    }

    

}
