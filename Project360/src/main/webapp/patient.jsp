<%-- 
    Document   : login
    Created on : 3 Ιαν 2021, 9:48:55 μμ
    Author     : kater
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="javascript/request_patient.js"></script>
        <%
            String username = (String) session.getAttribute("username");
        %>
        <%
            String password = (String) session.getAttribute("password");
        %>
    </head>
    <body>
        <h2>Your username is: <%= username%> <br/>
            Your password is:  <%= password%> </h2>
        <input type="submit" onclick="patient()" name="" value="show_kati" >

    </body>
</html>
