/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itoaxaca.control;

import mx.edu.itoaxaca.modelo.Paciente;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

/**
 *
 * @author maldad
 */
@WebServlet(name = "AgregarPaciente", urlPatterns = {"/AgregarPaciente"})
public class AgregarPaciente extends HttpServlet {

    @PersistenceUnit
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PacienteJpaController control = new PacienteJpaController(utx, emf);

        SimpleDateFormat formatoF = new SimpleDateFormat("d/M/yyyy");
        String nombrePaciente = request.getParameter("nombrePaciente");
        String fechaIngresada = request.getParameter("fechaNacimiento");
        System.out.println("\n\n**\n\n**\n\nFecha Ingresada: "+fechaIngresada);
        String[] partesFech= fechaIngresada.split("-");
        int dia=Integer.parseInt(partesFech[0]);
        int mes=Integer.parseInt(partesFech[1]);
        int anio=Integer.parseInt(partesFech[2]);
        Date fechaParseada = new Date(anio-1900,mes-1,dia);
        System.out.println("Fecha Parseada inicial: "+fechaParseada);
        try{
            fechaParseada = formatoF.parse(fechaIngresada);
            System.out.println("esta entrando "+fechaIngresada+" --- "+fechaParseada);
        }catch(ParseException pe){
        }
        Character sexo = request.getParameter("sexo").toCharArray()[0];
        int estatura = Integer.parseInt(request.getParameter("estatura"));
        
        Paciente p = new Paciente();
        p.setNombre(nombrePaciente);
        System.out.println("Supuesta Fecha Parseada: "+fechaParseada+"\n\n**\n\n**\n\n");
        p.setFecha(fechaParseada);
        p.setSexo(sexo);
        p.setEstatura(estatura);
        
        try (PrintWriter out = response.getWriter()) {
            
            //emf = Persistence.createEntityManagerFactory("citasPacientes2PU");
            
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
            
            try{
                control.create(p);
                //response.sendRedirect("index.jsp");
                out.println("<h1> agregado correctamente </h1>");
            }catch(Exception e){
                out.println("<h1> error al agregar paciente" + request.getContextPath() + " </h1>");
            }finally{
                out.println("<a href=\"altaPaciente.jsp\">Agregar otro Paciente</a>");
                out.println("<a href=\"listaPacientes.jsp\">Lista de pacientes</a>");
                out.println("<a href=\"index.jsp\">INICO</a>");
                out.println("</body>");
                out.println("</html>");
                out.close();
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