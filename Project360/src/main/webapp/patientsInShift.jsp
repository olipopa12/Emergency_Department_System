<%-- 
    Document   : patientsInShift
    Created on : 12 Ιαν 2021, 1:32:14 πμ
    Author     : kater
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="javascript/tables.js"></script>
        <title>Show patients' in current shift</title>
        <style>
            #pat {
                font-family: Arial, Helvetica, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }
            #pat td, #pat th {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: center;
            }

            #pat tr{background-color: #9ac1cb;}

            #pat tr:hover {background-color: #ddd;}

            #pat th {
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: center;
                background-color: #1e8299;
                color: white;
            }
            .box {
                width: 700px;
                height: 1000px;
                padding: 40px;
                position: absolute;
                border-radius: 50px;
                transform: translate(-50%, -50%);
                background: #97c984;
                top:90%;
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
    <body onload="PatientsInShift()">
        <div class="box">
            <h1>Λίστα ασθενών που ήρθαν στην τωρινή βάρδια</h1>
            </br>
            <table id="pat">
                <tr>
                    <th>PATIENT_ID</th>
                    <th>FIRSTNAME</th>
                    <th>LASTNAME</th>
                    <th>SHIFT_ID</th>
                </tr>
            </table>
        </div>

    </body>
</html>

