import javax.swing.*;

public class AloMundo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(AloMundo::criarMostrar);
    }

    private static void criarMostrar() {
        JFrame janela = new JFrame("AloMundo Swing");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel label = new JLabel("Alô, Mundo!");

        janela.getContentPane().add(label);

        janela.pack();
        janela.setVisible(true);
    }
}