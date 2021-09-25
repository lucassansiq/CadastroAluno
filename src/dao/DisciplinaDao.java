/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Model.Disciplina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lucas Hype
 */
public class DisciplinaDao implements dao.Persistencia<Disciplina>{
    
    
    private static DisciplinaDao dao = null;
    
    public DisciplinaDao(){
        
    }
    
    public static DisciplinaDao getInstance(){
        if (dao == null) dao = new DisciplinaDao();
        
        return dao;
    }
    
    
    @Override
    public int create(Disciplina obj) {
        int id = 0;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "INSERT INTO Disciplina(nm_disciplina,carga_hora,aulas_semana) VALUES"
                + "(?,?,?)";
        try{
            pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, obj.getNomeDisciplina());
            pst.setInt(2, obj.getCargaHoraria());
            pst.setInt(3, obj.getAulasSemana());
            pst.execute();
            rs = pst.getGeneratedKeys();
            if (rs.next()){
                id = rs.getInt(1);
            }
        }catch(SQLException ex){
            id = 0;
        }finally{
            ConnectionFactory.closeConnection(con,pst,rs);
        }
        
        return id;
    }
    /*
    @Override
    public int create(Cliente c) {
        int id = 0;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "INSERT INTO Clientes(Nome, CPF, Fone,Celular,Email) VALUES"
                + "(?,?,?,?,?)";
        try{
            pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, c.getNome());
            pst.setString(2, c.getCPF());
            pst.setString(3, c.getTelefone());
            pst.setString(4, c.getCelular());
            pst.setString(5, c.getEmail());
            pst.execute();
            rs = pst.getGeneratedKeys();
            if (rs.next()){
                id = rs.getInt(1);
            }
        }catch(SQLException ex){
            id = 0;
        }finally{
            ConnectionFactory.closeConnection(con,pst,rs);
        }
        
        return id;
    }
    */
    
    

    @Override
    public Disciplina findByCodigo(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Disciplina c = null;
        String sql = "SELECT * FROM Disciplina where codigo = ?";
        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while(rs.next()){
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nm_disciplina");
                int carga = rs.getInt("carga_hora");
                int aulas = rs.getInt("aulas_semana");
            }
            }catch(SQLException ex){
            throw new RuntimeException("Erro no Select");
        }finally{
            ConnectionFactory.closeConnection(con,pst,rs);
        }         
        return c;
    }
    
   

    @Override
    public void delete(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "DELETE from Disciplina where codigo = ?";
        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();    
        }catch(SQLException ex){
            throw new RuntimeException("Erro no Delete");
        }finally{
            ConnectionFactory.closeConnection(con,pst,rs);
        }
    }

    @Override
    public void update(Disciplina c) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "UPDATE Disciplina set nm_disciplina = ?,carga_hora = ?,aulas_semana = ? where codigo = ?";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1, c.getNomeDisciplina());
            pst.setInt(2, c.getCargaHoraria());
            pst.setInt(3, c.getAulasSemana());
            pst.setInt(4, c.getCdDisciplina());
            pst.execute();
        }catch(SQLException ex){
            throw new RuntimeException("Erro no Delete");
        }finally{
            ConnectionFactory.closeConnection(con,pst,rs);
        }

    }
    
    }


