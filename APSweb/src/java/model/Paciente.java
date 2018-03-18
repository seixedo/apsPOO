/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
/**
 *
 * @author Seixedo
 */
public class Paciente {
    int cpf;
    String nome,convenio;
    String nascimento;

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        
       /* DateTimeFormatter formatoentrada = DateTimeFormat.forPattern("yyyy/MM/dd");
         DateTime jodatime = formatoentrada.parseDateTime(nascimento); 
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
    System.setOut(old);*/
   
        //this.nascimento = baos.toString() ;
        this.nascimento = nascimento;
    }
}
