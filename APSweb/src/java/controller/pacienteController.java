/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import dao.pacienteDAO;
import model.Paciente;

/**
 *
 * @author Seixedo
 */
public class pacienteController extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private static String INSERIR_OU_EDITAR = "/paciente.jsp";
    private static String LISTAR_PACIENTES = "/listarpaciente.jsp";
    private pacienteDAO dao;

    
    public pacienteController(){
        super();
        dao = new pacienteDAO();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
         String forward="";
        String action = request.getParameter("action");
 
        if (action.equalsIgnoreCase("edit")){
            forward = INSERIR_OU_EDITAR;
            int cpf = Integer.parseInt(request.getParameter("cpf"));
            Paciente paciente = dao.encontrarPacientepelocpf(cpf);
            request.setAttribute("paciente", paciente);
        } else if (action.equalsIgnoreCase("listarpaciente")){
            forward = LISTAR_PACIENTES;
            request.setAttribute("pacientes", dao.pegarTodosPacientes());
        } else {
            forward = INSERIR_OU_EDITAR;
        }
 
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Paciente paciente = new Paciente();
        paciente.setNome(request.getParameter("nome"));
        paciente.setCpf(Integer.parseInt(request.getParameter("cpf")));
        paciente.setNascimento((request.getParameter("nascimento")));
        paciente.setConvenio(request.getParameter("convenio"));
        dao.checarPaciente(paciente);
//        }
        RequestDispatcher view = request.getRequestDispatcher(LISTAR_PACIENTES);
        request.setAttribute("pacientes", dao.pegarTodosPacientes());
        view.forward(request, response);
    }
}
