package Model;

public class Curso {
    private String CdCurso;
    private int CargaHoraria;
    private String NomeCurso;
    private String TipoCurso;
    private String CdInstituicao;

    public String getCdCurso() {
        return CdCurso;
    }

    public void setCdCurso(String cdCurso) {
        this.CdCurso = cdCurso;
    }

    public int getCargaHoraria() {
        return CargaHoraria;
    }

    public void setCargaHoraria(int CargaHoraria) {
        this.CargaHoraria = CargaHoraria;
    }

    public String getNomeCurso() {
        return NomeCurso;
    }

    public void setNomeCurso(String NomeCurso) {
        this.NomeCurso = NomeCurso;
    }

    public String getTipoCurso() {
        return TipoCurso;
    }

    public void setTipoCurso(String TipoCurso) {
        this.TipoCurso = TipoCurso;
    }

    public String getCdInstituicao() {
        return CdInstituicao;
    }

    public void setCdInstituicao(String CdInstituicao) {
        this.CdInstituicao = CdInstituicao;
    }

    public Curso(String CdCurso, int CargaHoraria, String NomeCurso, String TipoCurso, String CdInstituicao) {
        setCdCurso(CdCurso);
        setCargaHoraria(CargaHoraria);
        setNomeCurso(NomeCurso);
        setTipoCurso(TipoCurso);
        setCdInstituicao(CdInstituicao);
    }
    

    @Override
    public String toString() {
        return "Codigo do Curso......:" + getCdCurso() + "\n" +
               "Nome do Curso........:" + getNomeCurso() + "\n" +
               "Carga Horaria........:" + getCargaHoraria() + "\n" +
               "Tipo de Curso........:" + getTipoCurso() + "\n" + 
               "Codigo da Instituicao:" + getCdInstituicao();
    
    }
    
}
