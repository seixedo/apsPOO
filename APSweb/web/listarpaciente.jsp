<%-- 
    Document   : listarpaciente
    Created on : 17/03/2018, 20:34:29
    Author     : Seixedo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All Users</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>Nome</th>
                <th>CPF</th>
                <th>Nascimento</th>
                <th>Convenio</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${pacientes}" var="paciente">
                <tr>
                    <td><c:out value="${paciente.nome}" /></td>
                    <td><c:out value="${paciente.cpf}" /></td>
                    <td><c:out value="${paciente.nascimento}" /></td>
                    <td><c:out value="${paciente.convenio}" /></td>
                    <td><a href="UserController?action=editar&userId=<c:out value="${paciente.cpf}"/>">Update</a></td>
                    <td><a href="UserController?action=delete&userId=<c:out value="${paciente.cpf}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="pacienteController?action=insert">Add paciente</a></p>
</body>
</html>