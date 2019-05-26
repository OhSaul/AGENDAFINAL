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
public class User {

    private String username;
    private String password;
    private String name;
    private String semestre;
    private String matricula;
    private String carrera;
    private int examen1;
    private int examen2;
    private int examen3;
    private int tareas;
    private int proyectof;
    


    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the semestre
     */
    public String getSemestre() {
        return semestre;
    }
    
    public void setSemestre(String semestre){
        this.semestre = semestre;
      
    }

    /**
     * @return the materia
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    /**
     * @return the carrera
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * @param carrera the carrera to set
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
   
        /**
     * @return the examen1
     */
    public int getExamen1() {
        return examen1;
    }

    /**
     * @param examen1 the examen1 to set
     */
    public void setExamen1(int examen1) {
        this.examen1 = examen1;
    }

    /**
     * @return the examen2
     */
    public int getExamen2() {
        return examen2;
    }

    /**
     * @param examen2 the examen2 to set
     */
    public void setExamen2(int examen2) {
        this.examen2 = examen2;
    }

    /**
     * @return the examen3
     */
    public int getExamen3() {
        return examen3;
    }

    /**
     * @param examen3 the examen3 to set
     */
    public void setExamen3(int examen3) {
        this.examen3 = examen3;
    }

    /**
     * @return the tareas
     */
    public int getTareas() {
        return tareas;
    }

    /**
     * @param tareas the tareas to set
     */
    public void setTareas(int tareas) {
        this.tareas = tareas;
    }

    /**
     * @return the proyectof
     */
    public int getProyectof() {
        return proyectof;
    }

    /**
     * @param proyectof the proyectof to set
     */
    public void setProyectof(int proyectof) {
        this.proyectof = proyectof;
    }
}
