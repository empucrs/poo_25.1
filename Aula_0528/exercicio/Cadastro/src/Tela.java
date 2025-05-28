import java.awt.Dimension;
import java.awt.ScrollPane;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class Tela extends JFrame{

    private CadastroDePessoa cdp;    
    private JTable tblLista;
    private MyTableModel tableModel;

    public Tela() {
        super("Tela de cadastro");

        cdp = new CadastroDePessoa();

        // Construção do layout da tela
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

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

        JLabel lblIdade = new JLabel("Idade:");
        JTextField tfIdade = new JTextField(50);
        JPanel l3 = new JPanel();
        l3.add(lblIdade);
        l3.add(tfIdade);

        JButton btnAdicionar = new JButton("Adicionar");
        
        tableModel = new MyTableModel();
        tblLista = new JTable(tableModel);
        tblLista.setPreferredScrollableViewportSize(new Dimension(300, 50));
        tblLista.setFillsViewportHeight(true);
        JScrollPane spTable = new JScrollPane(tblLista);
        
        
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.add(l1);
        this.add(l2);
        this.add(l3);
        this.add(btnAdicionar);
        this.add(spTable);
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

        // Definição da interação na tela
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

        btnAdicionar.addActionListener( 
            al -> {

                System.out.println("Iniciando a ação do botão");

                // captura dado da tela
                String matricula = tfMatricula.getText().trim();
                String nome = tfNome.getText().trim();
                String strIdade = tfIdade.getText().trim();

                System.out.println("Dados capturados");

                // validação do dado capturado
                if((matricula.length()==0)||(nome.length()==0)||(strIdade.length()==0))
                    return; // posso lançar um dialog de alerta de campo vazio

                Integer idade=0;
                try {
                    idade = Integer.parseInt(strIdade);
                } catch (Exception e) {
                    return;
                }

                System.out.println("Os dados são válidos");

                // criação do objeto
                Pessoa p = new Pessoa(matricula, nome, idade);
                cdp.adicionaPessoa(p);

                // atualização da tela
                Object [][] novaLista;
                novaLista = new Object[cdp.nPessoas()][];
                int idx=0;
                for(Pessoa aux: cdp.pessoal()){
                    novaLista[idx] = new Object[3];
                    novaLista[idx][0]=aux.getMatrícula();
                    novaLista[idx][1]=aux.getNome();
                    novaLista[idx][2]=aux.getIdade();
                }


                tableModel.setData(novaLista);
                System.out.println("Dados foram adicionados na matriz da tabela");
            }
        );

        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-


        //CLASSE INTERNA DE SUPORTE A TABELA JTABLE

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);        

    }

    class MyTableModel extends AbstractTableModel {
        private String [] columnNames = {"Matrícula", "Nome", "Idade"};        
        private Object [][] data = {{"10083346", "Edson Moreno", 48}};
        private final boolean DEBUG = true;

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
        public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            if (col < 2) {
                return false;
            } else {
                return true;
            }
        }

        public void setData(Object[][] data) {

            this.data = data;

            fireTableDataChanged();
        }
        

        private void printDebugData() {
            int numRows = getRowCount();
            int numCols = getColumnCount();

            for (int i=0; i < numRows; i++) {
                System.out.print("    row " + i + ":");
                for (int j=0; j < numCols; j++) {
                    System.out.print("  " + data[i][j]);
                }
                System.out.println();
            }
            System.out.println("--------------------------");
        }
    }        


    public static void main(String[] args) {
        Tela tl = new Tela();
    }



    
}