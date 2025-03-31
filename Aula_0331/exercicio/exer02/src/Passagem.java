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
        if(pesos==null) return 0;
        int acum=0;
        for(int pesoBagagem: pesos)
            acum+=pesoBagagem;          
        return acum*0.5;
    }

    public double defineAssento(String assento){
        if(assento!=null){
            this.assento=assento;
            return 5;
        }
        else{
            this.assento=null;
            return 0;
        }
    }

    public double getCustoPassagem(){
        return this.custoPassagem;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Detalhes da passagem\n");
        sb.append("  Nome   : "+this.nome+"\n");
        sb.append("  CPF    : "+this.cpf+"\n");
        sb.append("  Assento: "+this.assento+"\n");
        sb.append("  Custo  : R$ "+this.custoPassagem+"\n");
        
        return sb.toString();
    }

}