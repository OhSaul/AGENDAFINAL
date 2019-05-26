<%-- 
    Document   : ModificarCalificaciones
    Created on : 5/05/2017, 10:36:25 PM
    Author     : moust
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ModificarCalificaciones</title>
    </head>
    <body>
        <form action="DataController" method="POST">
            <h3>
                Nota: No deje ninguna calificacion en blanco, si la calificacion ya se introdujo 
                anteriormente favor de introducir la de nuevo. Si solamente desea introducir una 
                calificacion nueva deje los otros campos en 0. 
            </h3> 
                
            <label>Usario del estudiante: <input type="text" name="username" value=""></label>
            </br>
            <label>Calificacion 1er Examen: <input type="text" name="examen1" value="0"></label>
            </br>
            <label>Calificacion 2do Examen: <input type="text" name="examen2" value="0"></label>
            </br>
            <label>Calificacion 3er Examen: <input typr="text" name="examen3" value="0"></label>
            </br>
            <label>Modificar tareas: <input type="text" name="tareas" value="0"></label>
            </br>
            <label>Modificar proyecto final: <input type="text" name="proyecto" value="0"></label>
            </br>
            <input type="submit" value="GuardarCambios" name="">
            <input type="hidden" value="editar" name="action" >
        </form>
         <input type="button" value="Buscar" onclick="mostrarBuscar()">
        <div id="buscarDeber" style='display:none;'>
        <form action ="DataController" method="POST">
            <h3>Introduzca la matricula del estudiante que desea buscar</h3> 
             
            <label>Matricula del estudiante: <input type="text" name="matricula" value=""></label>
            
            <input type="submit" value="buscar" name="">

            <input type="hidden" value="calisE" name="action">
        </form>
            <script type="text/javascript">
           function mostrarBuscar(){
              document.getElementById('buscarDeber').style.display = 'block';
           }
           </script>
    </body>
</html>
