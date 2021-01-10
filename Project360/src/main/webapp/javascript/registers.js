/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function registerDoctor() {
    var xhttp = new XMLHttpRequest();
    var name = "";
    name += "username=";
    name += document.getElementById("username").value;
    name += "&password=";
    name += document.getElementById("password").value;
    name += "&firstname=";
    name += document.getElementById("firstname").value;
    name += "&lastname=";
    name += document.getElementById("lastname").value;
    name += "&telephone=";
    name += document.getElementById("telephone").value;
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

function registerEmployee() {
    var xhttp = new XMLHttpRequest();
    var name = "";
    name += "username=";
    name += document.getElementById("username").value;
    name += "&password=";
    name += document.getElementById("password").value;
    name += "&firstname=";
    name += document.getElementById("firstname").value;
    name += "&lastname=";
    name += document.getElementById("lastname").value;
    name += "&telephone=";
    name += document.getElementById("telephone").value;
    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            // Typical action to be performed when the document is ready:
            //document.getElementById("demo").innerHTML = xhttp.responseText;
            // window.alert(xhttp.responseText);
            //console.log(xhttp.responseText);
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/newFormEmployee");
    //event.preventDefault();
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send(name);
}

function registerNurse() {
    var xhttp = new XMLHttpRequest();
    var name = "";
    name += "username=";
    name += document.getElementById("username").value;
    name += "&password=";
    name += document.getElementById("password").value;
    name += "&firstname=";
    name += document.getElementById("firstname").value;
    name += "&lastname=";
    name += document.getElementById("lastname").value;
    name += "&telephone=";
    name += document.getElementById("telephone").value;
    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            // Typical action to be performed when the document is ready:
            //document.getElementById("demo").innerHTML = xhttp.responseText;
            // window.alert(xhttp.responseText);
            //console.log(xhttp.responseText);
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/newFormNurse");
    //event.preventDefault();
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send(name);
}

function registerPatient() {
    var xhttp = new XMLHttpRequest();
    var name = "";
    name += "username=";
    name += document.getElementById("username").value;
    name += "&password=";
    name += document.getElementById("password").value;
    name += "&firstname=";
    name += document.getElementById("firstname").value;
    name += "&lastname=";
    name += document.getElementById("lastname").value;
    name += "&telephone=";
    name += document.getElementById("telephone").value;
    name += "&insurance=";
    name += document.getElementById("insurance").value;
    name += "&amka=";
    name += document.getElementById("amka").value;
    name += "&road=";
    name += document.getElementById("road").value;
    name += "&tk=";
    name += document.getElementById("tk").value;
    name += "&number=";
    name += document.getElementById("number").value;
    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            // Typical action to be performed when the document is ready:
            //document.getElementById("demo").innerHTML = xhttp.responseText;
            // window.alert(xhttp.responseText);
            //console.log(xhttp.responseText);
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/newFormPatient");
    //event.preventDefault();
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send(name);
}

function registerVisit() {
    var xhttp = new XMLHttpRequest();
    var name = "";
    name += "date=";
    name += document.getElementById("date").value;
    name += "&symptoms=";
    name += document.getElementById("symptoms").value;
    name += "&pid=";
    name += document.getElementById("pid").value;
    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            // Typical action to be performed when the document is ready:
            //document.getElementById("demo").innerHTML = xhttp.responseText;
            // window.alert(xhttp.responseText);
            //console.log(xhttp.responseText);
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/newFormVisit");
    //event.preventDefault();
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send(name);
}




