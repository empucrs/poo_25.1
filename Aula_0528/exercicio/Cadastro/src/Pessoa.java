public class Pessoa {

    private String matrícula, nome;
    private Integer idade;

    public Pessoa(String matricula, String nome, Integer idade) {
        this.matrícula=matricula;
        this.nome=nome;
        this.idade=idade;
    }

    public String getMatrícula() {
        return matrícula;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }
    
    
}
