/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itoaxaca.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
import mx.edu.itoaxaca.modelo.Paciente;

/**
 *
 * @author Zidai
 */
@WebServlet(name = "ListaConsultas", urlPatterns = {"/ListaConsultas"})
public class ListaConsultas extends HttpServlet {
    @PersistenceUnit
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;
    
    public String mesAString(int m){
        switch(m){
            case 0: return "ENE";
            case 1: return "FEB";
            case 2: return "MAR";
            case 3: return "ABR";
            case 4: return "MAY";
            case 5: return "JUN";
            case 6: return "JUL";
            case 7: return "AGO";
            case 8: return "SEP";
            case 9: return "OCT";
            case 10: return "NOV";
            case 11: return "DIC";
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
        ConsultaJpaController ccon = new ConsultaJpaController(utx, emf);
        CitaJpaController cc=new CitaJpaController(utx, emf);
        PacienteJpaController cp = new PacienteJpaController(utx, emf);
        
        List<Consulta> listaCitas = ccon.findConsultaEntities();
         
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListaConsultas</title>");            
            out.println("</head>");
            out.println("<body>");//Nombre Fecha consulta Diagnositco
            out.println("<center>");
            out.println("<h1>Servlet ListaCitas</h1>");
            out.println("<table aling='left' width='60%' border=1>");
            out.println("<tr><td class='datos'>NOMBRE</td>"
                +"<td class='datos'>FECHA DE CONSULTA</td>"
                +"<td class='datos'>STATUS</td>"
                +"<td class='datos'>DIAGNOSTICO</td></tr>"
            );
            for(int i=0;i<listaCitas.size();i++){
                Cita cita= listaCitas.get(i).getCita();
                Date horaCita= cita.getHora();
                Calendar calH= Calendar.getInstance();
                calH.setTime(horaCita);
                Date fechCita= cita.getFecha();
                Calendar calF= Calendar.getInstance();
                calF.setTime(fechCita);
                
                Paciente p=cita.getPaciente();
                int idPaciente=p.getIdpaciente();
                String nombreP=p.getNombre();
                String status=cita.getStatus();
                String diac=listaCitas.get(i).getDiagnostico();
                out.println("<tr><td class='datos'>"+nombreP+"</td>"
                  +"<td class='datos'>"+calH.get(Calendar.HOUR_OF_DAY)+":00"
                  +" - "+calF.get(Calendar.DAY_OF_MONTH)+
                        "/"+mesAString(calF.get(Calendar.MONTH))+
                        "/"+calF.get(Calendar.YEAR)+"</td>"
                  +"<td class='datos'>"+status+"</td>"        
                  +"<td class='datos'>"+diac+"</td>"
                );
            }
            out.println("</table>");
            out.println("<hr>");
            out.println("<br><br>");
            out.println("<a href=\"index.jsp\">Index</a>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
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
