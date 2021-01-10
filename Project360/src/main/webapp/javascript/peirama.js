function getElementById()
{
    /* var myElement = document.getElementById("intro");
     document.getElementById("demo").innerHTML =
     "The text from the intro paragraph is " + myElement.innerHTML;*/
    var xhttp = new XMLHttpRequest();
    //var name = "";
    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            //esteila post request sto servlet kai mou apanthse me string
            //me string oti kaname
            //me pinaka kati allo
            var myElement = xhttp.responseText;
            console.log(myElement);
            document.getElementById("demo").innerHTML = myElement;
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/peirama");
    //event.preventDefault();
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    //xhttp.send(name);
}
