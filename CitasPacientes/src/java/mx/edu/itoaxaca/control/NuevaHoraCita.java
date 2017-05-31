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
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import static mx.edu.itoaxaca.control.HoraCita.idPaciente;
import mx.edu.itoaxaca.modelo.Cita;
import mx.edu.itoaxaca.modelo.Paciente;

/**
 *
 * @author Zidai
 */
@WebServlet(name = "NuevaHoraCita", urlPatterns = {"/NuevaHoraCita"})
public class NuevaHoraCita extends HttpServlet {
    
    @PersistenceUnit
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;
    static int idPaciente;
    static int diaCita;
    static int horasValidas;
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
        List<Cita> listaTodasHoras = cc.findCitaEntities();
        idPaciente=Integer.parseInt(request.getParameter("IdPaciente"));
        diaCita=Integer.parseInt(request.getParameter("DiaCita"));        
        int idCita=Integer.parseInt(request.getParameter("IdCita"));
        Paciente p =cp.findPaciente(idPaciente);
        Date fechaCita = new Date(ElegirNuevoDia.anio - 1900, ElegirNuevoDia.mes - 1,Integer.parseInt(request.getParameter("DiaCita")));
        Calendar calFechaCita=Calendar.getInstance();
        calFechaCita.setTime(fechaCita);
        ArrayList<Date> listaHoras = new ArrayList<Date>();        
        ArrayList<Integer> citasHoy = new ArrayList<Integer>();
            
        for(int i=0;i<listaTodasHoras.size();i++){
            Date fecha = listaTodasHoras.get(i).getFecha();
            Date hora = listaTodasHoras.get(i).getHora();
            Calendar calF= Calendar.getInstance();
            Calendar calH= Calendar.getInstance();
            Calendar cita= Calendar.getInstance();
            calF.setTime(fecha);
            calH.setTime(hora);
            int nAnio=calF.get(Calendar.YEAR)-1900;
            int nMes=calF.get(Calendar.MONTH);
            int nDia=calF.get(Calendar.DAY_OF_MONTH);
            Date fechaYHora=new Date(nAnio,nMes,nDia,calH.get(Calendar.HOUR_OF_DAY),calH.get(Calendar.MINUTE), calH.get(Calendar.SECOND));
            cita.setTime(fechaYHora);
            Date cit=cita.getTime();
            listaHoras.add(cit);
        }
        for(int i=0;i<listaHoras.size();i++){
            Date citaActual=listaHoras.get(i);
            Calendar calActual=Calendar.getInstance();
            calActual.setTime(citaActual);
            if(calActual.get(Calendar.DAY_OF_MONTH)==diaCita){
                citasHoy.add(calActual.get(Calendar.HOUR_OF_DAY));
            }
        }
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SeleccionHoraCita</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h1> Agendar HORA </h1>");
            out.println("<label>Nombre:"+p.getNombre()+" </label>");
            out.println("<br>");
            out.println("<label>Fecha:"+calFechaCita.get(Calendar.DAY_OF_MONTH)+
                    " de "+mesAString(calFechaCita.get(Calendar.MONTH))+
                    " del "+calFechaCita.get(Calendar.YEAR)+" </label>");
            out.println("<br>");
            out.println("<label>Hora: </label>");
            
            out.println("<form action='CitaActualizada?IDpaciente="+idPaciente+"&DIAcita="+diaCita+"&IDcita="+idCita+"' method='post'>");
            out.println("<select name='HORAcita'>");
            for(horasValidas=7;horasValidas<=18;horasValidas++){
                if(!citasHoy.contains(horasValidas)){
                    out.println("<option value="+horasValidas+">"+horasValidas+":00</option>");
                }
            }
            out.println("</select><input type='submit' value='ENVIAR'></input>");
            out.println("</form>");
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
