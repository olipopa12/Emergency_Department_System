/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function Doctor() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            var str = xhttp.responseText;
            var res = str.split(",");
            var f = res[0];
            var l = res[1];
            var t = res[2];
            var s = res[3];
            /*console.log(f);
             console.log(l);
             console.log(t);
             console.log(s);*/
            document.getElementById("firstname").value = f;
            document.getElementById("lastname").value = l;
            document.getElementById("telephone").value = t;
            document.getElementById("specialty").value = s;
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/doctor");
    //event.preventDefault();
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send();
}

function Employee() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            var str = xhttp.responseText;
            var res = str.split(",");
            var f = res[0];
            var l = res[1];
            var t = res[2];
            //console.log(f);
            //console.log(l);
            //console.log(t);
            document.getElementById("firstname").value = f;
            document.getElementById("lastname").value = l;
            document.getElementById("telephone").value = t;
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/employee");
    //event.preventDefault();
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send();
}

function Nurse() {
    var xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            var str = xhttp.responseText;
            var res = str.split(",");
            var f = res[0];
            var l = res[1];
            var t = res[2];
            //console.log(f);
            //console.log(l);
            //console.log(t);
            document.getElementById("firstname").value = f;
            document.getElementById("lastname").value = l;
            document.getElementById("telephone").value = t;
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/nurse");
    //event.preventDefault();
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send();
}

function Patient() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            var str = xhttp.responseText;
            var res = str.split(",");
            var f = res[0];
            var l = res[1];
            var t = res[2];
            var i = res[3];
            var a = res[4];
            var tk = res[5];
            var r = res[6];
            var n = res[7];
            //console.log(f);
            // console.log(l);
            // console.log(t);
            // console.log(i);
            //console.log(a);
            //console.log(tk);
            // console.log(r);
            // console.log(n);
            document.getElementById("firstname").value = f;
            document.getElementById("lastname").value = l;
            document.getElementById("telephone").value = t;
            document.getElementById("insurance").value = i;
            document.getElementById("amka").value = a;
            document.getElementById("tk").value = tk;
            document.getElementById("road").value = r;
            document.getElementById("number").value = n;
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/patient");
    //event.preventDefault();
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send();
}




