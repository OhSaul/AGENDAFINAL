package com.doo.dl.models;

import com.doo.dl.utils.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class DataDAO {
    private Connection conexion;
    Log log1 = Log.getInstance("C:\\Users\\Walo\\Desktop\\Errores.txt");
    
    //Metodo para abrir conexion con la base de datos.
     private void abrirConexion() throws SQLException {
        String dbURI = "jdbc:derby://localhost:1527/REGISTRO";
        String username = "FrijolesCharros";
        String password ="cisco";
        conexion = DriverManager.getConnection(dbURI, username, password);
        }
    
     //Metodo para cerrar conexion con la base de datos
    private void cerrarConexion() throws SQLException{
        conexion.close();
    }
    
    //Metodo insetar tareas por parte del maestro
     public void insertar(DataPOJO bean) {
           
        try{
           abrirConexion();
           log1.write("Se abrio conexion par buscar");
           String insert = "insert into DEBERES (MATERIA, DEBER, FECHA) values  ('"+bean.getMateria() + "', '" + bean.getDeber() +"', '" + bean.getFecha() +"')";        
           Statement stmt = conexion.createStatement();
           stmt.executeUpdate(insert);
           cerrarConexion();
           log1.write("Se cerro conexion par buscar y Se ha insertado su deber"); 
        }catch(Exception e){}
           log1.write("Truena");
    }
     
     //Metodo para buscar tareas de una materia especifica
      public ArrayList<DataPOJO> buscar(DataPOJO pojo1)  {
        try{
            ArrayList <DataPOJO> comentariosList = new ArrayList();
            abrirConexion();
            log1.write("Se abrio conexion par buscar");
            String select = "select MATERIA, DEBER, FECHA from DEBERES where MATERIA = '" + pojo1.getMateria() + "' and FECHA like '%" + pojo1.getFecha()+"%'";
            Statement stmt = conexion.createStatement();
             ResultSet result =stmt.executeQuery(select);
            
            while (result .next()){
               DataPOJO comentario = new DataPOJO();
               comentario.setMateria(result.getString("MATERIA"));
               comentario.setDeber(result.getString("DEBER"));
               comentario.setFecha(result.getString("FECHA"));
               comentariosList.add(comentario);
            } 
           cerrarConexion();
           log1.write("Se cerro conexion par buscar");
           log1.write("Se buscaron los resultados que coinciden con su busqueda");
           return comentariosList;
           
        }catch(Exception e){
        return null;
        }
    }
    //Metodo para insertar datos en la BD
    public void registrar(String nombre, String matricula, String semestre, String carrera, String username, String password){
        try{
           abrirConexion();
           log1.write("Se abrio conexion par buscar");
           //insert into REGISTROESTUDIANTES values ('tester1', 'test1', 'Soporte', 0, 1, 'testerM');
           String insert = "insert into REGISTROESTUDIANTES values  ('" + username + "', '" + password  +"', '" + carrera +"', " + semestre +", "+ matricula +", '"+ nombre +"', 0, 0, 0, 0, 0)";        
           Statement stmt = conexion.createStatement();
           stmt.executeUpdate(insert);
           cerrarConexion();
           log1.write("Se cerro conexion par buscar y Se ha insertado su deber"); 
        }catch(Exception e){}
           log1.write("Truena");
    }
    
    //Metodo para obtenerCalificaiones and promedios
    public User obtenerCalificaciones(String matricula){
       User user2 = new User();
       try{
            abrirConexion();
            Statement stmt = conexion.createStatement();
            String select = "select EXAMEN1, EXAMEN2, EXAMEN3, TAREAS, PROYECTOF from registroEstudiantes where MATRICULA = " + matricula + "";
            ResultSet mensajes = stmt.executeQuery(select);
            
            
            while(mensajes.next()){
               
               user2.setExamen1(mensajes.getInt("EXAMEN1"));
               user2.setExamen2(mensajes.getInt("EXAMEN2"));
               user2.setExamen3(mensajes.getInt("EXAMEN3"));
               user2.setTareas(mensajes.getInt("TAREAS"));
               user2.setProyectof(mensajes.getInt("PROYECTOF"));
               
            }
            cerrarConexion();
           
           
           return user2; 
       }catch(Exception e ){
           return null; 
       }
    }
    //Metodo para modificar calificaciones
    public void modificarCalificaciones(String username, String examen1, String examen2, String examen3, String tareas, String proyecto){
        try{
           abrirConexion();
           log1.write("Se abrio conexion par buscar");
             String insert = "update REGISTROESTUDIANTES set EXAMEN1 = "+ examen1 + ", EXAMEN2 = "+ examen2 +", EXAMEN3 = "+ examen3 +", TAREAS= "+ tareas +", PROYECTOF = " + proyecto +"  where USERNAME = '"+ username + "'" ;
           Statement stmt = conexion.createStatement();
           stmt.executeUpdate(insert);
           cerrarConexion();
           log1.write("Se cerro conexion par buscar y Se ha insertado su deber"); 
        }catch(Exception e){}
           log1.write("Truena");
    }   
    
}
