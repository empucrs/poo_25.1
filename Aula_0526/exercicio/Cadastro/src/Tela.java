import java.awt.Dimension;
import java.awt.ScrollPane;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Tela extends JFrame{

    public Tela() {
        super("Tela de cadastro");

        JLabel lblMatricula = new JLabel("Matrícula: ");
        JTextField tfMatricula = new JTextField(50);
        JPanel l1 = new JPanel();
        l1.add(lblMatricula);
        l1.add(tfMatricula);

        JLabel lblNome = new JLabel("Nome:");
        JTextField tfNome = new JTextField(50);
        JPanel l2 = new JPanel();
        l2.add(lblNome);
        l2.add(tfNome);

        String [] nomeColunas = {"Matrícula", "Nome"};
        Object [][] dados = {{"10083346", "Edson Moreno"}};
        JTable tblLista = new JTable(dados, nomeColunas);
        tblLista.setPreferredScrollableViewportSize(new Dimension(300, 50));
        tblLista.setFillsViewportHeight(true);
        JScrollPane spTable = new JScrollPane(tblLista);
        
        
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.add(l1);
        this.add(l2);
        this.add(spTable);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);        

    }

    public static void main(String[] args) {
        Tela tl = new Tela();
    }

    
}