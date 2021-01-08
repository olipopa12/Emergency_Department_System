/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function registerDoctor() {
    var xhttp = new XMLHttpRequest();
    var name = "";
    name += "username=";
    name += document.getElementById("name").value;
    name += "&password=";
    name += document.getElementById("password").value;
    name += "&telephone=";
    name += document.getElementById("telephone").value;
    name += "&firstname=";
    name += document.getElementById("firstname").value;
    name += "&lastname=";
    name += document.getElementById("lastname").value;
    name += "&specialty=";
    name += document.getElementById("specialty").value;
    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            // Typical action to be performed when the document is ready:
            //document.getElementById("demo").innerHTML = xhttp.responseText;
            // window.alert(xhttp.responseText);
            //console.log(xhttp.responseText);
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/newFormDoctor");
    //event.preventDefault();
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send(name);
}


