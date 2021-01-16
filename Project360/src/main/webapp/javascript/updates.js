/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function changePatient() {
    var xhttp = new XMLHttpRequest();
    var name = "";

    name += "telephone=";
    name += document.getElementById("telephone").value;
    name += "&firstname=";
    name += document.getElementById("firstname").value;
    name += "&lastname=";
    name += document.getElementById("lastname").value;
    name += "&amka=";
    name += document.getElementById("amka").value;
    name += "&insurance=";
    name += document.getElementById("insurance").value;
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
    xhttp.open("POST", "http://localhost:8080/Project360/changePatient");
    //event.preventDefault();
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send(name);
}

function changeNurse() {
    var xhttp = new XMLHttpRequest();
    var name = "";

    name += "telephone=";
    name += document.getElementById("telephone").value;
    name += "&firstname=";
    name += document.getElementById("firstname").value;
    name += "&lastname=";
    name += document.getElementById("lastname").value;


    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            // Typical action to be performed when the document is ready:
            //document.getElementById("demo").innerHTML = xhttp.responseText;
            // window.alert(xhttp.responseText);
            //console.log(xhttp.responseText);
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/changeNurse");
    //event.preventDefault();
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send(name);
}

function changeEmployee() {
    var xhttp = new XMLHttpRequest();
    var name = "";
    name += "telephone=";
    name += document.getElementById("telephone").value;
    name += "&firstname=";
    name += document.getElementById("firstname").value;
    name += "&lastname=";
    name += document.getElementById("lastname").value;
    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            // Typical action to be performed when the document is ready:
            //document.getElementById("demo").innerHTML = xhttp.responseText;
            // window.alert(xhttp.responseText);
            //console.log(xhttp.responseText);
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/changeEmployee");
    //event.preventDefault();
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send(name);
}


function changeDoctor() {
    var xhttp = new XMLHttpRequest();
    var name = "";
    name += "telephone=";
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
            var myElement = xhttp.responseText;
            console.log(myElement);
            document.getElementById("demo").innerHTML = myElement;
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/changeDoctor");
    //event.preventDefault();
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send(name);
}

function changeExamDoctor() {
    var xhttp = new XMLHttpRequest();
    var name = "";
    name += "pid=";
    name += document.getElementById("pid").value;
    name += "&kind=";
    name += document.getElementById("kind").value;
    name += "&eid=";
    name += document.getElementById("eid").value;
    name += "&vid=";
    name += document.getElementById("vid").value;
    name += "&did=";
    name += document.getElementById("did").value;
    name += "&ex=";
    name += document.getElementById("ex").value;
    name += "&nid=";
    name += document.getElementById("nid").value;
    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            // Typical action to be performed when the document is ready:
            //document.getElementById("demo").innerHTML = xhttp.responseText;
            // window.alert(xhttp.responseText);
            //console.log(xhttp.responseText);
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/change_exams");
    //event.preventDefault();
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send(name);
}

function changeReExamDoctor() {
    var xhttp = new XMLHttpRequest();
    var name = "";
    name += "pid=";
    name += document.getElementById("pid").value;
    name += "&kind=";
    name += document.getElementById("kind").value;
    name += "&did=";
    name += document.getElementById("did").value;
    name += "&mid=";
    name += document.getElementById("mid").value;
    name += "&id=";
    name += document.getElementById("id").value;
    name += "&vid=";
    name += document.getElementById("vid").value;
    name += "&hosp=";
    name += document.getElementById("hosp").value;
    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            // Typical action to be performed when the document is ready:
            //document.getElementById("demo").innerHTML = xhttp.responseText;
            // window.alert(xhttp.responseText);
            //console.log(xhttp.responseText);
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/change_re_exams");
    //event.preventDefault();
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send(name);
}

function changeNurseExams() {
    var xhttp = new XMLHttpRequest();
    var name = "";
    name += "pid=";
    name += document.getElementById("pid").value;
    name += "&kind=";
    name += document.getElementById("kind").value;
    name += "&id=";
    name += document.getElementById("id").value;
    name += "&vid=";
    name += document.getElementById("vid").value;
    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            // Typical action to be performed when the document is ready:
            //document.getElementById("demo").innerHTML = xhttp.responseText;
            // window.alert(xhttp.responseText);
            //console.log(xhttp.responseText);
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/change_nurse_exams");
    //event.preventDefault();
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send(name);
}

function changeShifts() {
    var xhttp = new XMLHttpRequest();
    var name = "";
    name += "date=";
    name += document.getElementById("date").value;
    name += "&doctors=";
    name += document.getElementById("doctors").value;
    name += "&murses=";
    name += document.getElementById("nurses").value;
    name += "&employees=";
    name += document.getElementById("employees").value;
    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            // Typical action to be performed when the document is ready:
            //document.getElementById("demo").innerHTML = xhttp.responseText;
            // window.alert(xhttp.responseText);
            //console.log(xhttp.responseText);
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/change_shifts");
    //event.preventDefault();
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send(name);
}
















  