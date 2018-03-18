/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeJodaTime;
import testeJodaTime.testeJoda;
import org.joda.time.*;
import testeJodaTime.Consulta;
/**
 *
 * @author Seixedo
 */
public class main {
    public static void main(String[] args) {
       testeJoda paciente = new testeJoda();
       
       paciente.setNome("Abraao");
       paciente.setConvenio("Memorial");
       paciente.setCpf(123456789);
       paciente.setNascimento("1997/05/21");
        System.out.println(paciente.getNome());
        System.out.println(paciente.getConvenio());
        System.out.println(paciente.getCpf());
        System.out.println(paciente.getNascimento());
        
        Consulta consulta = new Consulta();
        
        consulta.setHora("12:00:00");
        System.out.println(consulta.getHora());
        consulta.setDia("2016/06/07");
        System.out.println(consulta.getDia());
    }
}
