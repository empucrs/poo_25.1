import java.security.SecureRandom;

public class MaquinaDeRefrigerante implements iGeraRenda{

    private final double valorMinimo, valorMaximo;

    public MaquinaDeRefrigerante(double vmi,double vmx) {
        this.valorMinimo=vmi;
        this.valorMaximo=vmx;
    }

    @Override
    public double retornaRenda() {        
        SecureRandom sr = new SecureRandom();
        double result = sr.nextDouble(valorMinimo, valorMaximo);
        return result;
    }
    
}