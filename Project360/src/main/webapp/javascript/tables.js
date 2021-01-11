/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function Medicines() {
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

