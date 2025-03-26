public class Passagem {

    private String cpf, nome, assento;
    private double custoPassagem;

    public Passagem(String cpf, String nome, String assento, double custo) {
        this.cpf=cpf;
        this.nome=nome;
        this.assento=assento;
        this.custoPassagem=custo;
    }

    public double custoBagagem(int qtde, int[] pesos){
        return 0;
    }

    public double defineAssento(String assento){
        this.assento=assento;
        return 0;
    }

}