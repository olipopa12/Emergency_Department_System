/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function Medicines() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            var r = 0;
            var pou = 1;
            var str = xhttp.responseText;
            var row = str.split(",");
            var col = "";
            var length_row = row.length;
            while (r < (length_row - 1)) {
                var row = str.split(",");
                col = "";
                col = row[r].split(" ");
                var f1 = col[0];
                var f2 = col[1];
                var f3 = col[2];
                var f4 = col[3];
                var f5 = col[4];
                var table = document.getElementById("meds");
                var row = table.insertRow(pou);
                var c1 = row.insertCell(0);
                var c2 = row.insertCell(1);
                var c3 = row.insertCell(2);
                var c4 = row.insertCell(3);
                var c5 = row.insertCell(4);
                c1.innerHTML = f1;
                c2.innerHTML = f2;
                c3.innerHTML = f3;
                c4.innerHTML = f4;
                c5.innerHTML = f5;
                pou++;
                r++;
            }
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/get_medicines");
    //event.preventDefault();
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send();
}

function Diseases() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            var r = 0;
            var pou = 1;
            var str = xhttp.responseText;
            var row = str.split(",");
            var col = "";
            var length_row = row.length;
            while (r < (length_row - 1)) {
                var row = str.split(",");
                col = "";
                col = row[r].split(" ");
                var f1 = col[0];
                var f2 = col[1];
                var table = document.getElementById("dis");
                var row = table.insertRow(pou);
                var c1 = row.insertCell(0);
                var c2 = row.insertCell(1);
                c1.innerHTML = f1;
                c2.innerHTML = f2;
                pou++;
                r++;
            }
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/get_diseases");
    //event.preventDefault();
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send();
}

function Doctors() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            var r = 0;
            var pou = 1;
            var str = xhttp.responseText;
            var row = str.split(",");
            var col = "";
            var length_row = row.length;
            while (r < (length_row - 1)) {
                var row = str.split(",");
                col = "";
                col = row[r].split(" ");
                var f1 = col[0];
                var f2 = col[1];
                var f3 = col[2];
                var f4 = col[3];
                var f5 = col[4];
                var table = document.getElementById("docs");
                var row = table.insertRow(pou);
                var c1 = row.insertCell(0);
                var c2 = row.insertCell(1);
                var c3 = row.insertCell(2);
                var c4 = row.insertCell(3);
                var c5 = row.insertCell(4);
                c1.innerHTML = f1;
                c2.innerHTML = f2;
                c3.innerHTML = f3;
                c4.innerHTML = f4;
                c5.innerHTML = f5;
                pou++;
                r++;
            }
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/get_doctors");
    //event.preventDefault();
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send();
}

function Employees() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            var r = 0;
            var pou = 1;
            var str = xhttp.responseText;
            var row = str.split(",");
            var col = "";
            var length_row = row.length;
            while (r < (length_row - 1)) {
                var row = str.split(",");
                col = "";
                col = row[r].split(" ");
                console.log(col);
                var f1 = col[0];
                var f2 = col[1];
                var f3 = col[2];
                var f4 = col[3];
                var table = document.getElementById("empl");
                var row = table.insertRow(pou);
                var c1 = row.insertCell(0);
                var c2 = row.insertCell(1);
                var c3 = row.insertCell(2);
                var c4 = row.insertCell(3);
                c1.innerHTML = f1;
                c2.innerHTML = f2;
                c3.innerHTML = f3;
                c4.innerHTML = f4;
                pou++;
                r++;
            }
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/get_employees");
    //event.preventDefault();
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send();
}

function Nurses() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            var r = 0;
            var pou = 1;
            var str = xhttp.responseText;
            var row = str.split(",");
            var col = "";
            var length_row = row.length;
            while (r < (length_row - 1)) {
                var row = str.split(",");
                col = "";
                col = row[r].split(" ");
                console.log(col);
                var f1 = col[0];
                var f2 = col[1];
                var f3 = col[2];
                var f4 = col[3];
                var table = document.getElementById("nur");
                var row = table.insertRow(pou);
                var c1 = row.insertCell(0);
                var c2 = row.insertCell(1);
                var c3 = row.insertCell(2);
                var c4 = row.insertCell(3);
                c1.innerHTML = f1;
                c2.innerHTML = f2;
                c3.innerHTML = f3;
                c4.innerHTML = f4;
                pou++;
                r++;
            }
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/get_nurses");
    //event.preventDefault();
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send();
}


function Patients() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            var r = 0;
            var pou = 1;
            var str = xhttp.responseText;
            var row = str.split(",");
            var col = "";
            var length_row = row.length;
            while (r < (length_row - 1)) {
                var row = str.split(",");
                col = "";
                col = row[r].split(" ");
                var f1 = col[0];
                var f2 = col[1];
                var f3 = col[2];
                var f4 = col[3];
                var f5 = col[4];
                var f6 = col[5];
                var f7 = col[6];
                var f8 = col[7];
                var f9 = col[8];
                var table = document.getElementById("pat");
                var row = table.insertRow(pou);
                var c1 = row.insertCell(0);
                var c2 = row.insertCell(1);
                var c3 = row.insertCell(2);
                var c4 = row.insertCell(3);
                var c5 = row.insertCell(4);
                var c6 = row.insertCell(5);
                var c7 = row.insertCell(6);
                var c8 = row.insertCell(7);
                var c9 = row.insertCell(8);
                c1.innerHTML = f1;
                c2.innerHTML = f2;
                c3.innerHTML = f3;
                c4.innerHTML = f4;
                c5.innerHTML = f5;
                c6.innerHTML = f6;
                c7.innerHTML = f7;
                c8.innerHTML = f8;
                c9.innerHTML = f9;
                pou++;
                r++;
            }
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/get_patients");
    //event.preventDefault();
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send();
}

function PatientsInShift() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            var r = 0;
            var pou = 1;
            var str = xhttp.responseText;
            var row = str.split(",");
            var col = "";
            var length_row = row.length;
            console.log(str);
            while (r < (length_row - 1)) {
                var row = str.split(",");
                col = "";
                col = row[r].split(" ");
                var f1 = col[0];
                var f2 = col[1];
                var f3 = col[2];
                var f4 = col[3];
                var table = document.getElementById("pat");
                var row = table.insertRow(pou);
                var c1 = row.insertCell(0);
                var c2 = row.insertCell(1);
                var c3 = row.insertCell(2);
                var c4 = row.insertCell(3);
                c1.innerHTML = f1;
                c2.innerHTML = f2;
                c3.innerHTML = f3;
                c4.innerHTML = f4;
                pou++;
                r++;
            }
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/get_patients_in_shift");
    //event.preventDefault();
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send();
}

function EmployeesInShift() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            var r = 0;
            var pou = 1;
            var str = xhttp.responseText;
            var row = str.split(",");
            var col = "";
            var length_row = row.length;
            while (r < (length_row - 1)) {
                var row = str.split(",");
                col = "";
                col = row[r].split(" ");
                var f1 = col[0];
                var f2 = col[1];
                var f3 = col[2];
                var f4 = col[3];
                var table = document.getElementById("empl");
                var row = table.insertRow(pou);
                var c1 = row.insertCell(0);
                var c2 = row.insertCell(1);
                var c3 = row.insertCell(2);
                var c4 = row.insertCell(3);
                c1.innerHTML = f1;
                c2.innerHTML = f2;
                c3.innerHTML = f3;
                c4.innerHTML = f4;
                pou++;
                r++;
            }
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/get_employees_in_shift");
    //event.preventDefault();
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send();
}

function NursesInShift() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            var r = 0;
            var pou = 1;
            var str = xhttp.responseText;
            var row = str.split(",");
            var col = "";
            var length_row = row.length;
            while (r < (length_row - 1)) {
                var row = str.split(",");
                col = "";
                col = row[r].split(" ");
                var f1 = col[0];
                var f2 = col[1];
                var f3 = col[2];
                var f4 = col[3];
                var table = document.getElementById("nurs");
                var row = table.insertRow(pou);
                var c1 = row.insertCell(0);
                var c2 = row.insertCell(1);
                var c3 = row.insertCell(2);
                var c4 = row.insertCell(3);
                c1.innerHTML = f1;
                c2.innerHTML = f2;
                c3.innerHTML = f3;
                c4.innerHTML = f4;
                pou++;
                r++;
            }
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/get_nurses_in_shift");
    //event.preventDefault();
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send();
}

function DoctorsInShift() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            var r = 0;
            var pou = 1;
            var str = xhttp.responseText;
            var row = str.split(",");
            var col = "";
            var length_row = row.length;
            while (r < (length_row - 1)) {
                var row = str.split(",");
                col = "";
                col = row[r].split(" ");
                var f1 = col[0];
                var f2 = col[1];
                var f3 = col[2];
                var f4 = col[3];
                var table = document.getElementById("docs");
                var row = table.insertRow(pou);
                var c1 = row.insertCell(0);
                var c2 = row.insertCell(1);
                var c3 = row.insertCell(2);
                var c4 = row.insertCell(3);
                c1.innerHTML = f1;
                c2.innerHTML = f2;
                c3.innerHTML = f3;
                c4.innerHTML = f4;
                pou++;
                r++;
            }
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/get_doctors_in_shift");
    //event.preventDefault();
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send();
}