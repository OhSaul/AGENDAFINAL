/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.doo.dl.controllers;

import com.doo.dl.models.DataDAO;
import com.doo.dl.rules.Authenticate;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author moust
 */
public class RegisterController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            String nombreCompleto = request.getParameter("nombre");
            String matricula = request.getParameter("matricula");
            String semestre = request.getParameter("semestre");
            String carrera = request.getParameter("carrera");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String action = request.getParameter("Registrar");
            DataDAO dao = new DataDAO();
            
            boolean isEmpty = Authenticate.isEmpty(nombreCompleto, username, matricula, semestre, carrera, password);
                if(isEmpty == false){
                    if(action.equals("Registrar")){
                        dao.registrar(nombreCompleto, matricula, semestre, carrera, username, password);
                        response.sendRedirect("LoginAlumno.jsp");
                        RequestDispatcher rd = request.getRequestDispatcher("LoginAlumno.jsp");
                        rd.include(request, response);
                        out.print("<font color='grenn'><b>Te has registrado correctamente. Ahora puedes iniciar session. </b></font>");

                    }
                }else{
                    RequestDispatcher rd = request.getRequestDispatcher("Registrar.jsp");
                    rd.include(request, response);
                    out.print("<font color='red'><b>Llene todos los campos correctamente. </b></font>");
       
                }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
