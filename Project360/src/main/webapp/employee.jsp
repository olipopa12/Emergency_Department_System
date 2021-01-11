<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee</title>
        <script type="text/javascript" src="javascript/all_entities.js"></script>
        <script type="text/javascript" src="javascript/updates.js"></script>
        <script type="text/javascript" src="javascript/registers.js"></script>
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
                padding:10px 15px;
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

    </head>

    <body onload="Employee()">
        <div class="container ">

            <form class="box">
                <h1>Στοιχεία Υπαλλήλου</h1>
                <table>
                    <tr>
                        <td align="right">First Name:</td>
                        <td align="left"><input type="text" id="firstname" name="firstname" value=""   /></td>
                    </tr>
                    <tr>
                        <td align="right">Last Name:</td>
                        <td align="left"><input type="text" id="lastname" name="lastname" value=""  /> </td>  
                    </tr>
                    <tr>
                        <td align="right">Telephone:</td>
                        <td align="left"><input type="text" id="telephone" name="telephone" value="" /> </td>
                    </tr>
                    </br>

                </table>
            </form>


            <div class="lboxes" style="margin-top:1.5%; margin-left:5%; text-align: center;">
                <form  method="post" >
                    <input type="submit" name="" onclick="changeEmployee()" value="Change my info">
                </form>
            </div>

            <div class="lboxes" style="margin-top:2%; margin-left:5%; text-align: center;">
                <form  method="post" action="http://localhost:8080/Project360/see_patients">
                    <input type="submit" name=""  value="See patients' info">
                </form>
            </div>

            <div class="lboxes" style="margin-top:2%; margin-left:5%; text-align: center;">
                <form  method="post"  action="http://localhost:8080/Project360/see_doctors">
                    <input type="submit" name=""  value="See doctors' info">
                </form>
            </div>
            <div class="lboxes" style="margin-top:2%; margin-left:5%; text-align: center;">
                <form  method="post"  action="http://localhost:8080/Project360/see_employees">
                    <input type="submit" name=""  value="See employees' info">
                </form>
            </div>
            <div class="lboxes" style="margin-top:2%; margin-left:5%; text-align: center;">
                <form  method="post"  action="http://localhost:8080/Project360/see_nurses">
                    <input type="submit" name=""  value="See nurses' info">
                </form>
            </div>
            <div class="lboxes" style="margin-top:2%; margin-left:5%; text-align: center;">
                <form  method="post"  action="http://localhost:8080/Project360/registerVisit">
                    <input type="submit"  name="" value="Add new visit ">
                </form>
            </div>
            <div class="lboxes " style="margin-top:2%; margin-left:5%; text-align: center;">
                <form  method="post"    action="http://localhost:8080/Project360/registerPatient">
                    <input type="submit" name=""  value="Add new patient">
                </form>
            </div>
            <div class="lboxes " style="margin-top:2%; margin-left:5%; text-align: center; ">
                <form   method="post" action="http://localhost:8080/Project360/registerEmployee">
                    <input type="submit" name=""  value="Add new employee">
                </form>
            </div>

            <div class="lboxes " style="margin-top:2%; margin-left:5%; text-align: center;">
                <form  method="post" action="http://localhost:8080/Project360/registerDoctor">
                    <input type="submit" name=""   value="Add new doctor">
                </form>
            </div>

            <div class="lboxes " style="margin-top:2%; margin-left:5%; text-align: center;">
                <form   method="post" action="http://localhost:8080/Project360/registerNurse">
                    <input type="submit" name=""  value="Add new nurse">
                </form>
            </div>
            <div class="lboxes" style="margin-top:2%; margin-left:5%; text-align: center;">
                <form  method="post" action="http://localhost:8080/Project360/registerNurse">
                    <input type="submit" name=""  value="Add new shift">
                </form> 
            </div>
        </div>

    </body>

</html>