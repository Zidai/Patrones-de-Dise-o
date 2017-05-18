/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itoaxaca.citasPacientes.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import mx.edu.itoaxaca.citasPacientes.modelo.Pacientes;

/**;
 *
 * @author maldad
 */
@WebServlet(name = "AgregarPaciente", urlPatterns = {"/AgregarPaciente"})
public class AgregarPaciente extends HttpServlet {
    //@PersistenceUnit
        private EntityManagerFactory emf;

    //@Resource
        private UserTransaction utx;


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
            SimpleDateFormat formatoF = new SimpleDateFormat("dd/MM/yy");
            
            String nombrePaciente = request.getParameter("nombrePaciente");
            String fechaIngresada = request.getParameter("fechaNacimiento");
            Date fechaParseada = new Date();
            try{
                fechaParseada = formatoF.parse(fechaIngresada);
            }catch(ParseException pe){
            
            }
            Character sexo = request.getParameter("sexo").toCharArray()[0];
            int estatura = Integer.parseInt(request.getParameter("estatura"));
            
            Pacientes p = new Pacientes();
            p.setNombre(nombrePaciente);
            p.setFecha(fechaParseada);
            p.setSexo(sexo);
            p.setEstatura(estatura);
            
            //emf = Persistence.createEntityManagerFactory("citasPacientesPU");
            PacientesJpaController control = new PacientesJpaController(utx, emf);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AgregarPaciente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Nuevo Paciente: </h1>");
            out.println("Nombre: " + p.getNombre() + "<br>");
            out.println("Fecha nacimiento: " + p.getFecha() + "<br>");
            out.println("Sexo: " + p.getSexo() + "<br>");
            out.println("Estatura: " + p.getEstatura() + " (cms) <br>");
            out.println("</body>");
            out.println("</html>");
            
            
            /*try{
                control.create(p);
                response.sendRedirect("index.jsp");
            }catch(Exception e){
                out.println("<h1> error al agregar paciente" + request.getContextPath() + " </h1>");
            }finally{
                out.close();
            }*/
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
