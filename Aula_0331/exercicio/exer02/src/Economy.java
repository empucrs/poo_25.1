public class Economy extends Passagem{

    public Economy() {
        super("000.000.000-00", "Desconhecido", null, 0);
    }

    public Economy(String cpf, String nome, String assento, double custo){
        super(cpf, nome, assento, custo);
    }

    @Override
    public double custoBagagem(int qtde, int[] pesos) {
        if(pesos==null) return 0;

        double custoPorPeso = super.custoBagagem(qtde, pesos);
        return custoPorPeso + (pesos.length * 10);
    }
    
}
