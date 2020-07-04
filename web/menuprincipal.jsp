<%-- 
    Document   : menuprincipal
    Created on : 07-03-2020, 12:46:18 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
   try{
        HttpSession var_Session = request.getSession(false);
        String nombres = (String) var_Session.getAttribute("sessionNombres");
        String user = (String) var_Session.getAttribute("sessionUsuario");
        String tipo = (String) var_Session.getAttribute("sessionTipo");
        String correo = (String) var_Session.getAttribute("sessionEmail");
 
        if(user == null){
            out.print("<center><h2><font color='blue'>Debe de haber iniciado Sesion para poder ingresar a esta pagina.</font><br><hr><font color='blue'>Intentelo de Nuevo</font><hr><h2></center><br>");
            out.print("<center><h2><font color='blue'> Por Favor Epere...</font><hr><h2></center>");
            out.print("<meta http-equiv='refresh' content='4; url=http:sesion'/ >");
            out.print("<meta http-equiv='refresh' content='4; url=http:./'/ >");
            response.sendRedirect("./");
        }else if(user!=null){
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Control de Inventario</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Incluimos la vista parcial la cual contiene las url de las librerias 
             correspondientes a estilos y js
        -->
        <%@include file="WEB-INF/Vistas-Parciales/css-js.jspf" %>
    </head>
    <body>
        <!-- Vistar parciales de la parte superior de nuestra aplicación -->
        <%@include file="WEB-INF/Vistas-Parciales/encabezado.jspf" %>
        
        <!-- Todo el contenido de la aplicación -->
        <h3 style="text-align: center; width: 100%;">BIENVENID@S a: Inventario </h3>
        <br>
    <center><img class="mb-4" src="assets/img/inventario.png" width="150" height="150"></center>  
        
        <!-- Vistar parciales de la parte inferior de nuestra aplicación -->
        <%@include file="WEB-INF/Vistas-Parciales/pie.jspf" %>
    </body>
</html>
<%
            }
               //Aca puede ir un mensaje para informar que no se ha iniciado sesión.
            }catch(Exception e){

            }
   %>