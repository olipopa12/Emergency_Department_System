<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>

<html lang="en">

    <head>
        <title>emergency department webpage</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta name="author" content="katerina petraki & olimpia popa" />
        <script type="text/javascript" src="javascript/login.js"></script>
        <script type="text/javascript" src="javascript/register.js"></script>
        <script type="text/javascript" src="javascript/koumpi_show.js"></script>
        <style>
            body {
                background: url(back.jpg) no-repeat fixed;
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
            }

            .box label[for="show"] {
                color: rgb(3, 2, 2);
                font-family: 'comic sans ms';
            }

            .box [type="checkbox"] {
                cursor: pointer;
            }

            .box {
                width: 400px;
                height: 400px;
                padding: 40px;
                position: absolute;
                top: 45%;
                left: 50%;
                border-radius: 50px;
                transform: translate(-50%, -50%);
                background: #97c984;
                text-align: center;
            }

            .box h1 {
                color: rgb(3, 2, 2);
                text-transform: uppercase;
                font-family: 'comic sans ms';
                font-weight: 400;
                margin: 10px;
                padding: 35px;
            }

            .box input[type="text"],
            .box input[type="password"] {
                background: none;
                display: block;
                margin: 20px auto;
                text-align: center;
                border: 2px solid #006d67;
                padding: 20px 20px;
                width: 250px;
                outline: none;
                border-radius: 24px;
                transition: 0.20s;
                cursor: pointer;
            }

            .box input[type="text"]:focus,
            .box input[type="password"]:focus {
                width: 340px;
                padding: 20px 20px;
                font-size: 25px;
                color: rgb(3, 2, 2);
                border-color: #123672;
            }

            .box input[type="submit"] {
                border: 0;
                background: none;
                display: block;
                margin: 10% auto;
                text-align: left;
                border: 2px solid #006d67;
                padding: 2% 5%;
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

        <form class="box" method="post" action="http://localhost:8080/Project360/login" >
            <h1>Welcome!</h1>
            <input type="text" id="name" name="username" value="" placeholder="Username">
            <input type="password" id="password" name="password" value="" placeholder="Password">
            <label for="show">Show:</label>
            <input type="checkbox" onclick="pass(this)">
            <input type="submit" name="" value="Login" > 
        </form>
        
    </body>

</html>