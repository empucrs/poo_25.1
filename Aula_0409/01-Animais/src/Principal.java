class Principal{
    
	public static void main(String args[]){
        // objetos normais
        System.out.println("Objetos normais");
		Animal a = new Animal();
		a.som();
		Cachorro c = new Cachorro();
		c.som();
		Gato g = new Gato();
		g.som();


        // Passo 1 de polimorfismo
        System.out.println("\nPasso 1 de polimorfismo");
        a = new Cachorro();
        a.som();
        a = new Gato();
        a.som();

        // Passo 2 de polimorfismo
        System.out.println("\nPasso 2 de polimorfismo");
        a=c;  // <-- UPCASTING
        a.som();
        a=g;
        a.som();
        
        // Passo 3 de polimorfismo
        System.out.println("\nPasso 3 de polimorfismo");
        a=c; // a referencia um cachorro
        //a.late(); // a referencia um cachorro - ERRO
        ((Cachorro) a).late(); // a referencia um cachorro - ERRO
        
        // Passo 4 de polimorfismo
        System.out.println("\nPasso 4 de polimorfismo");
        //c=a; // Downcasting - Erro
        
        //a = new Gato(); //- Causa ERRO qdo casting é inválido
        
        c = (Cachorro) a;
        c.som();
        c.late();
        
        // Passo 5 de polimorfismo
        System.out.println("\nPasso 5 de polimorfismo");
        System.out.println("-=-=-=-=-=-=-");
        tipoAnimal(new Animal());
        System.out.println("-=-=-=-=-=-=-");
        tipoAnimal(new Cachorro());
        System.out.println("-=-=-=-=-=-=-");
        tipoAnimal(new Gato());
        System.out.println("-=-=-=-=-=-=-");
	}

    public static void tipoAnimal(Animal tipo){
        if(tipo instanceof Cachorro){
            System.out.println("\né um Cachorro");
            Cachorro tmp = (Cachorro) tipo;
            tmp.som();
            tmp.late();
        }
        //else if(tipo instanceof Gato){
        if(tipo instanceof Gato){
                System.out.println("\né um Gato");
            Gato tmp = (Gato) tipo;
            tmp.som();
            tmp.mia();
        }
        //else{
        if(tipo instanceof Animal){
            System.out.println("\né um Animal");
            Animal tmp = tipo;
            tmp.som();
        }

        if(tipo instanceof Object){
            System.out.println("\né um Object");
            System.out.println(((Object) tipo).getClass().getName());
        }
    
    }
 

   
}