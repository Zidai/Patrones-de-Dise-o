/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itoaxaca.control;

import java.io.IOException;
import java.io.PrintWriter;
import static java.rmi.Naming.list;
import static java.util.Collections.list;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.edu.itoaxaca.modelo.Paciente;
import java.util.Collections.*;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;

/**
 *
 * @author Zidai
 */
@WebServlet(name = "AgregarCita", urlPatterns = {"/AgregarCita"})
public class AgregarCita extends HttpServlet {
    @PersistenceUnit
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;
    static int idPaciente;
    
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
        
        PacienteJpaController cp = new PacienteJpaController(utx, emf);
        List <Paciente> pacientes = cp.findPacienteEntities();
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AgregarCita</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AgregarCita at " + request.getContextPath() + "</h1>");
            
            out.println("<form id='selpa' action='NuevaCita'>");
            out.println("<select name='idpac'>");
            for(int i=0;i<pacientes.size();i++){
                out.println("<option value="+pacientes.get(i).getIdpaciente()+">"+pacientes.get(i).getNombre()+"</option>");
            }
            out.println("</select><input type='submit' onclick='buscar' value='ENVIAR'></input>");
            out.println("</form>");
            
            out.println("</body>");
            out.println("</html>");
            /*System.out.println("  ");
            System.out.println("#########################################");
            System.out.println("##################DATOS##################");
            System.out.println("#########################################");
            for(int i=0;i<pacientes.size();i++){
                System.out.println("  ");
                System.out.println("ID: "+pacientes.get(i).getIdpaciente()
                    +" Nombre: "+pacientes.get(i).getNombre()
                    +" FECHA DE NACIMIENTO: "+pacientes.get(i).getFecha());
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
