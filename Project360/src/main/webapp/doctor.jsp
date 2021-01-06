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
        <style>

            .box {
                width: 400px;
                height: 400px;
                padding: 40px;
                position: absolute;
                top: 50%;
                left: 50%;
                border-radius: 50px;
                transform: translate(-50%, -50%);
                background: #97c984;
                text-align: center;
            }
            body { background: url(back.jpg) no-repeat fixed;
                   -webkit-background-size: cover;
                   -moz-background-size: cover;
                   -o-background-size: cover;
                   background-size: cover;

            }
            .box h1 {
                color: rgb(3, 2, 2);
                font-family: 'comic sans ms';
                font-weight: 500;
                margin: 0px;
                padding: 0px;
            }
            input[type="text"] {
                color: rgb(3, 2, 2);
                font-family: 'comic sans ms';
                font-size: 18px;
                background: none;
                margin: 15px auto;
                text-align: center;
                border: 2px solid #006d67;
                padding: 15px 15px;
                width: 250px;
                outline: none;
                border-radius: 24px;
                transition: 0.20s;
                cursor: pointer;
            }
            .box input[type="submit"] {
                border: 0;
                background: none;
                display: block;
                margin: 20px auto;
                text-align: center;
                border: 2px solid #006d67;
                padding: 14px 40px;
                outline: none;
                color: rgb(3, 2, 2);
                border-radius: 24px;
                transition: 0.20s;
                cursor: pointer;
            }
            .box input[type="submit"]:hover {
                background: #123672;
                border: 2px solid #123672;
            }
        </style>
        <%
            String name = (String) session.getAttribute("name");
        %>
        <%
            String specialty = (String) session.getAttribute("specialty");
        %>
        <%
            String telephone = (String) session.getAttribute("telephone");
        %>

    </head>
    <body>
        <form class="box">
            <h1>Στοιχεία Γιατρού</h1>
            <table>
                <tr>
                    <td align="right">Name:</td>
                    <td align="left"><input type="text" id="name" name="username" value="<%= name%>"  disabled/></td>
                </tr>
                <tr>
                    <td align="right">Specialty:</td>
                    <td align="left"> <input type="text" id="specialty" name="specialty" value="<%= specialty%>" disabled/></td>
                </tr>
                <tr>
                    <td align="right">Telephone:</td>
                    <td align="left"><input type="text" id="telephone" name="telephone" value="<%= telephone%>" disabled/></td>
                </tr>
                <tr>
                    <td align="right"></td>
                    <td align="center">   <input type="submit" onclick="doctor()" name="" value="change informations" /></td>
                </tr>

            </table>
        </form>

    </body>
</html>
