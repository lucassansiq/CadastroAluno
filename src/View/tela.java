/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Aluno;
import Model.Curso;
import Model.Disciplina;
import Model.Professor;
import util.Mascara;

/**
 *
 * @author Ana Nery
 */
public class tela extends javax.swing.JFrame {

    /**
     * Creates new form tela
     */
    public tela() {
        initComponents();
        setMask();
        tfCdCurso.requestFocus();
    }
    
    
    private void gravaCurso(){
        String codigo = tfCdCurso.getText();
        String nome  = ltNomeCurso.getSelectedValue();
        String tipo = null;
        if (rbBacharel.isSelected()) tipo = "Bacharel";
        else if (rbGestao.isSelected()) tipo = "Gestão";
        else if (rbTec.isSelected()) tipo = "Tecnologo";
        int carga = Integer.parseInt(cbCargaHora.getSelectedItem().toString());
        String cd_insti = tfCdInsti.getText();
        System.out.println(new Curso(codigo,carga,nome,tipo,cd_insti));
        limpaCurso();
    }
    private void limpaCurso(){
        tfCdCurso.setText("");
        ltNomeCurso.clearSelection();
        rbTipoCurso.clearSelection();
        cbCargaHora.setSelectedIndex(0);
        tfCdInsti.setText("");
        tfCdCurso.requestFocus();
    }
    
    private void gravaDisciplina(){
        String nome = tfNomeDisc.getText();
        int carga = Integer.parseInt(tfCargaHoraria.getText().toString());
        int aulas = Integer.parseInt(cbAulaSemana.getSelectedItem().toString());
        System.out.println(new Disciplina(nome,aulas,carga));
        limpaDisciplina();
    }
    
    private void limpaDisciplina(){
        tfCodDisc.setText("");
        tfNomeDisc.setText("");
        tfCargaHoraria.setText("");
        cbAulaSemana.setSelectedIndex(0);
        tfCodDisc.requestFocus();
    }
    
    private void gravaAluno(){       
        String nome = tfAlunoNome.getText();
        String data = tfAlunoNasc.getText();
        String cdCurso = tfAlunoCodCurso.getText();
        String matricula = tfAlunoMatricula.getText();
        String NomeCurso = tfAlunoNomeCurso.getText();
        String cdDisciplina = ltAlunoCodDisc.getValue().toString();
        String faltas = tfAlunoFaltas.getText();
        double np1 = Double.parseDouble(tfAlunoNP1.getText());
        double np2 = Double.parseDouble(tfAlunoNP2.getText());
        double media = (np1 + np2)/2 ;
        tfAlunoMedia.setText(String.valueOf(media));
        System.out.println(new Aluno(nome,data,matricula,cdCurso,NomeCurso,cdDisciplina,faltas,np1,np2,media));
        limpaAluno();
    }
    private void limpaAluno(){
        tfAlunoNome.setText("");
        tfAlunoNasc.setText("");
        tfAlunoCodCurso.setText("");
        tfAlunoMatricula.setText("");
        tfAlunoNomeCurso.setText("");
        ltAlunoCodDisc.setValue(0);
        tfAlunoFaltas.setText("");
        tfAlunoNP1.setText("");
        tfAlunoNP2.setText("");
        tfAlunoMedia.setText("");
        tfAlunoNome.requestFocus();
        
    }
    
    private void gravaProfessor(){
        String nome = tfProNome.getText();
        String cdCurso = tfProCodCurso.getText();
        String nascimento = tfProNasc.getText();
        String espec = cbProEspec.getSelectedItem().toString();
        String titulo = CbProTitulo.getSelectedItem().toString();
        String rua = tfProRua.getText();
        String numero = tfProNumero.getText();
        String bairro = tfProBairro.getText();
        String cidade = tfProCidade.getText();
        String estado = tfProEstado.getText();
        String telefone = tfProFone.getText();
        String celular = tfProCel.getText();
        
        System.out.println(new Professor(nome,nascimento,cdCurso,espec,titulo,rua,numero,bairro,cidade,telefone,estado,celular));
        limpaProfessor();
    }
    
    private void limpaProfessor(){
        tfProNome.setText("");
        tfProCodCurso.setText("");
        tfProNasc.setText("");
        cbProEspec.setSelectedIndex(0);
        CbProTitulo.setSelectedIndex(0);
        tfProNumero.setText("");
        tfProRua.setText("");
        tfProBairro.setText("");
        tfProCidade.setText("");
        tfProEstado.setText("");
        tfProFone.setText("");
        tfProCel.setText("");
        tfProNome.requestFocus();
    }
    
    private void setMask(){
        tfAlunoNasc.setFormatterFactory(Mascara.maskData());
        tfProNasc.setFormatterFactory(Mascara.maskData());
        tfProFone.setFormatterFactory(Mascara.maskTelefone());
        tfProCel.setFormatterFactory(Mascara.maskCelular());
    }
    
    private void consultaDisciplina(){
        Disciplina disciplina = new Disciplina();
        disciplina = dao.DisciplinaDao.getInstance().findByCodigo(Integer.parseInt(tfCodDisc.getText()));
        
        tfNomeDisc.setText(disciplina.getNomeDisciplina());
        cbAulaSemana.setSelectedIndex(disciplina.getAulasSemana() - 1);
        tfCargaHoraria.setText(String.valueOf(disciplina.getCargaHoraria()));
    }
    
    private void excluirDisciplina(){ 
        dao.DisciplinaDao.getInstance().delete(Integer.parseInt(tfCodDisc.getText()));
        limpaDisciplina();
    }
    
    private void alterarDisciplina(){
        int codigo = Integer.parseInt(tfCodDisc.getText());
        String nome = tfNomeDisc.getText();
        int carga = Integer.parseInt(tfCargaHoraria.getText().toString());
        int aulas = Integer.parseInt(cbAulaSemana.getSelectedItem().toString());
        Disciplina disciplina = new Disciplina(codigo,nome,carga,aulas);
        dao.DisciplinaDao.getInstance().update(disciplina);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbTipoCurso = new javax.swing.ButtonGroup();
        pnTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnCadastro = new javax.swing.JTabbedPane();
        pnCurso = new javax.swing.JPanel();
        lbCdCurso = new javax.swing.JLabel();
        tfCdCurso = new javax.swing.JTextField();
        lbNomeCurso = new javax.swing.JLabel();
        spNomeCurso = new javax.swing.JScrollPane();
        ltNomeCurso = new javax.swing.JList<>();
        lbTipoCurso = new javax.swing.JLabel();
        rbBacharel = new javax.swing.JRadioButton();
        rbGestao = new javax.swing.JRadioButton();
        rbTec = new javax.swing.JRadioButton();
        lbCargaHora = new javax.swing.JLabel();
        lbCdInsti = new javax.swing.JLabel();
        tfCdInsti = new javax.swing.JTextField();
        cbCargaHora = new javax.swing.JComboBox<>();
        pnDisciplina = new javax.swing.JPanel();
        lbCodDisc = new javax.swing.JLabel();
        lbNomeDisc = new javax.swing.JLabel();
        lbCargaHoraria = new javax.swing.JLabel();
        lbAulaSemana = new javax.swing.JLabel();
        cbAulaSemana = new javax.swing.JComboBox<>();
        tfCodDisc = new javax.swing.JTextField();
        tfNomeDisc = new javax.swing.JTextField();
        tfCargaHoraria = new javax.swing.JTextField();
        pnAluno = new javax.swing.JPanel();
        lbAlunoMatricula = new javax.swing.JLabel();
        lbalunoNome = new javax.swing.JLabel();
        lbAlunoNasc = new javax.swing.JLabel();
        lbAlunoCodCurso = new javax.swing.JLabel();
        lbAlunoNomeCurso = new javax.swing.JLabel();
        lbAlunoCodDisc = new javax.swing.JLabel();
        lbAlunoNP1 = new javax.swing.JLabel();
        lbAlunoNP2 = new javax.swing.JLabel();
        lbAlunoMedia = new javax.swing.JLabel();
        lbAlunoFaltas = new javax.swing.JLabel();
        tfAlunoMatricula = new javax.swing.JTextField();
        tfAlunoNome = new javax.swing.JTextField();
        tfAlunoCodCurso = new javax.swing.JTextField();
        tfAlunoNomeCurso = new javax.swing.JTextField();
        tfAlunoNP1 = new javax.swing.JTextField();
        tfAlunoNP2 = new javax.swing.JTextField();
        tfAlunoMedia = new javax.swing.JTextField();
        tfAlunoFaltas = new javax.swing.JTextField();
        tfAlunoNasc = new javax.swing.JFormattedTextField();
        ltAlunoCodDisc = new javax.swing.JSpinner();
        pnProfessor = new javax.swing.JPanel();
        lbProNomeProf = new javax.swing.JLabel();
        lbProCodCurso = new javax.swing.JLabel();
        pnEndereco = new javax.swing.JPanel();
        lbProRua = new javax.swing.JLabel();
        lbProNumero = new javax.swing.JLabel();
        lbProBairro = new javax.swing.JLabel();
        lbProCidade = new javax.swing.JLabel();
        lbProEstado = new javax.swing.JLabel();
        lbProFone = new javax.swing.JLabel();
        lbProCel = new javax.swing.JLabel();
        tfProRua = new javax.swing.JTextField();
        tfProNumero = new javax.swing.JTextField();
        tfProBairro = new javax.swing.JTextField();
        tfProCidade = new javax.swing.JTextField();
        tfProEstado = new javax.swing.JTextField();
        tfProFone = new javax.swing.JFormattedTextField();
        tfProCel = new javax.swing.JFormattedTextField();
        lbProNasc = new javax.swing.JLabel();
        lbProEspec = new javax.swing.JLabel();
        cbProEspec = new javax.swing.JComboBox<>();
        lbProTitulo = new javax.swing.JLabel();
        CbProTitulo = new javax.swing.JComboBox<>();
        tfProNome = new javax.swing.JTextField();
        tfProCodCurso = new javax.swing.JTextField();
        tfProNasc = new javax.swing.JFormattedTextField();
        pnBotao = new javax.swing.JPanel();
        btGravar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        btMostrar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnTitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("CADASTRAMENTO");

        javax.swing.GroupLayout pnTituloLayout = new javax.swing.GroupLayout(pnTitulo);
        pnTitulo.setLayout(pnTituloLayout);
        pnTituloLayout.setHorizontalGroup(
            pnTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTituloLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnTituloLayout.setVerticalGroup(
            pnTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTituloLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        lbCdCurso.setText("Código do curso :");

        lbNomeCurso.setText("Nome do Curso: ");

        ltNomeCurso.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Administração de empresas", "Bio Medicina", "Ciências Biológicas", "Ciências da Compuação", "Direito", "Educação  Fisíca", "Farmacologia", "Rede de Compuadores", "Sistemas de Informações", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        spNomeCurso.setViewportView(ltNomeCurso);

        lbTipoCurso.setText("Tipo do Curso :");

        rbTipoCurso.add(rbBacharel);
        rbBacharel.setText("Bacharel");

        rbTipoCurso.add(rbGestao);
        rbGestao.setText("Gestão");

        rbTipoCurso.add(rbTec);
        rbTec.setText("Tecnológico");

        lbCargaHora.setText("Carga Horaria :");

        lbCdInsti.setText("Código da instituição: ");

        cbCargaHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));

        javax.swing.GroupLayout pnCursoLayout = new javax.swing.GroupLayout(pnCurso);
        pnCurso.setLayout(pnCursoLayout);
        pnCursoLayout.setHorizontalGroup(
            pnCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCursoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnCursoLayout.createSequentialGroup()
                        .addComponent(lbCdCurso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCdCurso))
                    .addGroup(pnCursoLayout.createSequentialGroup()
                        .addComponent(lbNomeCurso)
                        .addGap(18, 18, 18)
                        .addComponent(spNomeCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnCursoLayout.createSequentialGroup()
                        .addComponent(lbTipoCurso)
                        .addGap(18, 18, 18)
                        .addGroup(pnCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbGestao)
                            .addComponent(rbBacharel)
                            .addComponent(rbTec))))
                .addGap(60, 60, 60)
                .addGroup(pnCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCursoLayout.createSequentialGroup()
                        .addComponent(lbCdInsti)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCdInsti, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnCursoLayout.createSequentialGroup()
                        .addComponent(lbCargaHora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbCargaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnCursoLayout.setVerticalGroup(
            pnCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCursoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCdCurso)
                    .addComponent(tfCdCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCargaHora)
                    .addComponent(cbCargaHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(pnCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNomeCurso)
                    .addComponent(spNomeCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(pnCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTipoCurso)
                    .addComponent(rbBacharel)
                    .addComponent(lbCdInsti)
                    .addComponent(tfCdInsti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbGestao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbTec)
                .addGap(23, 23, 23))
        );

        pnCadastro.addTab("Curso", pnCurso);

        lbCodDisc.setText("Código Disciplina:");

        lbNomeDisc.setText("Nome Disciplina: ");

        lbCargaHoraria.setText("Carga Horária :");

        lbAulaSemana.setText("Aulas na Semana :");

        cbAulaSemana.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));
        cbAulaSemana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAulaSemanaActionPerformed(evt);
            }
        });

        tfCodDisc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodDiscActionPerformed(evt);
            }
        });

        tfCargaHoraria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCargaHorariaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnDisciplinaLayout = new javax.swing.GroupLayout(pnDisciplina);
        pnDisciplina.setLayout(pnDisciplinaLayout);
        pnDisciplinaLayout.setHorizontalGroup(
            pnDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDisciplinaLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(pnDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCodDisc)
                    .addComponent(lbNomeDisc)
                    .addComponent(lbCargaHoraria))
                .addGap(18, 18, 18)
                .addGroup(pnDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnDisciplinaLayout.createSequentialGroup()
                        .addGroup(pnDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfNomeDisc, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(tfCodDisc))
                        .addGap(61, 61, 61)
                        .addComponent(lbAulaSemana)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbAulaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        pnDisciplinaLayout.setVerticalGroup(
            pnDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDisciplinaLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(pnDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCodDisc)
                    .addComponent(tfCodDisc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(pnDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNomeDisc)
                    .addComponent(tfNomeDisc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAulaSemana)
                    .addComponent(cbAulaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(pnDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCargaHoraria)
                    .addComponent(tfCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80))
        );

        pnCadastro.addTab("Disciplina", pnDisciplina);

        lbAlunoMatricula.setText("Matricula :");

        lbalunoNome.setText("Nome:");

        lbAlunoNasc.setText("Data de Nascimento:");

        lbAlunoCodCurso.setText("Código do Curso :");

        lbAlunoNomeCurso.setText("Nome do Curso:");

        lbAlunoCodDisc.setText("Código da Disciplina:");

        lbAlunoNP1.setText("Nota NP1: ");

        lbAlunoNP2.setText("Nota NP2:");

        lbAlunoMedia.setText("Média :");

        lbAlunoFaltas.setText("Faltas:");

        tfAlunoMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAlunoMatriculaActionPerformed(evt);
            }
        });

        tfAlunoCodCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAlunoCodCursoActionPerformed(evt);
            }
        });

        ltAlunoCodDisc.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ltAlunoCodDiscStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnAlunoLayout = new javax.swing.GroupLayout(pnAluno);
        pnAluno.setLayout(pnAlunoLayout);
        pnAlunoLayout.setHorizontalGroup(
            pnAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAlunoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnAlunoLayout.createSequentialGroup()
                        .addComponent(lbAlunoNasc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfAlunoNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(lbAlunoMatricula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfAlunoMatricula))
                    .addGroup(pnAlunoLayout.createSequentialGroup()
                        .addComponent(lbalunoNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfAlunoNome))
                    .addGroup(pnAlunoLayout.createSequentialGroup()
                        .addGroup(pnAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnAlunoLayout.createSequentialGroup()
                                .addComponent(lbAlunoCodCurso)
                                .addGap(3, 3, 3)
                                .addComponent(tfAlunoCodCurso)
                                .addGap(59, 59, 59))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAlunoLayout.createSequentialGroup()
                                .addGroup(pnAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnAlunoLayout.createSequentialGroup()
                                        .addComponent(lbAlunoFaltas)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfAlunoFaltas, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)
                                        .addGroup(pnAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAlunoLayout.createSequentialGroup()
                                                .addComponent(lbAlunoNP2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                            .addGroup(pnAlunoLayout.createSequentialGroup()
                                                .addComponent(lbAlunoNP1)
                                                .addGap(7, 7, 7)))
                                        .addGroup(pnAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(tfAlunoNP1)
                                            .addComponent(tfAlunoNP2, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnAlunoLayout.createSequentialGroup()
                                        .addComponent(lbAlunoCodDisc)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ltAlunoCodDisc, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(42, 42, 42)))
                        .addGroup(pnAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnAlunoLayout.createSequentialGroup()
                                .addComponent(lbAlunoNomeCurso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfAlunoNomeCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnAlunoLayout.createSequentialGroup()
                                .addComponent(lbAlunoMedia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfAlunoMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 53, Short.MAX_VALUE))
        );
        pnAlunoLayout.setVerticalGroup(
            pnAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAlunoLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbalunoNome)
                    .addComponent(tfAlunoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(pnAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAlunoNasc)
                    .addComponent(lbAlunoMatricula)
                    .addComponent(tfAlunoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfAlunoNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAlunoCodCurso)
                    .addComponent(tfAlunoCodCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAlunoNomeCurso)
                    .addComponent(tfAlunoNomeCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAlunoCodDisc)
                    .addComponent(ltAlunoCodDisc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(pnAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAlunoFaltas)
                    .addComponent(tfAlunoFaltas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAlunoNP1)
                    .addComponent(tfAlunoNP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAlunoNP2)
                    .addComponent(tfAlunoNP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAlunoMedia)
                    .addComponent(tfAlunoMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pnCadastro.addTab("Aluno", pnAluno);

        lbProNomeProf.setText("Nome Professor:");

        lbProCodCurso.setText("Código do Curso:");

        pnEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        lbProRua.setText("Rua/Av :");

        lbProNumero.setText("Número:");

        lbProBairro.setText("Bairro:");

        lbProCidade.setText("Cidade:");

        lbProEstado.setText("Estado:");

        lbProFone.setText("Telefone:");

        lbProCel.setText("Celular:");

        javax.swing.GroupLayout pnEnderecoLayout = new javax.swing.GroupLayout(pnEndereco);
        pnEndereco.setLayout(pnEnderecoLayout);
        pnEnderecoLayout.setHorizontalGroup(
            pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnEnderecoLayout.createSequentialGroup()
                .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbProRua)
                    .addComponent(lbProBairro)
                    .addComponent(lbProFone)
                    .addComponent(lbProCel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfProBairro, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfProRua, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfProFone)
                    .addComponent(tfProCel))
                .addGap(18, 18, 18)
                .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbProNumero)
                    .addComponent(lbProCidade)
                    .addComponent(lbProEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfProCidade)
                    .addComponent(tfProEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(tfProNumero))
                .addGap(73, 73, 73))
        );
        pnEnderecoLayout.setVerticalGroup(
            pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbProRua)
                    .addComponent(lbProNumero)
                    .addComponent(tfProRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfProNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbProBairro)
                    .addComponent(lbProCidade)
                    .addComponent(tfProBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfProCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbProFone)
                    .addComponent(lbProEstado)
                    .addComponent(tfProEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfProFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(pnEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbProCel)
                    .addComponent(tfProCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        lbProNasc.setText("Data de Nascimento:");

        lbProEspec.setText("Espec do Professor:");

        cbProEspec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Digito", "Informatica", "Matemática", "Medicina" }));

        lbProTitulo.setText("Titúlo Professor:");

        CbProTitulo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bacharel", "Especialista", "Mestrado", "Doutorado" }));

        javax.swing.GroupLayout pnProfessorLayout = new javax.swing.GroupLayout(pnProfessor);
        pnProfessor.setLayout(pnProfessorLayout);
        pnProfessorLayout.setHorizontalGroup(
            pnProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProfessorLayout.createSequentialGroup()
                .addComponent(pnEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnProfessorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnProfessorLayout.createSequentialGroup()
                        .addComponent(lbProTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CbProTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))
                    .addGroup(pnProfessorLayout.createSequentialGroup()
                        .addGroup(pnProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbProNomeProf)
                            .addComponent(lbProCodCurso))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfProCodCurso, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(tfProNome))))
                .addGap(37, 37, 37)
                .addGroup(pnProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbProNasc)
                    .addComponent(lbProEspec))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbProEspec, 0, 109, Short.MAX_VALUE)
                    .addComponent(tfProNasc))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        pnProfessorLayout.setVerticalGroup(
            pnProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProfessorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbProNomeProf)
                    .addComponent(lbProNasc)
                    .addComponent(tfProNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfProNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(pnProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbProCodCurso)
                    .addComponent(lbProEspec)
                    .addComponent(cbProEspec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfProCodCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(pnProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbProTitulo)
                    .addComponent(CbProTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnCadastro.addTab("Professor", pnProfessor);

        pnBotao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btGravar.setText("Gravar");
        btGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarActionPerformed(evt);
            }
        });

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        btMostrar.setText("Mostrar");
        btMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMostrarActionPerformed(evt);
            }
        });

        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBotaoLayout = new javax.swing.GroupLayout(pnBotao);
        pnBotao.setLayout(pnBotaoLayout);
        pnBotaoLayout.setHorizontalGroup(
            pnBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btGravar)
                .addGap(23, 23, 23)
                .addComponent(btMostrar)
                .addGap(18, 18, 18)
                .addComponent(btExcluir)
                .addGap(18, 18, 18)
                .addComponent(btAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btLimpar)
                .addGap(39, 39, 39)
                .addComponent(btSair)
                .addGap(23, 23, 23))
        );
        pnBotaoLayout.setVerticalGroup(
            pnBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotaoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBotaoLayout.createSequentialGroup()
                        .addGroup(pnBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBotaoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btAlterar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnCadastro)
            .addComponent(pnBotao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnCadastro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfCodDiscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodDiscActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCodDiscActionPerformed

    private void tfCargaHorariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCargaHorariaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCargaHorariaActionPerformed

    private void tfAlunoCodCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAlunoCodCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAlunoCodCursoActionPerformed

    private void tfAlunoMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAlunoMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAlunoMatriculaActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        System.exit(0);

    }//GEN-LAST:event_btSairActionPerformed

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
        int i = pnCadastro.getSelectedIndex();
        
        if (i == 0) gravaCurso();
        else if(i == 1) gravaDisciplina();
        else if(i == 2) gravaAluno();
        else if (i == 3) gravaProfessor();
    }//GEN-LAST:event_btGravarActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        int i = pnCadastro.getSelectedIndex();
        
        if(i == 0) limpaCurso();
        else if(i == 1) limpaDisciplina();
        else if (i == 2) limpaAluno();
        else if(i == 3) limpaProfessor();
        
    }//GEN-LAST:event_btLimparActionPerformed

    private void ltAlunoCodDiscStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ltAlunoCodDiscStateChanged
        int v = (int) ltAlunoCodDisc.getValue();
        if (v < 0) ltAlunoCodDisc.setValue(0);
    }//GEN-LAST:event_ltAlunoCodDiscStateChanged

    private void cbAulaSemanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAulaSemanaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAulaSemanaActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        int i = pnCadastro.getSelectedIndex();
        
        if (i == 1) alterarDisciplina();
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMostrarActionPerformed
        int i = pnCadastro.getSelectedIndex();
        
        if (i == 1) consultaDisciplina();
    }//GEN-LAST:event_btMostrarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int i = pnCadastro.getSelectedIndex();
        
        if (i == 1) excluirDisciplina();
    }//GEN-LAST:event_btExcluirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbProTitulo;
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btMostrar;
    private javax.swing.JButton btSair;
    private javax.swing.JComboBox<String> cbAulaSemana;
    private javax.swing.JComboBox<String> cbCargaHora;
    private javax.swing.JComboBox<String> cbProEspec;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbAlunoCodCurso;
    private javax.swing.JLabel lbAlunoCodDisc;
    private javax.swing.JLabel lbAlunoFaltas;
    private javax.swing.JLabel lbAlunoMatricula;
    private javax.swing.JLabel lbAlunoMedia;
    private javax.swing.JLabel lbAlunoNP1;
    private javax.swing.JLabel lbAlunoNP2;
    private javax.swing.JLabel lbAlunoNasc;
    private javax.swing.JLabel lbAlunoNomeCurso;
    private javax.swing.JLabel lbAulaSemana;
    private javax.swing.JLabel lbCargaHora;
    private javax.swing.JLabel lbCargaHoraria;
    private javax.swing.JLabel lbCdCurso;
    private javax.swing.JLabel lbCdInsti;
    private javax.swing.JLabel lbCodDisc;
    private javax.swing.JLabel lbNomeCurso;
    private javax.swing.JLabel lbNomeDisc;
    private javax.swing.JLabel lbProBairro;
    private javax.swing.JLabel lbProCel;
    private javax.swing.JLabel lbProCidade;
    private javax.swing.JLabel lbProCodCurso;
    private javax.swing.JLabel lbProEspec;
    private javax.swing.JLabel lbProEstado;
    private javax.swing.JLabel lbProFone;
    private javax.swing.JLabel lbProNasc;
    private javax.swing.JLabel lbProNomeProf;
    private javax.swing.JLabel lbProNumero;
    private javax.swing.JLabel lbProRua;
    private javax.swing.JLabel lbProTitulo;
    private javax.swing.JLabel lbTipoCurso;
    private javax.swing.JLabel lbalunoNome;
    private javax.swing.JSpinner ltAlunoCodDisc;
    private javax.swing.JList<String> ltNomeCurso;
    private javax.swing.JPanel pnAluno;
    private javax.swing.JPanel pnBotao;
    private javax.swing.JTabbedPane pnCadastro;
    private javax.swing.JPanel pnCurso;
    private javax.swing.JPanel pnDisciplina;
    private javax.swing.JPanel pnEndereco;
    private javax.swing.JPanel pnProfessor;
    private javax.swing.JPanel pnTitulo;
    private javax.swing.JRadioButton rbBacharel;
    private javax.swing.JRadioButton rbGestao;
    private javax.swing.JRadioButton rbTec;
    private javax.swing.ButtonGroup rbTipoCurso;
    private javax.swing.JScrollPane spNomeCurso;
    private javax.swing.JTextField tfAlunoCodCurso;
    private javax.swing.JTextField tfAlunoFaltas;
    private javax.swing.JTextField tfAlunoMatricula;
    private javax.swing.JTextField tfAlunoMedia;
    private javax.swing.JTextField tfAlunoNP1;
    private javax.swing.JTextField tfAlunoNP2;
    private javax.swing.JFormattedTextField tfAlunoNasc;
    private javax.swing.JTextField tfAlunoNome;
    private javax.swing.JTextField tfAlunoNomeCurso;
    private javax.swing.JTextField tfCargaHoraria;
    private javax.swing.JTextField tfCdCurso;
    private javax.swing.JTextField tfCdInsti;
    private javax.swing.JTextField tfCodDisc;
    private javax.swing.JTextField tfNomeDisc;
    private javax.swing.JTextField tfProBairro;
    private javax.swing.JFormattedTextField tfProCel;
    private javax.swing.JTextField tfProCidade;
    private javax.swing.JTextField tfProCodCurso;
    private javax.swing.JTextField tfProEstado;
    private javax.swing.JFormattedTextField tfProFone;
    private javax.swing.JFormattedTextField tfProNasc;
    private javax.swing.JTextField tfProNome;
    private javax.swing.JTextField tfProNumero;
    private javax.swing.JTextField tfProRua;
    // End of variables declaration//GEN-END:variables
}
