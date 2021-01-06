<%-- 
    Document   : Register
    Created on : 6 Ιαν 2021, 8:45:03 μμ
    Author     : kater
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient</title>
        <script type="text/javascript" src="javascript/patient.js"></script>
        <style>

            .box {
                width: 33%;
                height: 100%;
                padding: 40px;
                position: absolute;
                top: 60%;
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
                padding: 10px 15px;
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
            .box input[type="submit"]:hover {
                background: #123672;
                border: 2px solid #123672;
            }
        </style>

    </head>
    <body>
        <form class="box" method="post" action="http://localhost:8080/Project360/newForm" >
            <h1>Εγγραφή νέου Ασθενούς</h1>
            <table>
                 <tr>
                    <td align="right">Username:</td>
                    <td align="left"><input type="text" id="username" name="username" value=""  /></td>
                </tr>
                 <tr>
                    <td align="right">Password:</td>
                    <td align="left"><input type="text" id="password" name="password" value=""  /></td>
                </tr>
                <tr>
                    <td align="right">Name:</td>
                    <td align="left"><input type="text" id="name" name="name" value=""  /></td>
                </tr>
                <tr>
                    <td align="right">Telephone:</td>
                    <td align="left"><input type="text" id="telephone" name="telephone" value="" /></td>
                </tr>
                <tr>
                    <td align="right">Address:</td>
                    <td align="left"> <input type="text" id="address" name="address" value="" /></td>
                </tr>
                <tr>
                    <td align="right">AMKA:</td>
                    <td align="left"> <input type="text" id="amka" name="amka" value="" /></td>
                </tr>
                <tr>
                    <td align="right">Insurance:</td>
                    <td align="left"> <input type="text" id="insurance" name="insurance" value="" /></td>
                </tr>
                <tr>
                    <td align="right"></td>
                    <td align="center"> <input type="submit" name="" value="Ready"  /></td>
                </tr>
            </table>
        </form>

    </body>
</html>
