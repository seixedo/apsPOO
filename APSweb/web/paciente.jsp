<%-- 
    Document   : paciente
    Created on : 17/03/2018, 20:21:32
    Author     : Seixedo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adicionar novo paciente</title>
    </head>
    <body>
        <form method="POST" action='pacienteController' name="frmAddPaciente">
            <% String action = request.getParameter("action");
                System.out.println(action);
            %>
            <% if (action.equalsIgnoreCase("editar")) {%>
            Nome : <input type="text" name="nome"
                               value="<c:out value="${paciente.nome}" />" readonly="readonly"/> (Não pode modificar)<br /> 
            <%} else {%>
            Nome : <input type="text" name="nome"
                               value="<c:out value="${paciente.nome}" />" /> <br />
            <%}%>
            <% if (action.equalsIgnoreCase("editar")) {%>
            CPF : <input type="text" name="cpf"
                               value="<c:out value="${paciente.cpf}" />" readonly="readonly"/> (Não pode modificar)<br /> 
            <%} else {%>
            CPF : <input type="text" name="cpf"
                               value="<c:out value="${paciente.cpf}" />" /> <br />
            <%}%>
            <% if (action.equalsIgnoreCase("editar")) {%>
            Convenio : <input type="text" name="convenio"
                               value="<c:out value="${paciente.convenio}" />" readonly="readonly"/> (Não pode modificar)<br /> 
            <%} else {%>
            Convenio : <input type="text" name="convenio"
                               value="<c:out value="${paciente.convenio}" />" /> <br />
            <%}%>
 
            <% if (action.equalsIgnoreCase("edit")) {%>
            Nascimento : <input
                type="text" name="nascimento"
                value="<fmt:formatDate pattern="dd/MM/yyyy" value="${paciente.nascimento}" />" readonly="readonly"/>(You Can't Change this)  <br />
            <%} else {%>
            Nascimento : <input
                type="text" name="nascimento"
                value="<fmt:formatDate pattern="dd/MM/yyyy" value="${paciente.nascimento}" />" />(ANO/MES/DIA)  <br /> 
            <%}%>
            <input  type="submit" value="Submit" />
        </form>
    </body>
</html>