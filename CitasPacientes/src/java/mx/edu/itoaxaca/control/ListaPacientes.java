/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itoaxaca.control;

import mx.edu.itoaxaca.modelo.Paciente;
import java.io.IOException;
import java.io.PrintWriter;
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
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

/**
 *
 * @author maldad
 */
@WebServlet(name = "ListaPacientes", urlPatterns = {"/ListaPacientes"})
public class ListaPacientes extends HttpServlet {
    
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
    
    @PersistenceUnit
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            emf = Persistence.createEntityManagerFactory("CitasPacientesPU");
            PacienteJpaController cpLista = new PacienteJpaController(utx, emf);

            List<Paciente> listaPacientes = cpLista.findPacienteEntities();
        //variables para el promedio de estaturas y edades
        float promedioEstaturas = (float)0.0;
        float promedioEdades = (float)0.0;
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListaPacientes</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h1>Servlet Lista de pacientes </h1>");
            out.println("<table aling='left' width='60%' border=1>");
            out.println("<tr><td class='datos'>ID</td>"
                +"<td class='datos'>Nombre</td>"
                +"<td class='datos'>Fecha Nacimiento</td>"
                +"<td class='datos'>Edad</td>"
                +"<td class='datos'>Sexo</td>"
                +"<td class='datos'>Estatura</td>"
                );
            for(Paciente p : listaPacientes){
                //obteniendo la edad...
                Date fn = p.getFecha();
                LocalDate cumple = LocalDate.of(fn.getYear()+1900, fn.getMonth()+1, fn.getDate());
                LocalDate actual = LocalDate.now();
                Period aniosCumplidos = Period.between(cumple, actual);
                int edad = aniosCumplidos.getYears();
                //acumulando estaturas
                promedioEstaturas += p.getEstatura();
                //acumulado edades
                promedioEdades += edad;
                //estatura a string
                String estatura = p.getEstatura().toString();
                String mtscms = estatura.charAt(0) + "mts. " + estatura.charAt(1) 
                    +""+ estatura.charAt(2) +" cms.";
                Date fechNac=p.getFecha();
                Calendar calF=Calendar.getInstance();
                calF.setTime(fechNac);
            //iniciando la tabla
              out.println("<tr><td class='datos'>"+p.getIdpaciente()+"</td>"
                  +"<td class='datos'>"+p.getNombre()+"</td>"
                  +"<td class='datos'>"+calF.get(Calendar.DAY_OF_MONTH)+
                        " de "+mesAString(calF.get(Calendar.MONTH))+
                        " del "+calF.get(Calendar.YEAR)+"</td>"
                  +"<td class='datos'>"+edad+"</td>"        
                  +"<td class='datos'>"+p.getSexo()+"</td>"
                  +"<td class='datos'>"+ mtscms +"</td>"
                  );
            } //for
            out.println("</table>");
            //terminando la tabla
            out.println("<h3>Promedio de estaturas: "
                    +promedioEstaturas / listaPacientes.size() +"</h3>");
            out.println("<h3>Promedio de edades: "
                    +promedioEdades/ listaPacientes.size() +"</h3>");
            out.println("<hr>");
            out.println("<br><br>");
            out.println("<a href=\"index.jsp\">Index</a>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}