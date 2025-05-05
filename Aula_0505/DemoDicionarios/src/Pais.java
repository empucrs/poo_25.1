public class Pais {
    private int codigo;
    private String nome;
    private int area;
    //...

    public Pais(int umCodigo, String umNome, int umaArea) {
        this.codigo = umCodigo;
        this.nome = umNome;
        this.area = umaArea;
    }

    public String getNome() {
        return nome;
    }

    public void setCodigo(int cod) {
        this.codigo=cod;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", area=" + area +
                '}';
    }
}
