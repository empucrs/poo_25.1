public class TesteInteger {
    public static void main(String[] args) {

        System.out.println("Inicio do programa\n");
        try {
            System.out.println("Nova conversão para inteiro");
            int i = Integer.parseInt("123");
            System.out.println(i);
            System.out.println("Número convertido com sucesso");
        } catch (NumberFormatException e) {
            System.out.println("Erro na conversão do dado informado");
        }

        System.out.println("\nmensagem entre tries\n");

        try {
            System.out.println("Nova conversão para inteiro");
            int j = Integer.parseInt("abc");
            System.out.println(j);
            System.out.println("Número convertido com sucesso");
        } catch (NumberFormatException e) {
            System.out.println("Erro na conversão do dado informado");
        }

        System.out.println("Fim do programa\n");

    }
}
