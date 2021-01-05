<%-- 
    Document   : doctor
    Created on : 5 Ιαν 2021, 6:41:10 μμ
    Author     : kater
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Doctor</title>
        <script type="text/javascript" src="javascript/doctor.js"></script>
        <%
            String username = (String) session.getAttribute("username");
        %>
        <%
            String password = (String) session.getAttribute("password");
        %>
    </head>
    <body>
        <h1>Είμαι Γιατρός!</h1>
        <h2>Your username is: <%= username%> <br/>
            Your password is:  <%= password%> </h2>
        <input type="submit" onclick="doctor()" name="" value="pathse_me" >

    </body>
</html>
