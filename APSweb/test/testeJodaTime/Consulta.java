/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeJodaTime;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author Seixedo
 */
public class Consulta {
     int id,cpf_paciente,crm_medico;
    String dia,hora;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCpf_paciente() {
        return cpf_paciente;
    }

    public void setCpf_paciente(int cpf_paciente) {
        this.cpf_paciente = cpf_paciente;
    }

    public int getCrm_medico() {
        return crm_medico;
    }

    public void setCrm_medico(int crm_medico) {
        this.crm_medico = crm_medico;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
         DateTimeFormatter formatoentrada = DateTimeFormat.forPattern("yyyy/MM/dd");
         DateTime jodatime = formatoentrada.parseDateTime(dia); 
         DateTimeFormatter dtfOut = DateTimeFormat.forPattern("dd/MM/yyyy");

    //Criando stream para receber o output    
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    //Salvando o antigo system.out   
    PrintStream old = System.out;
    // Passando para o java a nova stream
    System.setOut(ps);
    // Printando a data para salvar na variavel
    System.out.print(dtfOut.print(jodatime));
    // Resetando o print
    System.out.flush();
    System.setOut(old);
   
        this.dia = baos.toString() ;
    
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        
         DateTimeFormatter formatoentrada = DateTimeFormat.forPattern("HH:mm:ss");
         DateTime jodatime = formatoentrada.parseDateTime(hora); 
         DateTimeFormatter dtfOut = DateTimeFormat.forPattern("HH:mm");

    //Criando stream para receber o output    
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    //Salvando o antigo system.out   
    PrintStream old = System.out;
    // Passando para o java a nova stream
    System.setOut(ps);
    // Printando a data para salvar na variavel
    System.out.print(dtfOut.print(jodatime));
    // Resetando o print
    System.out.flush();
    System.setOut(old);
   
        this.hora = baos.toString() ;
        //this.hora = hora;
    }
}
