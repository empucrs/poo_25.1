public class Pessoa {
    private String nome, cpf, endereco;

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public Pessoa(String nome, String cpf, String endereco) {
        this.nome=nome;
        this.cpf=cpf;
        this.endereco=endereco;
    }
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Nome: "+this.nome+"\n");
        sb.append("cpf: "+this.cpf+"\n");
        sb.append("endereço: "+this.endereco+"\n");
        return super.toString();
    }
    
}