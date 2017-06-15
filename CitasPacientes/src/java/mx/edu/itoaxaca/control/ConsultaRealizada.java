/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itoaxaca.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import mx.edu.itoaxaca.modelo.Cita;
import mx.edu.itoaxaca.modelo.Consulta;

/**
 *
 * @author Zidai
 */
@WebServlet(name = "ConsultaRealizada", urlPatterns = {"/ConsultaRealizada"})
public class ConsultaRealizada extends HttpServlet {
    @PersistenceUnit
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;
    public String mesAString(int m){
        switch(m){
            case 0: return "Enero";
            case 1: return "Febrero";
            case 2: return "Marzo";
            case 3: return "Abril";
            case 4: return "Mayo";
            case 5: return "Junio";
            case 6: return "Julio";
            case 7: return "Agosto";
            case 8: return "Septiembre";
            case 9: return "Octubre";
            case 10: return "Noviembre";
            case 11: return "Diciembre";
        }
        return "";
    }
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
        
        emf = Persistence.createEntityManagerFactory("CitasPacientesPU");
        int idCita=Integer.parseInt(request.getParameter("IdCita"));
        String diac=request.getParameter("Diac");
        CitaJpaController controlCita = new CitaJpaController(utx, emf);
        ConsultaJpaController controlConsulta= new ConsultaJpaController(utx, emf);
        Cita c=controlCita.findCita(idCita);
        c.setStatus("Asistio");
        Consulta con=new Consulta();
        con.setCita(c);
        con.setDiagnostico(diac);
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConsultaRealizada</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("</html>");
            try{
                controlCita.edit(c);
                controlConsulta.create(con);
                //response.sendRedirect("index.jsp");
                out.println("<h1>Consulta Guardada con Exito</h1>");
                out.println("<hr><br><br>");
                out.println("<label>Nombre: "+c.getPaciente().getNombre()+"<label><br>");
                Calendar calFech=Calendar.getInstance();
                calFech.setTime(c.getFecha());
                int anio=calFech.get(Calendar.YEAR);
                int mes=calFech.get(Calendar.MONTH);
                int dia=calFech.get(Calendar.DAY_OF_MONTH);
                out.println("<label>Fecha Cita: "+dia+" de "+mesAString(mes)+" de "+anio+"<label><br>");
                out.println("<label>Diagnostico: "+diac+"<label><br>");
                
            }catch(Exception e){
                out.println("<h1> error al Agendar cita" + request.getContextPath() + " </h1>");
            }finally{
                out.println("<a href=\"index.jsp\">Index</a>");
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
