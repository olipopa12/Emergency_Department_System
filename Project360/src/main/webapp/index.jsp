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
        <link rel="stylesheet" href="css/mystyle.css">
        <script type="text/javascript" src="javascript/login.js"></script>
        <script type="text/javascript" src="javascript/main.js"></script>

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