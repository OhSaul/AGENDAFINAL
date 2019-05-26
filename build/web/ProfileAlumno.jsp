<%-- 
    Document   : ProfileAlumno
    Created on : 3/05/2017, 01:29:05 AM
    Author     : moust
--%>
<%

        LoginDAO dao = new LoginDAO();
        User user1 = dao.obtenerInformacion(session.getAttribute("username").toString());
        String nombre = user1.getName();
        String carrera = user1.getCarrera();
        String semestre = user1.getSemestre();
        String matricula = user1.getMatricula();
%>
<%-- if (session != null){
           List deberesA = (List) session.getAttribute("DeberesA");
            if(deberesA != null){
                out.println("Resultados");
          --%>

<%@page import="com.doo.dl.models.*"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alumno</title>
    </head>
    <body>
        <form action="DataController" method="POST">
        <%out.print("<font color='grenn'><b>Session Iniciada Correctamente.</b></font>"); %> 
            <h3>Bienvenido Alumno</h3>
            <h4>Username: @<%= session.getAttribute("username")%></h4>
            <h4>Nombre: <%= nombre%></h4>
            <h4>Carrera: <%= carrera%></h4>
            <h4>Semestre: <%= semestre %></h4>
            <h4>Matricula: <%= matricula %></h4>
            <input type="hidden" name="matricula" value="<%= matricula%>">
            <input type="submit" name="action" value="calificaciones">
            <a href="LoginAlumno.jsp" >Cerrar Session</a>
        </form>
        <input type="button" value="Buscar" onclick="mostrarBuscar()">
        
        <div id="buscarDeber" style='display:none;'>
            <form action="DataController" method="POST">
                <label>Materia: <input type="text" name="materiaEnv"/></label>
                <div>Si gusta puede buscar por fecha.</div>
                <label>Fecha: <input type="text" name="fechaEnv"/></label>
                <input type="submit" name="enviarCO">
                <input type="hidden" name="action" value="search1">
             </form>
         </div>
        <script type="text/javascript">
           function mostrarBuscar(){
              document.getElementById('buscarDeber').style.display = 'block';
           }
           
        </script>
         <% if (session != null){
           List deberes = (List) session.getAttribute("Deberes");
            if(deberes != null){
                System.out.println("Resultados");
          %>
        <table border="1">
            <tr>
                <td>Materia</td>
                <td>Deberes</td>
                <td>Fecha</td>
                
            </tr>
        <% for(Object o : deberes){
            DataPOJO comentario = (DataPOJO) o;
        %>    
            <tr>
                <td><%=comentario.getMateria()%></td>
                <td><%=comentario.getDeber()%></td>
                <td><%=comentario.getFecha()%></td>
            </tr>
            <% }%>
            
            
        </table>
        <%  }
        }
        %>
      
       </body>
</html>
