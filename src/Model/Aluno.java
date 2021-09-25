package Model;

public class Aluno {
    private String Nome;
    private String DtNascimento;
    private String Matricula;
    private String CdCurso;
    private String NomeCurso;
    private String CdDisciplina;
    private String Faltas;
    private double NotaNp1;
    private double NotaNp2;
    private double Media;

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getDtNascimento() {
        return DtNascimento;
    }

    public void setDtNascimento(String DtNascimento) {
        this.DtNascimento = DtNascimento;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }

    public String getCdCurso() {
        return CdCurso;
    }

    public void setCdCurso(String CdCurso) {
        this.CdCurso = CdCurso;
    }

    public String getNomeCurso() {
        return NomeCurso;
    }

    public void setNomeCurso(String NomeCurso) {
        this.NomeCurso = NomeCurso;
    }

    public String getCdDisciplina() {
        return CdDisciplina;
    }

    public void setCdDisciplina(String CdDisciplina) {
        this.CdDisciplina = CdDisciplina;
    }

    public String getFaltas() {
        return Faltas;
    }

    public void setFaltas(String Faltas) {
        this.Faltas = Faltas;
    }

    public double getNotaNp1() {
        return NotaNp1;
    }

    public void setNotaNp1(double NotaNp1) {
        this.NotaNp1 = NotaNp1;
    }

    public double getNotaNp2() {
        return NotaNp2;
    }

    public void setNotaNp2(double NotaNp2) {
        this.NotaNp2 = NotaNp2;
    }

    public double getMedia() {
        return Media;
    }

    public void setMedia(double Media) {
        this.Media = Media;
    }

    public Aluno(String Nome, String DtNascimento, String Matricula, String CdCurso, String NomeCurso, String CdDisciplina, String Faltas, double NotaNp1, double NotaNp2, double Media) {
        setNome(Nome);
        setDtNascimento(DtNascimento);
        setMatricula(Matricula);
        setCdCurso(CdCurso);
        setNomeCurso(NomeCurso);
        setCdDisciplina(CdDisciplina);
        setFaltas(Faltas);
        setNotaNp1(NotaNp1);
        setNotaNp2(NotaNp2);
        setMedia(Media);
    }

    @Override
    public String toString() {
        return "Nome do Aluno.......:" + getNome()+ "\n"+
               "Data de Nascimento..:"+ getDtNascimento() + "\n"+
               "Matricula...........:" + getMatricula() + "\n" + 
               "Codigo do Curso.....:" + getCdCurso() + "\n" +
               "Nome do Curso.......:" + getNomeCurso() + "\n" + 
               "Codigo da Disciplina:" + getCdDisciplina() + "\n" + 
               "Faltas..............:" + getFaltas() + "\n" + 
               "Nota Np1............:" + getNotaNp1() + "\n" +
               "Nota Np2............:" + getNotaNp2() + "\n" + 
               "Media...............:" + getMedia();
    }
    
    
    
    
}
