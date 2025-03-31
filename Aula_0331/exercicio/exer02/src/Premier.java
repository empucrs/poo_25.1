public class Premier extends Executive{

    public Premier(String cpf, String nome, String assento, double custo) {
        super(custo, assento, nome, cpf);
    }

    @Override
    public double defineAssento(String assento) {
        return 0;
    }

    @Override
    public double custoBagagem(int qtde, int[] pesos) {
        return super.custoBagagem(qtde, pesos)*0.5;
    }

    @Override
    public int getMilhas() {
        return super.getMilhas()*2;
    }



    
}