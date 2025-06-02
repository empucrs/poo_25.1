public class Pessoa {

    private String matrícula, nome;
    private Integer idade;
    private Double peso;

    public Pessoa(String matricula, String nome, Integer idade, Double peso) {
        this.matrícula=matricula;
        this.nome=nome;
        this.idade=idade;
        this.peso=peso;
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

    public Double getPeso() {
        return peso;
    }    
    
}
