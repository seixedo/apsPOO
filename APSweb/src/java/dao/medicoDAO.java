/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Medico;
import util.Database;

/**
 *
 * @author Seixedo
 */
public class medicoDAO {
     private Connection connection;
    public medicoDAO(){
        connection = Database.getConnection();
    }
    public void checarPaciente(Medico medico){
        try{
        PreparedStatement ps = connection.prepareStatement("select nome,cpf from medico where crm =?");
        ps.setInt(1, medico.getCrm());
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            atualizarMedico(medico);
        }else{
            addMedico(medico);
        }
        }catch(Exception ex){
            System.out.println("Erro em checar()"+ex.getMessage());
        }
    }
    public void addMedico(Medico medico){
        try{
            PreparedStatement ps = connection.prepareStatement("insert into medico(crm,nome,especialidade) values(?,?,?)");
            ps.setInt(1, medico.getCrm());
            ps.setString(2, medico.getNome());
            ps.setString(3, medico.getEspecialidade());
            ps.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void atualizarMedico(Medico medico){
        try{
            PreparedStatement ps = connection.prepareStatement("update medico set especialidade=?"+ "where crm=?");
            ps.setString(1, medico.getEspecialidade());
            ps.setInt(2, medico.getCrm());
            ps.executeUpdate();
        }catch(Exception ex){
            
        }
    }
        public List<Medico> pegarTodosMedicos() {
        List<Medico> medics = new ArrayList<Medico>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from medico");
            while (rs.next()) {
                Medico medic = new Medico();
                medic.setNome(rs.getString("nome"));
                medic.setCrm(rs.getInt("crm"));
                medic.setEspecialidade(rs.getString("especialidade"));
                medics.add(medic);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return medics;
    }
        public Medico encontrarMedicopeloCrm(int crm) {
        Medico medic = new Medico();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from medico where crm=?");
            preparedStatement.setInt(1, crm);
            ResultSet rs = preparedStatement.executeQuery();
 
            if (rs.next()) {
                medic.setNome(rs.getString("nome"));
                medic.setCrm(rs.getInt("crm"));
                medic.setEspecialidade(rs.getString("especialidade"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return medic;
    }
}
