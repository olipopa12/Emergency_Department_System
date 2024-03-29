<%-- 
    Document   : MyShifts
    Created on : 13 Ιαν 2021, 6:54:21 μμ
    Author     : kater
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta name="author" content="katerina petraki & olimpia popa" />
        <title>See Medical history</title>
        <script type="text/javascript" src="javascript/tables.js"></script>
        <style>


            body { background: url(back.jpg) no-repeat fixed;
                   -webkit-background-size: cover;
                   -moz-background-size: cover;
                   -o-background-size: cover;
                   background-size: cover;

            }

            h1{
                color: rgb(3, 2, 2);
                font-family: 'comic sans ms';
                font-weight: 500;
                margin: 0px;
                padding: 0px;
            }

            .box {
                width: 300px;
                height: 600px;
                padding: 40px;
                position: absolute;
                top: 50%;
                left: 50%;
                border-radius: 50px;
                transform: translate(-50%, -50%);
                background: #97c984;
                text-align: center;
            }
            table {
                font-family: Arial, Helvetica, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }
            table td, table th {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: center;
            }

            table tr{background-color: #9ac1cb;}

            table tr:hover {background-color: #ddd;}

            table th {
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: center;
                background-color: #1e8299;
                color: white;
            }
        </style>

    </head>

    <body onload="Shift()">
        <div class="box ">
            <h1> My shifts for the given dates</h1> 
            </br>
            <table id="s">
                <tr>
                    <th>DATE OF SHIFT</th>
                </tr>
            </table>
        </div>
    </body>
</html>
