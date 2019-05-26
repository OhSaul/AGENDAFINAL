/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.doo.dl.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.doo.dl.utils.Log;

/**
 *
 * @author Julio MANCHA HDZ 
 */
public class LoginDAO {
    private Connection conexion;
    Log log = Log.getInstance("C:\\Users\\moust\\Desktop\\lab9.txt");

    
    private void abrirConexion()throws SQLException {
        String url = "jdbc:derby://localhost:1527/REGISTRO";
        String username = "FrijolesCharros";
        String password = "cisco";
        
        conexion = DriverManager.getConnection(url, username, password);
    }
    private void cerrarConexion ()throws SQLException{
        conexion.close();
        
    }
    

    public User obtenerUsername(String user){
        User user1 = new User(); 
        try{
            abrirConexion();
            Statement stmt = conexion.createStatement();
            String select = "select USERNAME, PASSWORD from registroEstudiantes where USERNAME = '" + user + "'"; 
            ResultSet mensajes = stmt.executeQuery(select);
            
            
            while(mensajes.next()){         
                user1.setUsername(mensajes.getString("USERNAME")); 
                user1.setPassword(mensajes.getString("PASSWORD"));
            }
            cerrarConexion();
            return user1;
            }catch(Exception e){
            log.write("EL error es de tipo: " + e);
            return null;
        }
    
    }
    
    public User obtenerInformacion(String username){
       User user1 = new User();
        try{
            abrirConexion();
            Statement stmt = conexion.createStatement();
            String select = "select USERNAME, NOMBRE, SEMESTRE, MATRICULA, CARRERA, SEMESTRE from registroEstudiantes where USERNAME = '" + username + "'";
            ResultSet mensajes = stmt.executeQuery(select);
            
            
            while(mensajes.next()){
               
               user1.setSemestre(mensajes.getString("SEMESTRE"));
               user1.setName(mensajes.getString("NOMBRE"));
               user1.setMatricula(mensajes.getString("MATRICULA"));
               user1.setCarrera(mensajes.getString("CARRERA"));


            }
            cerrarConexion();
            return user1;
        }catch(Exception e){
            log.write("EL error es de tipo: " + e);
            return null;
        } 
    }   
}
