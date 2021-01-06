
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient</title>
        <script type="text/javascript" src="javascript/patient.js"></script>
        <style>

            .box {
                width: 400px;
                height: 550px;
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
                margin: 10px auto;
                text-align: center;
                border: 2px solid #006d67;
                padding: 10px 20px;
                outline: none;
                color: rgb(3, 2, 2);
                border-radius: 24px;
                transition: 0.20s;
                cursor: pointer;
            }
        </style>
        <%
            String username = (String) session.getAttribute("username");
        %>
        <%
            String address = (String) session.getAttribute("address");
        %>
        <%
            String AMKA = (String) session.getAttribute("AMKA");
        %>
        <%
            String insurance = (String) session.getAttribute("insurance");
        %>
        <%
            String telephone = (String) session.getAttribute("telephone");
        %>
    </head>
    <body>
        <form class="box">
            <h1>Στοιχεία Ασθενούς</h1>
            <table>
                <tr>
                    <td align="right">Name:</td>
                    <td align="left"><input type="text" id="name" name="username" value="<%= username%>"  disabled/></td>
                </tr>
                <tr>
                    <td align="right">Telephone:</td>
                    <td align="left"><input type="text" id="telephone" name="telephone" value="<%= telephone%>" disabled/></td>
                </tr>
                <tr>
                    <td align="right">Address:</td>
                    <td align="left"> <input type="text" id="address" name="username" value="<%= address%>" disabled/></td>
                </tr>
                <tr>
                    <td align="right">AMKA:</td>
                    <td align="left"> <input type="text" id="amka" name="amka" value="<%= AMKA%>" disabled/></td>
                </tr>
                <tr>
                    <td align="right">Insurance:</td>
                    <td align="left"> <input type="text" id="insurance" name="insurance" value="<%= insurance%>" disabled/></td>
                </tr>
                <tr>
                    <td align="right"></td>
                    <td align="center">   <input type="submit" onclick="patient()" name="" value="change informations" /></td>
                </tr>
            </table>
        </form>

    </body>
</html>
