/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itoaxaca.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.Calendar;
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
import mx.edu.itoaxaca.modelo.Cita;
import mx.edu.itoaxaca.modelo.Paciente;

/**
 *
 * @author Zidai
 */
@WebServlet(name = "CitaAgendada", urlPatterns = {"/CitaAgendada"})
public class CitaAgendada extends HttpServlet {
    @PersistenceUnit
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;
    static int idPaciente;
    static int diaCita;
    static int horaCita;
    
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
        
        PacienteJpaController cp = new PacienteJpaController(utx, emf);
        CitaJpaController cc = new CitaJpaController(utx, emf);
        idPaciente=Integer.parseInt(request.getParameter("IDpaciente"));
        diaCita=Integer.parseInt(request.getParameter("DIAcita"));
        horaCita=Integer.parseInt(request.getParameter("HORAcita"));
        Paciente p =cp.findPaciente(idPaciente);
        Cita c = new Cita();
        c.setPaciente(p);
         //Date empieza los meses desde 0 :/ y regresa los años -1900 atrás (¬_¬)
        Date fechaCita = new Date(NuevaCita.anio - 1900, NuevaCita.mes - 1,diaCita);
        c.setFecha(fechaCita);    
        Date horaCit = new Time(horaCita, 0, 0);
        c.setHora(horaCit);
        c.setStatus("Pendiente");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CitaAgendada</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1><center>Cita Agendada</h1></center>");
            out.println("<h3>Paciente: " + p.getNombre() + "</h3>");
            Date fechCit = c.getFecha();
            Calendar cal= Calendar.getInstance();
            cal.setTime(fechCit);
            int diaCit=cal.get(Calendar.DAY_OF_MONTH);
            int mesCit=cal.get(Calendar.MONTH);
            String mesCitS=mesAString(mesCit);
            int anioCit=cal.get(Calendar.YEAR);
            out.println("<h3>Fecha: " + diaCit+ " de "+mesCitS+" del "+ anioCit + "</h3>");
            out.println("<h3>Hora: " + c.getHora() + "</h3>");

            try{
                cc.create(c);
                //response.sendRedirect("index.jsp");
                out.println("<h1> Cita Agendada Correctamente </h1>");
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
