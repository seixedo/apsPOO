/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.*;
import java.util.*;
import util.Database;
import model.Consulta;
/**
 *
 * @author Seixedo
 */
public class consultaDAO {
    private Connection connection;
    public consultaDAO(){
        connection = Database.getConnection();
}
    //PreparedStatement ps = connection.prepareStatement("select cpf_paciente,crm_medico,dia,hora from consulta where cpf_paciente =?");
    public List<Consulta> checarconsultas(){
        List<Consulta> consults = new ArrayList<Consulta>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select cpf_paciente,crm_medico,dia,hora from consulta");
            while (rs.next()) {
                Consulta consult = new Consulta();
                consult.setId(rs.getInt("id"));
                consult.setCpf_paciente(rs.getInt("cpf_paciente"));
                consult.setCrm_medico(rs.getInt("crm_medico "));
                consult.setDia(rs.getString("dia"));
                consult.setHora(rs.getString("hora"));
                consults.add(consult);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return consults;
    }
    
     public void addconsulta(Consulta consulta){
        try{
            PreparedStatement ps = connection.prepareStatement("insert into consulta(cpf_paciente,crm_medico,dia,hora) values(?,?,?,?)");
            ps.setInt(1, consulta.getCpf_paciente());
            ps.setInt(2, consulta.getCrm_medico());
            ps.setString(3, consulta.getDia());
            ps.setString(4, consulta.getHora());
            ps.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
