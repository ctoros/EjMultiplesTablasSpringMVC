<%-- 
    Document   : buscar
    Created on : 25-07-2018, 13:43:05
    Author     : ctoro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Buscar Fonos para alumno</h1>
        
        <form action="mostrar.htm" method="post">
            <input type="text" name="txtRut" /> RUT <br/> <br/>
            <input type="submit" value="Buscar..."/>
            
        </form>
    </body>
</html>
