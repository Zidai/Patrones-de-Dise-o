/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itoaxaca.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import mx.edu.itoaxaca.modelo.Paciente;

/**
 *
 * @author Zidai
 */
@WebServlet(name = "ResultadosDia", urlPatterns = {"/ResultadosDia"})
public class ResultadosDia extends HttpServlet {
    @PersistenceUnit
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;
    
    public String mesAString(int m){
        switch(m){
            case 0: return "ENERO";
            case 1: return "FEBRERO";
            case 2: return "MARZO";
            case 3: return "ABRIL";
            case 4: return "MAYO";
            case 5: return "JUNIO";
            case 6: return "JULIO";
            case 7: return "AGOSTO";
            case 8: return "SEPTIEMBRE";
            case 9: return "OCTUBRE";
            case 10: return "NOVIEMBRE";
            case 11: return "DICIEMBRE";
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
        CitaJpaController controlCita = new CitaJpaController(utx, emf);
        PacienteJpaController controlPaciente = new PacienteJpaController(utx, emf);
        int diaCita=Integer.parseInt(request.getParameter("DiaCita"));
        List<Cita> listaTodasCitas = controlCita.findCitaEntities();
        ArrayList<Cita> listaCitas = new ArrayList<Cita>();
        for(int i=0;i<listaTodasCitas.size();i++){
            Date fechLTC = listaTodasCitas.get(i).getFecha();
            Calendar calLTC= Calendar.getInstance();
            calLTC.setTime(fechLTC);
            if(calLTC.get(Calendar.DAY_OF_MONTH)==diaCita){
                listaCitas.add(listaTodasCitas.get(i));
            }
        }
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListaCitas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h1>Servlet ListaCitas</h1>");
            out.println("<table aling='left' width='60%' border=1>");
            out.println("<tr><td class='datos'>ID CITA</td>"
                +"<td class='datos'>HORA</td>"
                +"<td class='datos'>FECHA</td>"
                +"<td class='datos'>ID PACIENTE</td>"
                +"<td class='datos'>NOMBRE</td>"
                +"<td class='datos'>STATUS</td>"
                +"<td class='datos'>CONSULTA</td>"
                +"<td class='datos'>OPCIONES</td></tr>");
            for(int i=0;i<listaCitas.size();i++){
                int idCita= listaCitas.get(i).getIdcita();
                Date horaCita= listaCitas.get(i).getHora();
                Calendar calH= Calendar.getInstance();
                calH.setTime(horaCita);
                int hora=calH.get(Calendar.HOUR_OF_DAY);
                Date fechCita= listaCitas.get(i).getFecha();
                Calendar calF= Calendar.getInstance();
                calF.setTime(fechCita);
                int dia=calF.get(Calendar.DAY_OF_MONTH);
                int mes=calF.get(Calendar.MONTH);
                int anno=calF.get(Calendar.YEAR);
                Paciente p=listaCitas.get(i).getPaciente();
                int idPaciente=p.getIdpaciente();
                String nombreP=p.getNombre();
                out.println("<tr><td class='datos'>"+idCita+"</td>"
                  +"<td class='datos'>"+hora+":00</td>"
                  +"<td class='datos'>"+dia+
                        " de "+mesAString(mes)+
                        " de "+anno+"</td>"
                  +"<td class='datos'>"+idPaciente+"</td>"        
                  +"<td class='datos'>"+nombreP+"</td>"
                  +"<td class='datos'>"+listaCitas.get(i).getStatus()+"</td>"
                  +"<td class='datos'><a href='RealizarConsulta?IdCita="+idCita+"'>CONSULTA</a></td>"
                  +"<td class='datos'>|<a href='ElegirNuevoDia?IdCita="+idCita+"&IdPaciente="+idPaciente+"'>EDITAR</a>||<a href='EliminarCita?IdCita="+idCita+"'>ELIMINAR</a>|</td>"
                );
            }
            out.println("</table>");
            out.println("<hr>");
            out.println("<br><br>");
            out.println("<a href=\"index.jsp\">INICIO</a>");
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
