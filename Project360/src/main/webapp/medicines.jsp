<%-- 
    Document   : medicines
    Created on : 11 Ιαν 2021, 6:24:23 μμ
    Author     : kater
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="javascript/registers.js"></script>
        <title>Register Doctor</title>
        <style>

            .box {
                width: 700px;
                height: 570px;
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


        </style>

    </head>
    <body>
        <div class="box">
            <h1>Λίστα φαρμάκων</h1>
            <table id="medicines">
                <tr>
                    <td>Row1 cell1</td>
                    <td>Row1 cell2</td>
                </tr>
                <tr>
                    <td>Row2 cell1</td>
                    <td>Row2 cell2</td>
                </tr>
                <tr>
                    <td>Row3 cell1</td>
                    <td>Row3 cell2</td>
                </tr>
            </table>
        </div>

    </body>
</html>
