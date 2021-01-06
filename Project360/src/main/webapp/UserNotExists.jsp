<%-- 
    Document   : UserNotExists
    Created on : 6 Ιαν 2021, 6:45:10 μμ
    Author     : kater
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
        <script type="text/javascript" src="javascript/doctor.js"></script>
        <style>

            .box {
                width: 400px;
                height: 350px;
                padding: 50px;
                position: absolute;
                top: 50%;
                left: 50%;
                border-radius: 50px;
                transform: translate(-50%, -50%);
                background: red;
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
                font-weight: 100;
                margin: 0px;
                padding: 20px;
            }
            .box h2 {
                color: rgb(3, 2, 2);
                font-family: 'comic sans ms';
                font-weight: 100;
                margin: 0px;
                padding: 60px;
            }
            .box input[type="submit"]:hover {
                background: #123672;
                border: 2px solid #123672;
            }
            .box input[type="submit"] {
                border: 0;
                background: none;
                display: block;
                margin: 0px auto;
                text-align: center;
                border: 2px solid #006d67;
                padding: 14px 40px;
                outline: none;
                color: rgb(3, 2, 2);
                border-radius: 24px;
                transition: 0.20s;
                cursor: pointer;
            }
        </style>


    </head>
    <body>
        <form class="box" action="http://localhost:8080/Project360/">
            <h1>Ο χρήστης δεν βρέθηκε.</h1>
            <h2>!Τσεκαρετε τα στοιχεία σας και ξανά προσπαθήστε!</h2>
            <input type="submit" name="" value="Try again" >
        </form>

    </body>
</html>
