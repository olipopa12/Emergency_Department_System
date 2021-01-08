<%-- 
    Document   : registerEmployee
    Created on : 8 Ιαν 2021, 3:10:41 πμ
    Author     : kater
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="javascript/registerEmployee.js"></script>
        <title>Register Employee</title>
        <style>

            .box {
                width: 400px;
                height: 500px;
                padding: 40px;
                position: absolute;
                border-radius: 50px;
                transform: translate(-50%, -50%);
                background: #97c984;
                top:75%;
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
        <form class="box" method="post" action="http://localhost:8080/Project360/newFormEmployee" >
            <h1>Εγγραφή νέου Υπαλλήλου</h1>
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
                    <td align="right">First Name:</td>
                    <td align="left"><input type="text" id="firstname" name="firstname" value=""  /></td>
                </tr>
                <tr>
                    <td align="right">Last Name:</td>
                    <td align="left"><input type="text" id="lastname" name="lastname" value=""  /></td>
                </tr>
                <tr>
                    <td align="right">Telephone:</td>
                    <td align="left"><input type="text" id="telephone" name="telephone" value=""  /></td>
                </tr>
                <tr>
                    <td align="right"></td>
                    <td align="center"> <input type="submit" name="" value="Ready"  /></td>
                </tr>
            </table>
        </form>

    </body>
</html>
