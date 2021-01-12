/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function Send_query() {
    var xhttp = new XMLHttpRequest();
    var name = "";
    var quer = "";
    name += "queries=";
    name += document.getElementById("queries").value;
    quer += document.getElementById("queries").value;
    event.preventDefault();
    console.log(name);
    console.log(document.getElementById("queries").value);

    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            // Typical action to be performed when the document is ready:
            //document.getElementById("demo").innerHTML = xhttp.responseText;
            // window.alert(xhttp.responseText);
            document.getElementById("queries").placeholder = quer;
            document.getElementById("execute").disabled = false;
            var str = xhttp.responseText;
            str = str.replace(/(?:\r\n|\r|\n)/g, '<br>');
            document.getElementById("textarea").innerHTML = str;

        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/get_queries");
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send(name);
}