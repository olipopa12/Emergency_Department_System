<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee</title>
        <script type="text/javascript" src="javascript/employee.js"></script>
        <script type="text/javascript" src="javascript/registerPatient.js"></script>
        <style>
            .box {
                border-radius: 50px;
                position: absolute;
                background: #97c984;
                text-align: center;
                width: 400px;
                height: 370px;
                padding: 40px;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
            }

            body {
                background: url(back.jpg) no-repeat fixed;
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
            }

            .box input[type="text"] {
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
                background: none;
                display: block;
                text-align: center;
                border: 2px solid #006d67;
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

            .lboxes input[type="submit"] {
                background: none;
                border: 2px solid #006d67;
                outline: none;
                color: rgb(3, 2, 2);
                border-radius: 24px;
                transition: 0.20s;
                cursor: pointer;
            }
            .lboxes {
                background: #97c984;
                border-radius: 50px;

                width: 15%;
                height: 10vh;
            }
            .lboxes input[type="submit"]:hover {
                background: #123672;
                border: 2px solid #123672;
            }
            <% String firstname = (String) session.getAttribute("firstname"); %>
            <%String lastname = (String) session.getAttribute("lastname");  %>

            <%String telephone = (String) session.getAttribute("telephone");%>
        </style>

    </head>

    <body>
        <div class="container ">

            <form class="box">
                <h1>Στοιχεία Υπαλλήλου</h1>
                <table>
                    <tr>
                        <td align="right">First Name:</td>
                        <td align="left"><input type="text" id="firstname" name="firstname" value="<%= firstname%>"   /></td>
                    </tr>
                    <tr>
                        <td align="right">Last Name:</td>
                        <td align="left"><input type="text" id="lastname" name="lastname" value="<%= lastname%>"  /> </td>  
                    </tr>
                    <tr>
                        <td align="right">Telephone:</td>
                        <td align="left"><input type="text" id="telephone" name="telephone" value="<%= telephone%>" /> </td>
                    </tr>
                    </br>
                    <tr>
                        <td align="right"></td>
                        <td align="center"> <input type="submit" onclick="employee()" name="" value="change informations" /> </td>
                    </tr>
                </table>
            </form>

            <div class="lboxes " style="margin-top:10%; margin-left:5%; text-align: center;">
                <form class=" lbox" method="post" action="http://localhost:8080/Project360/registerPatient">
                    <p>Add new patient: </p>
                    <input type="submit" name="" value="add">
                </form>
            </div>
            <div class="lboxes " style="margin-top:2.5%; margin-left:5%; text-align: center; ">
                <form class="lbox" style='top:25%' method="get" action="http://localhost:8080/Project360/registerEmployee">
                    <p> Add new employee:</p>
                    <input type="submit" name="" value="add">
                </form>
            </div>

            <div class="lboxes " style="margin-top:2.5%; margin-left:5%; text-align: center;">
                <form class="lbox" style='top:45%' method="get" action="http://localhost:8080/Project360/registerDoctor">
                    <p> Add new doctor:</p>
                    <input type="submit" name="" value="add">
                </form>
            </div>

            <div class="lboxes " style="margin-top:2.5%; margin-left:5%; text-align: center;">
                <form class="lbox" style='top:65%' method="get" action="http://localhost:8080/Project360/registerNurse">
                    <p> Add new nurse: </p>
                    <input type="submit" name="" value="add">
                </form>
            </div>
        </div>
    </body>

</html>