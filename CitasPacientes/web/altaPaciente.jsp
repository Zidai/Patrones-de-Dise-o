<%-- 
    Document   : altaPaciente
    Created on : 22/05/2017, 11:14:31 AM
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
        <h1>Agregar paciente</h1>
    <center>
        <table with="50%">
            <form action="AgregarPaciente" method="post"/>
            <!--AgregarPaciente es un servlet-->
            <tr>
                <td colspan="2">Datos del paciente</td>
            </tr>
            <tr>
                <td>Nombre:</td>
                <td><input type="text" name="nombrePaciente"></td>
            </tr>
            <tr>
                <td>Fecha Nacimiento: </td>
                <td><input type="date" placeholder="dd-MM-yyyy" name="fechaNacimiento"></td>
            </tr>
            <tr>
                <td>Sexo:</td> 
                <td><input type="radio" name="sexo" value="M">Masculino</td>
                <td><input type="radio" name="sexo" value="F">Femenino</td>
            </tr>
            <tr>
                <td>Estatura (cm):</td>
                <td><input type="number" name="estatura" min="70" max="220"> cm</td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Enviar"></td>
            </tr>
    </center>
    </body>
</html>