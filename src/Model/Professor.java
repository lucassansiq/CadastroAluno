package Model;

public class Professor {
    private String NomeProfessor;
    private String DtNacimento;
    private String CdCurso;
    private String EspecProfessor;
    private String TituloProfessor;
    private String Rua;
    private String Numero;
    private String Bairro;
    private String Cidade;
    private String Telefone;
    private String Estado;
    private String Celular;

    public String getNomeProfessor() {
        return NomeProfessor;
    }

    public void setNomeProfessor(String NomeProfessor) {
        this.NomeProfessor = NomeProfessor;
    }

    public String getDtNacimento() {
        return DtNacimento;
    }

    public void setDtNacimento(String DtNacimento) {
        this.DtNacimento = DtNacimento;
    }

    public String getCdCurso() {
        return CdCurso;
    }

    public void setCdCurso(String CdCurso) {
        this.CdCurso = CdCurso;
    }

    public String getEspecProfessor() {
        return EspecProfessor;
    }

    public void setEspecProfessor(String EspecProfessor) {
        this.EspecProfessor = EspecProfessor;
    }

    public String getTituloProfessor() {
        return TituloProfessor;
    }

    public void setTituloProfessor(String TituloProfessor) {
        this.TituloProfessor = TituloProfessor;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public Professor(String NomeProfessor, String DtNacimento, String CdCurso, String EspecProfessor, String TituloProfessor, String Rua, String Numero, String Bairro, String Cidade, String Telefone, String Estado, String Celular) {
        setNomeProfessor(NomeProfessor);
        setDtNacimento(DtNacimento);
        setCdCurso(CdCurso);
        setEspecProfessor(EspecProfessor);
        setTituloProfessor(TituloProfessor);
        setRua(Rua);
        setNumero(Numero);
        setBairro(Bairro);
        setCidade(Cidade);
        setTelefone(Telefone);
        setEstado(Estado);
        setCelular(Celular);
    }

    @Override
    public String toString() {
        return "Nome do Professor.:" + getNomeProfessor() + "\n"+
               "Data de Nascimento:" + getDtNacimento() + "\n" + 
               "Codigo do Curso...:" + getCdCurso() + "\n" +
               "Especificacao.....:" + getEspecProfessor() + "\n" +
               "Titulo............:" + getTituloProfessor() + "\n" + 
               "Rua...............:" + getRua() + " Numero:" + getNumero() + "\n" +
               "Bairro............:" + getBairro() + " Cidade:" + getCidade() + "\n" + 
               "Estado............:" + getEstado() + "\n" +
               "Telefone..........:" + getTelefone() + "\n" + 
               "Celular...........:" + getCelular();
    }
    
    
    
    
    
    
    
    
    
}
