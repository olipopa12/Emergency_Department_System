
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient</title>
        <script type="text/javascript" src="javascript/patient.js"></script>
        <%
            String username = (String) session.getAttribute("username");
        %>
        <%
            String password = (String) session.getAttribute("password");
        %>
    </head>
    <body>
        <h1>Είμαι Aσθενής!</h1>
        <h2>Your username is: <%= username%> <br/>
            Your password is:  <%= password%> </h2>
        <input type="submit" onclick="patient()" name="" value="pathse_me" >

    </body>
</html>
