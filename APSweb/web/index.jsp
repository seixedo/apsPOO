<%-- 
    Document   : index
    Created on : 17/03/2018, 20:18:04
    Author     : Seixedo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultorio</title>
    </head>
    <body>
        <jsp:forward page="/pacienteController?action=listarpaciente" />
    </body>
</html>
