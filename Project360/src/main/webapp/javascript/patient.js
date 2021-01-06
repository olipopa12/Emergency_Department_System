/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function patient() {
    var xhttp = new XMLHttpRequest();
    var name = "kati_kanei";

    document.getElementById('telephone').removeAttr("disabled");
    document.getElementById('address').removeAttr("disabled");
    document.getElementById('insurance').removeAttr("disabled");
    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status == 200) {
            // Typical action to be performed when the document is ready:
            //document.getElementById("demo").innerHTML = xhttp.responseText;
            // window.alert(xhttp.responseText);
            console.log(xhttp.responseText);
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/patient");
    //event.preventDefault();
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send(name);
}
