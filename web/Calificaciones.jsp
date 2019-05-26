<%-- 
    Document   : Calificaciones
    Created on : 5/05/2017, 04:22:21 PM
    Author     : moust
--%>
<% 
        DataDAO dao = new DataDAO();
        //obtenerCalificaciones(String matricula)
        User user1 = dao.obtenerCalificaciones(session.getAttribute("matricula").toString() );
        int examen1 = user1.getExamen1();
        int examen2 = user1.getExamen2();
        int examen3 = user1.getExamen3();
        int tareas = user1.getTareas();
        int proyectoFinal = user1.getProyectof();
        float promedio = (examen1 + examen2 + examen3 + tareas + proyectoFinal) / 5 ; 
        int suma = examen1 + examen2 + examen3 + tareas + proyectoFinal;
%>

<%@page import="com.doo.dl.models.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kardex</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h1>Mi matricula es: <%= session.getAttribute("matricula") %></h1>
        <table border="2px">
            <tr>
                <th>Evaluacion</th> 
                <td>1er Examen</td>
                <td>2do Examen</td>
                <td>3er Examen</td>
                <td>Tareas</td>
                <td>Proyecto Final</td>
            </tr>
            <tr>
                <th>Calificaiones</th>
                <td><%= examen1 %></td>
                <td><%= examen2 %></td>
                <td><%= examen2 %></td>
                <td><%= tareas %></td>
                <td><%= proyectoFinal %></td>
            </tr>
            <tr>
                <th>Promedio</th>
                <td colspan="2"><%= promedio %></td>
                <th>Suma </th>
                <td colspan="3"><%= suma %> de 500 pts </td>
            </tr>
            
        </table>
    </body>
</html>
