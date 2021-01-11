<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nurse</title>
        <script type="text/javascript" src="javascript/all_entities.js"></script>
        <script type="text/javascript" src="javascript/updates.js"></script>
        <script type="text/javascript" src="javascript/registers.js"></script>
        <style>
            .box {
                width: 400px;
                height: 350px;
                padding: 40px;
                position: absolute;
                top: 50%;
                left: 50%;
                border-radius: 50px;
                transform: translate(-50%, -50%);
                background: #97c984;
                text-align: center;
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
            
            .lboxes input[type="submit"] {
                background: #97c984;
                border: 2px solid #006d67;
                color: rgb(3, 2, 2);
                border-radius: 24px;
                outline: none;
                padding: 7px 18px;
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

    <body onload="Nurse()">
        <div class="container">
            <form class="box">
                <h1>Στοιχεία Νοσοκόμου</h1>
                <table>
                    <tr>
                        <td align="right">First Name:</td>
                        <td align="left"><input type="text" id="firstname" name="firstname" value="" /></td>
                    </tr>
                    <tr>
                        <td align="right">Last Name:</td>
                        <td align="left"><input type="text" id="lastname" name="lastname" value="" /></td>
                    </tr>
                    </br>
                    <tr>
                        <td align="right">Telephone</td>
                        <td align="left"><input type="text" id="telephone" name="telephone" value="" /></td>
                    </tr>
                </table>
            </form>
            <div class="lboxes" style="margin-top:15%; margin-left:5%; text-align: center;">
                <form class=" lbox" method="post">
                    </br>
                    <input type="submit" name="" onclick="changeNurse()" value="Change my infos">
                </form>
            </div>
            <div class="lboxes" style="margin-top:2.5%; margin-left:5%; text-align: center;">
                <form class=" lbox" method="post">
                    </br>
                    <input type="submit" name="" onclick="changeNurse()" value="Add new clinic examination">
                </form>
            </div>
            <div class="lboxes" style="margin-top:2.5%; margin-left:5%; text-align: center;">
                <form class=" lbox" method="post" action="http://localhost:8080/Project360/see_patients">
                    </br>
                    <input type="submit" name=""  value="See patients' list">
                </form>
            </div>
        </div>
    </body>

    </html>