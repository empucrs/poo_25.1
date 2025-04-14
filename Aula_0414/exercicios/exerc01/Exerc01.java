import java.util.Scanner;

public class Exerc01 {

    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        boolean done;
        System.out.println("Inicio do programa");
        do{

            try{
                int i = getInt();
                System.out.println("O valor digitado foi "+i);
                done=true;
            }
            catch(Exception e){
                System.out.println("O valor informado é inválido");
                done=false;
            }
        }while(!done);

        System.out.println("Fim do programa");

    }


    public static int getInt(){

        return Integer.parseInt(sc.nextLine());

    }
}