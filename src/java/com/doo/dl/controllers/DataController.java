package com.doo.dl.controllers;
import com.doo.dl.models.DataDAO;
import com.doo.dl.models.DataPOJO;
import com.doo.dl.rules.Authenticate;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DataController extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                         
            DataDAO dao = new DataDAO();
            DataPOJO dto = new DataPOJO();
            HttpSession session = request.getSession();
            
            String action = request.getParameter("action");
            String materiatxt = request.getParameter("materiaEnv");
            String debertxt = request.getParameter("deberEnv");
            String fechatxt = request.getParameter("fechaEnv");
            
            dto.setMateria(materiatxt);
            dto.setDeber(debertxt);
            dto.setFecha(fechatxt);
            
            
            if(action.equals("insert")){
                dao.insertar(dto);
                response.sendRedirect("ProfileMaestro.jsp"); 
            }else{
                
            }
        
            if(action.equals("search")){
                dto.setMateria(materiatxt);
                dto.setDeber(debertxt);
                dto.setFecha(fechatxt);
                ArrayList<DataPOJO> deberes = dao.buscar(dto);
                session.setAttribute("Deberes", deberes);
                response.sendRedirect("ProfileMaestro.jsp");  
            }
            if(action.equals("search1")){
                dto.setMateria(materiatxt);
                dto.setDeber(debertxt);
                dto.setFecha(fechatxt);
                ArrayList<DataPOJO> deberes = dao.buscar(dto);
                session.setAttribute("Deberes", deberes);
                response.sendRedirect("ProfileAlumno.jsp");  
            }
        
            if(action.equals("calificaciones")){
                
                String matricula = request.getParameter("matricula");
                session.setAttribute("matricula", matricula);
                response.sendRedirect("Calificaciones.jsp");
            }
            
            if(action.equals("insertarCalf")){
                response.sendRedirect("ModificarCalificaciones.jsp");
            }
            
            if(action.equals("editar")){
                String username = request.getParameter("username");      
                String examen1Txt = request.getParameter("examen1");
                String examen2Txt = request.getParameter("examen2");
                String examen3Txt = request.getParameter("examen3");
                String tareasTxt = request.getParameter("tareas");
                String proyectoTxt = request.getParameter("proyecto");
                dao.modificarCalificaciones(username, examen1Txt, examen2Txt, examen3Txt, tareasTxt, proyectoTxt); 
                response.sendRedirect("ModificarCalificaciones.jsp");
                RequestDispatcher rd = request.getRequestDispatcher("ModificarCalificaciones.jsp");
                rd.include(request, response);
                out.print("<font color='green'><b>Cambios Realizados Con Exito.</b></font>");

            }
            if(action.equals("calisE")){
                String matricula = request.getParameter("matricula");
                session.setAttribute("matricula", matricula);
                response.sendRedirect("Calificaciones.jsp");
               
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
