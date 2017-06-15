/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itoaxaca.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import static mx.edu.itoaxaca.control.NuevaCita.mes;
import mx.edu.itoaxaca.modelo.Cita;
import mx.edu.itoaxaca.modelo.Paciente;

/**
 *
 * @author Zidai
 */
@WebServlet(name = "ElegirNuevoDia", urlPatterns = {"/ElegirNuevoDia"})
public class ElegirNuevoDia extends HttpServlet {
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
    static int anio, mes;
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
        
        CitaJpaController controlCita = new CitaJpaController(utx, emf);
        PacienteJpaController controlPaciente = new PacienteJpaController(utx, emf);
        
        int idPaciente = Integer.parseInt(request.getParameter("IdPaciente")); //viene del select
        Paciente p = controlPaciente.findPaciente(idPaciente);
        int idCita=Integer.parseInt(request.getParameter("IdCita"));
        //creando lista de citas del paciente actual
        List<Cita> listaTodasCitas = controlCita.findCitaEntities();
        ArrayList<Integer> listaCitas = new ArrayList<Integer>();
        
        for(int i=0;i<listaTodasCitas.size();i++){
            Date a = listaTodasCitas.get(i).getFecha();
            Calendar b= Calendar.getInstance();
            b.setTime(a);
            int d=b.get(Calendar.DAY_OF_MONTH);
            listaCitas.add(d);
        }
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ElegirNuevoDia</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h1>Elegir nuevo Dia</h1>");
            out.println("<label>Paciente: "+p.getNombre()+"</label>");
            out.println("<br>");
            out.println("<label>Sexo: "+p.getSexo()+"</label>");
            out.println("<br>");
            Date fechNac = p.getFecha();
            Calendar cal= Calendar.getInstance();
            cal.setTime(fechNac);
            int diaNac=cal.get(Calendar.DAY_OF_MONTH);
            int mesNac=cal.get(Calendar.MONTH);
            int anioNac=cal.get(Calendar.YEAR);
            out.println("<label>Fecha de Nacimiento: "+diaNac+" de "+mesAString(mesNac)+" de "+anioNac+"</label>");
            out.println("<br>");
            LocalDate dia;
            dia= LocalDate.now();
            int numeroMes = dia.getMonthValue();
            mes = numeroMes;
            anio = dia.getYear();
            int hoy= dia.getDayOfMonth();
            int controlSem=1;
            out.println("<table>");
            out.println("<tr>");
            for(int i=1;i<=dia.lengthOfMonth();i++){
                if(i>=hoy && listaCitas.size()<70){
                    out.println("<td><a href='NuevaHoraCita?DiaCita="+i+
                            "&IdPaciente="+idPaciente+
                            "&IdCita="+idCita+
                            "'>"+i+"</a></td>");
                }
                else{
                    out.println("<td>"+i+"</td>");
                }
                controlSem++;
                if(controlSem==8){
                out.println("</tr>");
                    controlSem=1;
                }
            }
            out.println("</table>");
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
