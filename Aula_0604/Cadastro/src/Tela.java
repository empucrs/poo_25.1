import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Tela extends JFrame{

    private CadastroDePessoa cdp;    
    private JTable tblListaGeral, tblListaProfessor, tblListaAluno;
    private DefaultTableModel tableModelGeral, tableModelProfessor, tableModelAluno;
    private JRadioButton jrbProfessor, jrbAluno;

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

        jrbProfessor = new JRadioButton("Professor");
        jrbProfessor.setSelected(true);
        jrbAluno = new JRadioButton("Aluno");
        ButtonGroup bgTipo = new ButtonGroup();
        bgTipo.add(jrbProfessor);
        bgTipo.add(jrbAluno);
        JPanel l5 = new JPanel(new FlowLayout());
        l5.add(jrbProfessor);
        l5.add(jrbAluno);

        JCheckBox jcbAtivo = new JCheckBox("Cadastro ativo");
        jcbAtivo.setSelected(true);

        JButton btnAdicionar = new JButton("Adicionar");
        
        // Codificação da tabela Geral para garantir dinamicidade
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
        String [] columnNames = {"Tipo","Matrícula", "Nome", "Idade", "Peso"};
        tableModelGeral = new DefaultTableModel(columnNames, 0);

        tblListaGeral = new JTable(tableModelGeral);
        tblListaGeral.setPreferredScrollableViewportSize(new Dimension(300, 50));
        tblListaGeral.setFillsViewportHeight(true);
        JScrollPane spTableGeral = new JScrollPane(tblListaGeral);
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=        

        // Codificação da tabela Geral para garantir dinamicidade
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
        String [] columnNamesProfessor = {"Matrícula", "Nome", "Idade", "Peso", "Salario"};
        tableModelProfessor = new DefaultTableModel(columnNamesProfessor, 0);

        tblListaProfessor = new JTable(tableModelProfessor);
        tblListaProfessor.setPreferredScrollableViewportSize(new Dimension(300, 50));
        tblListaProfessor.setFillsViewportHeight(true);
        JScrollPane spTableProfessor = new JScrollPane(tblListaProfessor);
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=        

        // Codificação da tabela Geral para garantir dinamicidade
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
        String [] columnNamesAluno = {"Matrícula", "Nome", "Idade", "Peso", "Curso"};
        tableModelAluno = new DefaultTableModel(columnNamesAluno, 0);

        tblListaAluno = new JTable(tableModelAluno);
        tblListaAluno.setPreferredScrollableViewportSize(new Dimension(300, 50));
        tblListaAluno.setFillsViewportHeight(true);
        JScrollPane spTableAluno = new JScrollPane(tblListaAluno);
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=        

        // Cria tabs
        JTabbedPane tbPessoas = new JTabbedPane();
        // Tab Geral
        tbPessoas.addTab("Geral", spTableGeral);
        // Tab Professor
        tbPessoas.addTab("Professores", spTableProfessor);
        // Tab Aluno
        tbPessoas.addTab("Alunos", spTableAluno);
        
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.add(l1);
        this.add(l2);
        this.add(l3);
        this.add(l4);
        this.add(l5);
        this.add(jcbAtivo);
        this.add(btnAdicionar);
        //this.add(spTableGeral);        
        this.add(tbPessoas);        
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

        // Elaboração de um menu inicial
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
        JMenu mArquivo = new JMenu("Arquivo");
        JMenuItem miSalvar = new JMenuItem("Salvar");
        mArquivo.add(miSalvar);
        JMenuBar mbMain = new JMenuBar();
        mbMain.add(mArquivo);
        this.setJMenuBar(mbMain);

        // Inicialização de componentes
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
        carregaDadosDoArquivo(cdp);

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
                Boolean cadastroAtivo = jcbAtivo.isSelected();


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
                if(jrbProfessor.isSelected())
                    p = new Professor(matricula, nome, idade, peso, cadastroAtivo, 1234.0);
                else
                    p = new Aluno(matricula, nome, idade, peso, cadastroAtivo, "Ciência da Computação");
                cdp.adicionaPessoa(p);

                // atualização da tela
                updateTables(cdp);
            }
        );

        // Ação associada ao menu Salvar
        miSalvar.addActionListener( al -> {
            try {
                salvarEmArquivo();                
            } catch (Exception e) {
                System.out.println("Erro ao salvar os dados no arquivo");
            }

        });

        //Ação associada ao fechamento da janela
        this.addWindowListener(
            new windowOperations()
        );

        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-


        //CLASSE INTERNA DE SUPORTE A TABELA JTABLE

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.pack();
        this.setVisible(true);        

    }

    private void salvarEmArquivo() throws IOException{
        PrintWriter pw = new PrintWriter("data.dat");
        pw.println("#tipo;matricula;nome;idade;peso");
        for(Pessoa p: cdp.listaDePessoas){
            if(p instanceof Professor)
                pw.println("p;"+p.getMatrícula()+";"+p.getNome()+";"+p.getIdade()+";"+p.getPeso()+";"+p.getAtivo()+";"+((Professor)p).getSalario());
            else
                pw.println("a;"+p.getMatrícula()+";"+p.getNome()+";"+p.getIdade()+";"+p.getPeso()+";"+p.getAtivo()+";"+((Aluno)p).getCurso());
        }            
        pw.close();
    }

    private class windowOperations extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e) {
            super.windowClosing(e);
            int opcao = JOptionPane.showConfirmDialog(Tela.this,"A tela está sendo fechada","Fechar a janela?", JOptionPane.OK_CANCEL_OPTION);

            if(opcao==JOptionPane.YES_OPTION){
                try {
                    salvarEmArquivo();    
                } catch (Exception l) {
                    System.out.println("Erro durante o fechamento do software. \n  O arquivo não pode ser salvo");
                }            
                System.exit(0);
            }
        }
    }

    private void carregaDadosDoArquivo(CadastroDePessoa lcpd){

        BufferedReader reader;
        try {
            Path path1 = Paths.get("data.dat");
		    reader = Files.newBufferedReader(path1, Charset.forName("utf8"));
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
                String strAtivo = data[5].trim();
                String strOutro = data[6].trim();

                Pessoa p;
                if(tipo.trim().toLowerCase().equals("p"))
                    p = new Professor(matricula, nome, Integer.parseInt(strIdade), Double.parseDouble(strPeso), Boolean.parseBoolean(strAtivo), Double.parseDouble(strOutro));
                else
                    p = new Aluno(matricula, nome, Integer.parseInt(strIdade), Double.parseDouble(strPeso), Boolean.parseBoolean(strAtivo), strOutro);
                //Pessoa p = new Pessoa(matricula, nome, Integer.parseInt(strIdade), Double.parseDouble(strPeso));
                lcpd.adicionaPessoa(p);
            }            
            reader.close();

            updateTables(lcpd);

            
        } catch (Exception e) {
            System.out.println("Erro ao consumir o arquivo");
        }

    }

    private void updateTables(CadastroDePessoa lcdp){
        DefaultTableModel dtmG=tableModelGeral;
        DefaultTableModel dtmP=tableModelProfessor;
        DefaultTableModel dtmA=tableModelAluno;

        dtmG.setNumRows(0);
        dtmP.setNumRows(0);
        dtmA.setNumRows(0);

        for(Pessoa aux: cdp.pessoal()){
            Object [] novaLinha = new Object[5];
            Object [] nlProfessor = new Object[5];            
            Object [] nlAluno = new Object[5];

            nlProfessor[0] = nlAluno[0]=novaLinha[1]=aux.getMatrícula();
            nlProfessor[1] = nlAluno[1]=novaLinha[2]=aux.getNome();
            nlProfessor[2] = nlAluno[2]=novaLinha[3]=aux.getIdade();
            nlProfessor[3] = nlAluno[3]=novaLinha[4]=aux.getPeso();
            if(aux instanceof Professor){
                novaLinha[0]   = "Professor";
                nlProfessor[4] = ((Professor) aux).getSalario();    
                dtmP.addRow(nlProfessor);
                }
            else{
                novaLinha[0]   = "Aluno";
                nlAluno[4]     = ((Aluno) aux).getCurso();
                dtmA.addRow(nlAluno);
            }
            dtmG.addRow(novaLinha);
        }
        
        System.out.println("Dados foram adicionados na matriz da tabela");

    }

    public static void main(String[] args) {
        Tela tl = new Tela();
    }



    
}