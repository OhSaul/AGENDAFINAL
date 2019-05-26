/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.doo.dl.rules;

import com.doo.dl.models.*;

/**
 *
 * @author Jose Julio Mancha Hernandez 17273757  007
 */
public class Authenticate {
    
       public static boolean isValid(String username, String password) {
            LoginDAO dao = new LoginDAO();
            User user1 = dao.obtenerUsername(username);
            String userDAO = user1.getUsername();
            String passwordDAO = user1.getPassword();
            
            if (username.equals(userDAO) && password.equals(passwordDAO)) {
                return true;
            } else {
                return false;
            }
        }
      
       public static boolean isEmpty(String nombre, String username, String matricula, String semestre, String carrera, String password){
            if(nombre.isEmpty() || username.isEmpty() || matricula.isEmpty() || semestre.isEmpty() || carrera.isEmpty() || password.isEmpty()){
                return true;
            }else{
                return false;
            }         
       }
       public static int convertir(String uno){
           
          int uno1 =  Integer.parseInt(uno);
           return uno1;
       }
}
