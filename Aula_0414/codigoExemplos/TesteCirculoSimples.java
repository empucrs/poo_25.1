public class TesteCirculoSimples {
    public static void main(String[] args) {
        System.out.println("Criando o primeiro circulo - ok");
        Circulo c1 = new Circulo(10,10,10);
        System.out.println(c1.area());

        System.out.println("Criando o segundo circulo - ok");
        c1 = new Circulo(1,1,1);
        System.out.println(c1.area());

        try {
            System.out.println("Criando o terceiro circulo - Nok");
            c1 = new Circulo(1,1,0);
            System.out.println(c1.area());
        } 
        catch (NumberFormatException e) {
            System.out.println("Tipo de dado inválido");
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Indice inválido");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Argumento inválido");
        }
        catch (Exception e) {
            System.out.println("Vai saber Deus que exceção ocorreu, mas ocorreu");
        }


    }
}
