<%-- 
    Document   : registerShift
    Created on : 12 Ιαν 2021, 12:09:07 πμ
    Author     : kater
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="javascript/registers.js"></script>
        <title>Register Shift</title>
        <style>

            .box {
                width: 430px;
                height: 400px;
                padding: 40px;
                position: absolute;
                border-radius: 50px;
                transform: translate(-50%, -50%);
                background: #97c984;
                top:50%;
                left: 50%;
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
        <form class="box" method="post" action="http://localhost:8080/Project360/newFormShift" >
            <h1>Δημιουργία νέας βάρδιας</h1>
            <table>
                <tr>
                    <td align="right">Doctors ids:</td>
                    <td align="left"><input type="text" id="doctors" name="doctors" value=""  /></td>
                </tr>
                <tr>
                    <td align="right">Nurses ids:</td>
                    <td align="left"><input type="text" id="nurses" name="nurses" value=""  /></td>
                </tr>
                <tr>
                    <td align="right">Employees ids:</td>
                    <td align="left"><input type="text" id="employees" name="employees" value=""  /></td>
                </tr>
                <tr>
                    <td align="right"></td>
                    <td align="center"> <input type="submit" name="" value="Ready"  /></td>
                </tr>
            </table>
        </form>

    </body>
</html>

