package Model;

import dao.DisciplinaDao;

public class Disciplina {
    private int CdDisciplina = 0;
    private String NomeDisciplina = null;
    private int AulasSemana = 0;
    private int CargaHoraria = 0;

   
    public int getCdDisciplina() {
        return CdDisciplina;
    }

    public void setCdDisciplina(int CdDisciplina) {
        this.CdDisciplina = CdDisciplina;
    }

    public String getNomeDisciplina() {
        return NomeDisciplina;
    }

    public void setNomeDisciplina(String NomeDisciplina) {
        this.NomeDisciplina = NomeDisciplina;
    }

    public int getAulasSemana() {
        return AulasSemana;
    }

    public void setAulasSemana(int AulasSemana) {
        this.AulasSemana = AulasSemana;
    }

    public int getCargaHoraria() {
        return CargaHoraria;
    }

    public void setCargaHoraria(int CargaHoraria) {
        this.CargaHoraria = CargaHoraria;
    }
   
    

    public Disciplina(int CdDisciplina, String NomeDisciplina, int AulasSemana, int CargaHoraria) {
        setCdDisciplina(CdDisciplina);
        setNomeDisciplina(NomeDisciplina);
        setAulasSemana(AulasSemana);
        setCargaHoraria(CargaHoraria);
    }
    
    public Disciplina(String NomeDisciplina, int AulasSemana, int CargaHoraria) {
        setNomeDisciplina(NomeDisciplina);
        setAulasSemana(AulasSemana);
        setCargaHoraria(CargaHoraria);
    }
    
    public Disciplina(){
        
    }
    

    @Override
    public String toString() {
        return 
               "Nome da Disciplina....:" + getNomeDisciplina() + "\n"+
               "Aulas por semana......:" + getAulasSemana() + "\n" + 
               "Carga Horaria.........:" + getCargaHoraria();

    }
    
    private void gravar(){
        DisciplinaDao dao = new DisciplinaDao();
        int codigo = dao.create(this);
        if(codigo > 0) setCdDisciplina(codigo);
    }
    
    
}
