<%-- 
    Document   : agregarPaciente
    Created on : 18/05/2017, 12:44:07 PM
    Author     : Zidai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <body>
        <h2>SISTEMA DE SITAS MEDICAS PARA PACIENTES</h2>
        
        <div id="div">
            <table with="50%">
                <form action="AgregarPaciente" method="post">
                    <tbody>
                        <tr>
                            <td>
                                <label>NOMBRE:</label>
                            </td>
                            <td>
                                <input type="text" name="nombre">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>FECHA DE NACIMIENTO:</label>
                            </td>
                            <td>
                                <input type="date" name="fechNac">
                            </td>
                        </tr>
                        <tr>
                            <td>Sexo:</td> 
                            <td><input type="radio" name="sexo" value="M">Masculino</td>
                            <td><input type="radio" name="sexo" value="F">Femenino</td>
                        </tr>
                        <tr>
                            <td>
                                <label>ESTATURA:</label>
                            </td>
                            <td>
                                <input type="number" name="estatura">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label></label>
                            </td>
                            <td>
                                <input type="submit" id="enviar" value="Enviar">
                            </td>
                        </tr>
                    </table>
                </tbody>
            </form>
        </div>
    </body>
</html>
