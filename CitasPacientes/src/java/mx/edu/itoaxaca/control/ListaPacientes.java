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

/**
 *
 * @author maldad
 */
@WebServlet(name = "ListaPacientes", urlPatterns = {"/ListaPacientes"})
public class ListaPacientes extends HttpServlet {
    
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
            
            //iniciando la tabla
              out.println("<tr><td class='datos'>"+p.getIdpaciente()+"</td>"
                  +"<td class='datos'>"+p.getNombre()+"</td>"
                  +"<td class='datos'>"+p.getFecha().toString()+"</td>"
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