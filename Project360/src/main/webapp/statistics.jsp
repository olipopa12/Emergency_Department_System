<%-- 
    Document   : statistics
    Created on : 13 Ιαν 2021, 11:28:29 μμ
    Author     : kater
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta name="author" content="katerina petraki & olimpia popa" />
        <title>Statistics</title>
        <script type="text/javascript" src="javascript/tables.js"></script>
        <style>


            body { background: url(back.jpg) no-repeat fixed;
                   -webkit-background-size: cover;
                   -moz-background-size: cover;
                   -o-background-size: cover;
                   background-size: cover;

            }

            h2 {
                color: rgb(3, 2, 2);
                font-family: 'comic sans ms';
                font-weight: 500;
                margin: 0px;
                padding: 0px;
            }
            .lubox {
                width: 700px;
                height: 500px;
                padding: 40px;
                position: absolute;
                top: 44%;
                left: 30%;
                border-radius: 50px;
                transform: translate(-50%, -50%);
                background: #97c984;
                text-align: center;
            }
            .rubox {
                width: 600px;
                height: 500px;
                padding: 40px;
                position: absolute;
                top: 44%;
                left:85%;
                border-radius: 50px;
                transform: translate(-50%, -50%);
                background: #97c984;
                text-align: center;
            }
            .ldbox {
                width: 860px;
                height: 500px;
                padding: 40px;
                position: absolute;
                top: 136%;
                left: 36%;
                border-radius: 50px;
                transform: translate(-50%, -50%);
                background: #97c984;
                text-align: center;
            }
            .rdbox {
                width: 415px;
                height: 500px;
                padding: 40px;
                position: absolute;
                top: 136%;
                left: 91%;
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

    <body onload="Statistics()">
        <div class="container ">
            <div class="lubox">
                <h2> Examinations from doctors</h2>   
                <table id="lu">
                    <tr>
                        <th>EXAMINATION KIND</th>
                        <th>FIRSTNAME DOC</th>
                        <th>LASTNAME DOC</th>
                        <th>POSSIBLE DIAGNOSIS</th>
                        <th>DATE</th>
                    </tr>
                </table>
            </div>
            <div class="rubox">
                <h2> Examinations from nurses</h2> 
                <table id="ru">
                    <tr>
                        <th>EXAMINATION KIND</th>
                        <th>FIRSTNAME NURSE</th>
                        <th>LASTNAME NURSE</th>
                        <th>DATE</th>
                    </tr>
                </table>
            </div>
            <div class="ldbox">
                <h2> Re-examinations from doctors</h2>  
                <table id="ld">
                    <tr>
                        <th>EXAMINATION KIND</th>
                        <th>FIRSTNAME DOC</th>
                        <th>LASTNAME DOC</th>
                        <th>TREATMENT</th>
                        <th>DATE</th>
                        <th>FINAL DIAGNOSIS</th>
                    </tr>
                </table>
            </div>
            <div class="rdbox">
                <h2> Visits </h2> 
                <table id="rd">
                    <tr>
                        <th>DATE</th>
                        <th>FIRSTNAME PAT</th>
                        <th>LASTNAME PAT</th>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
