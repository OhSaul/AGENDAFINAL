/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.doo.dl.models;

/**
 *
 * @author SEG-14
 */
public class Authenticate {
//   public static boolean isValid(String username, String password) {
//        //User user = new User();
//
//        //username.equals(userDataBase) realiza una comparación entre las cadenas username y userDataBase
//        //Si son iguales devuelve true. Si son diferentes devuelve false.
////        if (username.equals(Database.getUsername()) && password.equals(Database.getPassword())) {
//            return true;
//        } else {
//            return false;
//        }
       public static boolean isValid(String username, String password) {
        LoginDAO dao = new LoginDAO();
        User user1 = dao.obtenerUsername(username);
        String userDAO = user1.getUsername();
        String passwordDAO = user1.getPassword();
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);
        //String username2  = dao.obtenerUsername(user);
//        String password2 = dao.obtenerPassword(user);
        //username.equals(userDataBase) realiza una comparación entre las cadenas username y userDataBase
        //Si son iguales devuelve true. Si son diferentes devuelve false.
        if (username.equals(userDAO) && password.equals(passwordDAO)) {
            return true;
        } else {
            return false;
        }
    }
}
