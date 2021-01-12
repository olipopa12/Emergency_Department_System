<%-- 
    Document   : queries
    Created on : 11 Ιαν 2021, 11:58:10 μμ
    Author     : kater
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee</title>
        <script type="text/javascript" src="javascript/execute_queries.js"></script>
        <style>


            body { background: url(back.jpg) no-repeat fixed;
                   -webkit-background-size: cover;
                   -moz-background-size: cover;
                   -o-background-size: cover;
                   background-size: cover;

            }
            .lbox {
                width: 400px;
                height: 400px;
                padding: 40px;
                position: absolute;
                top: 50%;
                left: 20%;
                border-radius: 50px;
                transform: translate(-50%, -50%);
                background: #97c984;
                text-align: center;
            }

            h1 {
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
                text-align: left;
                border: 2px solid #006d67;
                padding: 70px 30px;
                width: 300px;
                outline: none;
                border-radius: 24px;
                transition: 0.20s;
                cursor: pointer;
            }
            .lbox input[type="submit"] {
                border: 0;
                background: none;
                display: block;
                margin: 10px auto;
                text-align: center;
                border: 2px solid #006d67;
                padding: 15px 30px;
                outline: none;
                color: rgb(3, 2, 2);
                border-radius: 24px;
                transition: 0.20s;
                cursor: pointer;
            }
            .lbox input[type="submit"]:hover {
                background: #123672;
                border: 2px solid #123672;
            }

            .rbox {
                width: 685px;
                height: 400px;
                padding: 40px;
                position: absolute;
                top: 50%;
                left: 69%;
                border-radius: 50px;
                transform: translate(-50%, -50%);
                background: #97c984;
                text-align: center;
            }
            #textarea {
                color: rgb(3, 2, 2);
                font-family: 'comic sans ms';
                font-size: 18px;
                background: none;
                margin: 15px auto;
                text-align: left;
                border: 2px solid #006d67;
                padding: 70px 30px;
                width: 630px;
                height: 200px;
                outline: none;
                white-space: nowrap;
                border-radius: 24px;
                transition: 0.20s;
                cursor: pointer;

            }


        </style>

    </head>

    <body >
        <div class="container ">
            <form class="lbox" method="post" >
                <h1> Give a query to be executed</h1>
                </br>
                </br>
                <input type="text" id="queries" name="queries" value="" placeholder="" >
                <input type="submit" id="execute" name="execute" value="Execute" onclick="Send_query()"> 
            </form>
            <div class="rbox">
                <h1> Result</h1>              
                <div id="textarea" contenteditable ></div>
            </div>
        </div>
    </body>
</html>
