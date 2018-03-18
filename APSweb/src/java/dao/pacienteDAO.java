/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.*;
import java.util.*;
import model.Paciente;
import util.Database;
/**
 *
 * @author Seixedo
 */
public class pacienteDAO {
    private Connection connection;
    public pacienteDAO(){
        connection = Database.getConnection();
    }
    public void checarPaciente(Paciente paciente){
        try{
        PreparedStatement ps = connection.prepareStatement("select nome,cpf from paciente where cpf =?");
        ps.setInt(1, paciente.getCpf());
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            atualizarPaciente(paciente);
        }else{
            addPaciente(paciente);
        }
        }catch(Exception ex){
            System.out.println("Erro em checar()"+ex.getMessage());
        }
    }
    public void addPaciente(Paciente paciente){
        try{
            PreparedStatement ps = connection.prepareStatement("insert into paciente(cpf,nome,datanascimento,convenio) values(?,?,?,?)");
            ps.setInt(1, paciente.getCpf());
            ps.setString(2, paciente.getNome());
            ps.setString(3, paciente.getNascimento());
            ps.setString(4, paciente.getConvenio());
            ps.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void atualizarPaciente(Paciente paciente){
        try{
            PreparedStatement ps = connection.prepareStatement("update paciente set convenio=?"+ "where cpf=?");
            ps.setString(1, paciente.getConvenio());
            ps.setInt(2, paciente.getCpf());
            ps.executeUpdate();
        }catch(Exception ex){
            
        }
    }
        public List<Paciente> pegarTodosPacientes() {
        List<Paciente> pacients = new ArrayList<Paciente>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from paciente");
            while (rs.next()) {
                Paciente pacient = new Paciente();
                pacient.setNome(rs.getString("nome"));
                pacient.setCpf(rs.getInt("cpf"));
                pacient.setConvenio(rs.getString("convenio"));
                pacient.setNascimento(rs.getString("datanascimento"));
                pacients.add(pacient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return pacients;
    }
        public Paciente encontrarPacientepelocpf(int cpf) {
        Paciente pacient = new Paciente();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from paciente where cpf=?");
            preparedStatement.setInt(1, cpf);
            ResultSet rs = preparedStatement.executeQuery();
 
            if (rs.next()) {
                pacient.setNome(rs.getString("nome"));
                pacient.setCpf(rs.getInt("cpf"));
                pacient.setNascimento(rs.getString("datanascimento"));
                pacient.setConvenio(rs.getString("convenio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return pacient;
    }
        
    }

    