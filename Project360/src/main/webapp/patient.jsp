
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient</title>
        <script type="text/javascript" src="javascript/all_entities.js"></script>
        <script type="text/javascript" src="javascript/updates.js"></script>
        <style>

            .box {
                width: 400px;
                height: 780px;
                padding: 40px;
                position: absolute;
                top: 65%;
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
            .box input[type="submit"]:hover {
                background: #123672;
                border: 2px solid #123672;
            }

            .lboxes input[type="submit"] {
                background: #97c984;
                border: 2px solid #006d67;
                color: rgb(3, 2, 2);
                border-radius: 24px;
                outline: none;
                padding:7px 18px;
                transition: 0.20s;
                cursor: pointer;
            }
            .lboxes {
                width: 5%;
                height: 5vh;
            }
            .lboxes input[type="submit"]:hover {
                background: #123672;
                border: 2px solid #123672;
            }

        </style>
        <%
            String firstname = (String) session.getAttribute("firstname");
        %>
        <%
            String lastname = (String) session.getAttribute("lastname");
        %>
        <%
            int number = (Integer) session.getAttribute("number");
        %>
        <%
            int tk = (Integer) session.getAttribute("tk");
        %>
        <%
            String road = (String) session.getAttribute("road");
        %>
        <%
            String AMKA = (String) session.getAttribute("amka");
        %>
        <%
            String insurance = (String) session.getAttribute("insurance");
        %>
        <%
            String telephone = (String) session.getAttribute("telephone");
        %>
    </head>
    <body>
        <div class="container">
            <form class="box">
                <h1>Στοιχεία Ασθενή</h1>
                <table>
                    <tr>
                        <td align="right">First Name:</td>
                        <td align="left"><input type="text" id="firstname" name="firstname" value="<%= firstname%>"  /></td>
                    </tr>
                    <tr>
                        <td align="right">Last Name:</td>
                        <td align="left"><input type="text" id="lastname" name="lastname" value="<%= lastname%>"  /></td>
                    </tr>
                    <tr>
                        <td align="right">Telephone:</td>
                        <td align="left"><input type="text" id="telephone" name="telephone" value="<%= telephone%>" /></td>
                    </tr>
                    <tr>
                        <td align="right">TK:</td>
                        <td align="left"> <input type="text" id="tk" name="tk" value="<%= tk%>"/></td>
                    </tr>
                    <tr>
                        <td align="right">Road:</td>
                        <td align="left"> <input type="text" id="road" name="road" value="<%= road%>" /></td>
                    </tr>
                    <tr>
                        <td align="right">Number:</td>
                        <td align="left"> <input type="text" id="number" name="number" value="<%= number%>" /></td>
                    </tr>
                    <tr>
                        <td align="right">AMKA:</td>
                        <td align="left"> <input type="text" id="amka" name="amka" value="<%= AMKA%>" /></td>
                    </tr>
                    <tr>
                        <td align="right">Insurance:</td>
                        <td align="left"> <input type="text" id="insurance" name="insurance" value="<%= insurance%>" /></td>
                    </tr>

                </table>
            </form>
            <div class="lboxes" style="margin-top:25%; margin-left:5%; text-align: center;">
                <form class=" lbox" method="post"   >
                    <input type="submit" name="" onclick="changePatient()"  value="Change my infos">
                </form>
            </div>
            <div class="lboxes" style="margin-top:5%; margin-left:5%; text-align: center;">
                <form class=" lbox" method="post"   >
                    <input type="submit" name="" onclick="changePatient()"  value="See my history">
                </form>
            </div>
        </div>
    </body>
</html>
