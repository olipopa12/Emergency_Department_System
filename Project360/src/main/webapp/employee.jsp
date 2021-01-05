
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee</title>
        <script type="text/javascript" src="javascript/employee.js"></script>
        <%
            String username = (String) session.getAttribute("username");
        %>
        <%
            String password = (String) session.getAttribute("password");
        %>
    </head>
    <body>
        <h1>Είμαι Υπάλληλος!</h1>
        <h2>Your username is: <%= username%> <br/>
            Your password is:  <%= password%> </h2>
        <input type="submit" onclick="employee()" name="" value="pathse_me"  >

    </body>
</html>
