import java.awt.Dimension;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.ScrollPane;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Tela extends JFrame{

    private CadastroDePessoa cdp;    
    private JTable tblLista;
    private DefaultTableModel tableModel;    

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

        JLabel lblPeso = new JLabel("Peso:");
        JTextField tfPeso = new JTextField(50);
        JPanel l4 = new JPanel();
        l4.add(lblPeso);
        l4.add(tfPeso);

        JCheckBox jcbProfessor = new JCheckBox("Professor: ");
        jcbProfessor.setSelected(true);

        JButton btnAdicionar = new JButton("Adicionar");
        
        // Codificação da tabela para garantir dinamicidade
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
        String [] columnNames = {"Matrícula", "Nome", "Idade", "Peso"};
        tableModel = new DefaultTableModel(columnNames, 0);

        tblLista = new JTable(tableModel);
        tblLista.setPreferredScrollableViewportSize(new Dimension(300, 50));
        tblLista.setFillsViewportHeight(true);
        JScrollPane spTable = new JScrollPane(tblLista);
        carregaDadosDoArquivo(cdp, tableModel);
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=        
        
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.add(l1);
        this.add(l2);
        this.add(l3);
        this.add(l4);
        this.add(jcbProfessor);
        this.add(btnAdicionar);
        this.add(spTable);        
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

        // Elaboração de um menu inicial
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
        Menu mArquivo = new Menu("Arquivo");
        MenuItem miSalvar = new MenuItem("Salvar");
        mArquivo.add(miSalvar);
        MenuBar mbMain = new MenuBar();
        mbMain.add(mArquivo);
        this.setMenuBar(mbMain);

        // Definição da interação na tela
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
        btnAdicionar.addActionListener( 
            al -> {

                System.out.println("Iniciando a ação do botão");

                // captura dado da tela
                String matricula = tfMatricula.getText().trim();
                String nome = tfNome.getText().trim();
                String strIdade = tfIdade.getText().trim();
                String strPeso = tfPeso.getText().trim();

                System.out.println("Dados capturados");

                // validação do dado capturado
                if((matricula.length()==0)||(nome.length()==0)||(strIdade.length()==0)||(strPeso.length()==0))
                    return; // posso lançar um dialog de alerta de campo vazio

                Integer idade=0;
                try {
                    idade = Integer.parseInt(strIdade);
                } catch (Exception e) {
                    return;
                }

                Double peso=0.0;
                try {
                    peso = Double.parseDouble(strPeso);
                } catch (Exception e) {
                    return;
                }
    
                System.out.println("Os dados são válidos");

                // criação do objeto
                Pessoa p;
                if(jcbProfessor.isSelected())
                    p = new Professor(matricula, nome, idade, peso, 1234.0);
                else
                    p = new Aluno(matricula, nome, idade, peso, "Ciência da Computação");
                cdp.adicionaPessoa(p);

                // atualização da tela
                updateTable(cdp, tableModel);
            }
        );

        miSalvar.addActionListener( al -> {

            try {
                PrintWriter pw = new PrintWriter("data.dat");
                pw.println("#tipo;matricula;nome;idade;peso");
                for(Pessoa p: cdp.listaDePessoas){
                    if(p instanceof Professor)
                        pw.println("p;"+p.getMatrícula()+";"+p.getNome()+";"+p.getIdade()+";"+p.getPeso()+";"+((Professor)p).getSalario());
                    else
                        pw.println("a;"+p.getMatrícula()+";"+p.getNome()+";"+p.getIdade()+";"+p.getPeso()+";"+((Aluno)p).getCurso());
                }
                    
                pw.close();
                
            } catch (Exception e) {
                System.out.println("Erro ao salvar os dados no arquivo");
            }

        });

        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-


        //CLASSE INTERNA DE SUPORTE A TABELA JTABLE

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);        

    }

    private void carregaDadosDoArquivo(CadastroDePessoa lcpd, DefaultTableModel ldtm){

        try {
            Path path1 = Paths.get("data.dat");
		    BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("utf8"));
			String line = null;
            // primeira linha apresenta a ordem dos campos disponiveis
			line=reader.readLine();

            while((line=reader.readLine())!=null){
                String data [] = line.split(";");
                String tipo = data[0].trim();
                String matricula = data[1].trim();
                String nome = data[2].trim();
                String strIdade = data[3].trim();
                String strPeso = data[4].trim();
                String strOutro = data[5].trim();

                Pessoa p;
                if(tipo.trim().toLowerCase()=="p")
                    p = new Professor(matricula, nome, Integer.parseInt(strIdade), Double.parseDouble(strPeso), Double.parseDouble(strOutro));
                else
                    p = new Aluno(matricula, nome, Integer.parseInt(strIdade), Double.parseDouble(strPeso), strOutro);

                //Pessoa p = new Pessoa(matricula, nome, Integer.parseInt(strIdade), Double.parseDouble(strPeso));
                lcpd.adicionaPessoa(p);
            }
            updateTable(lcpd, ldtm);

            
        } catch (Exception e) {
            System.out.println("Erro ao consumir o arquivo");
        }

    }

    private void updateTable(CadastroDePessoa lcdp, DefaultTableModel ldtm){
        ldtm.setNumRows(0);
        Object [] novaLinha;
        for(Pessoa aux: cdp.pessoal()){
            novaLinha = new Object[4];
            novaLinha[0]=aux.getMatrícula();
            novaLinha[1]=aux.getNome();
            novaLinha[2]=aux.getIdade();
            novaLinha[3]=aux.getPeso();
            ldtm.addRow(novaLinha);
        }        
        System.out.println("Dados foram adicionados na matriz da tabela");

    }

    public static void main(String[] args) {
        Tela tl = new Tela();
    }



    
}