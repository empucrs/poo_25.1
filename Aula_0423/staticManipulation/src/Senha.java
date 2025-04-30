public class Senha {

    public static int senhaInicial;
    public int minhaSenha;

    public Senha() {
        this.minhaSenha = senhaInicial++;
        System.out.println("Minha Senha:"+this.minhaSenha);
    }
}