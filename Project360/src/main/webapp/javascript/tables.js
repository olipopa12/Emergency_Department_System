/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function Covid() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            var r = 0;
            var pou = 1;
            var str = xhttp.responseText;
            var row = str.split("?");
            var length_row = row.length;
            console.log(str);
            var col = "";
            while (r < (length_row - 1)) {
                var row = str.split("?");
                console.log(row.length);
                if (row.length > 1) {
                    document.getElementById("s").innerHTML = "Covid report  (total: " + row[row.length - 1] + ")";
                } else {
                    document.getElementById("s").innerHTML = "Covid report (total: 0)";
                    i++;
                    continue;
                }
                col = "";
                col = row[r].split(" ");
                var f1 = col[0];
                var f2 = col[1];
                var f3 = col[2];
                var f4 = col[3];
                var table = document.getElementById("st");
                var row1 = table.insertRow(pou);
                var c1 = row1.insertCell(0);
                var c2 = row1.insertCell(1);
                var c3 = row1.insertCell(2);
                var c4 = row1.insertCell(3);
                c1.innerHTML = f1;
                c2.innerHTML = f2;
                c3.innerHTML = f3;
                c4.innerHTML = f4;
                pou++;
                r++;
            }
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/get_covid_statistics");
    //event.preventDefault();
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send();
}

function Visits_Statistics() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            var r = 0;
            var pou = 1;
            var str = xhttp.responseText;
            var row = str.split(",");
            var length_row = row.length;
            console.log(str);
            var col = "";
            while (r < (length_row - 1)) {
                var row = str.split(",");
                if (row2.length > 1) {
                    document.getElementById("s").innerHTML = "Visits today(total: " + row2[row2.length - 1] + ")";
                } else {
                    document.getElementById("s").innerHTML = "Visits today(total:0)";
                    j++;
                    continue;
                }
                col = "";
                col = row[r].split(" ");
                var f1 = col[0];
                var f2 = col[1];
                var f3 = col[2];
                var table = document.getElementById("st");
                var row1 = table.insertRow(pou);
                var c1 = row1.insertCell(0);
                var c2 = row1.insertCell(1);
                var c3 = row1.insertCell(2);
                c1.innerHTML = f1;
                c2.innerHTML = f2;
                c3.innerHTML = f3;
                pou++;
                r++;
            }
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/get_visit_statistics");
    //event.preventDefault();
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send();
}

function Shift() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            var r = 0;
            var pou = 1;
            var str = xhttp.responseText;
            // console.log(str);
            var row = str.split(",");
            var length_row = row.length;
            console.log(length_row);
            while (r < (length_row - 1)) {
                var row = str.split(",");
                // console.log(row);
                var f1 = row[r];
                var table = document.getElementById("s");
                var row1 = table.insertRow(pou);
                var c1 = row1.insertCell(0);
                c1.innerHTML = f1;
                pou++;
                r++;
            }
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/get_shifts");
    //event.preventDefault();
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send();
}
function Report() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            event.preventDefault();
            var i = 0;
            var j = 0;
            var lu = 1;
            var ld = 1;
            var ru = 1;
            var rd = 1;
            var str = xhttp.responseText;
            console.log(str);
            var row = str.split("|");
            /*console.log(row[0]);
             console.log(row[1]);
             console.log(row[2]);
             console.log(row[3]);*/
            var row2 = "";
            var col = "";
            var length_row = row.length;
            //console.log(length_row);
            while (i < (length_row)) {
                j = 0;
                row = str.split("|");
                row2 = row[i].split(",");
                var length_row2 = row2.length;
                /*  console.log(length_row2);
                 console.log(row2[0]);
                 console.log(row2[1]);
                 console.log(row2[2]);
                 console.log(row2[3]);
                 console.log(row2[4]);
                 console.log(row2[5]);
                 console.log(row2[6]);
                 console.log(row2[7]);*/
                while (j < (length_row2 - 1)) {
                    row2 = row[i].split(",");
                    //var row = str.split("|");
                    col = "";
                    col = row2[j].split(" ");
                    if (i === 0) {
                        var f1 = col[0];
                        var f2 = col[1];
                        var f3 = col[2];
                        var f4 = col[3];
                        var f5 = col[4];
                        var f6 = col[5];
                        var table = document.getElementById("lu");
                        var r = table.insertRow(lu);
                        var c1 = r.insertCell(0);
                        var c2 = r.insertCell(1);
                        var c3 = r.insertCell(2);
                        var c4 = r.insertCell(3);
                        var c5 = r.insertCell(4);
                        var c6 = r.insertCell(5);
                        c1.innerHTML = f1;
                        c2.innerHTML = f2;
                        c3.innerHTML = f3;
                        c4.innerHTML = f4;
                        c5.innerHTML = f5;
                        c6.innerHTML = f6;
                        lu++;
                    } else if (i === 1) {
                        var f1 = col[0];
                        var f2 = col[1];
                        var f3 = col[2];
                        var f4 = col[3];
                        var f5 = col[4];
                        var table = document.getElementById("ru");
                        var r = table.insertRow(ru);
                        var c1 = r.insertCell(0);
                        var c2 = r.insertCell(1);
                        var c3 = r.insertCell(2);
                        var c4 = r.insertCell(3);
                        var c5 = r.insertCell(4);
                        c1.innerHTML = f1;
                        c2.innerHTML = f2;
                        c3.innerHTML = f3;
                        c4.innerHTML = f4;
                        c5.innerHTML = f5;
                        ru++;
                    } else if (i === 2) {
                        var f1 = col[0];
                        var f2 = col[1];
                        var f3 = col[2];
                        var f4 = col[3];
                        var f5 = col[4];
                        var f6 = col[5];
                        var f7 = col[6];
                        var f8 = col[7];
                        var table = document.getElementById("ld");
                        var r = table.insertRow(ld);
                        var c1 = r.insertCell(0);
                        var c2 = r.insertCell(1);
                        var c3 = r.insertCell(2);
                        var c4 = r.insertCell(3);
                        var c5 = r.insertCell(4);
                        var c6 = r.insertCell(5);
                        var c7 = r.insertCell(6);
                        var c8 = r.insertCell(7);
                        c1.innerHTML = f1;
                        c2.innerHTML = f2;
                        c3.innerHTML = f3;
                        c4.innerHTML = f4;
                        c5.innerHTML = f5;
                        c6.innerHTML = f6;
                        c7.innerHTML = f7;
                        c8.innerHTML = f8;
                        ld++;
                    } else {
                        var f1 = col[0];
                        var table = document.getElementById("rd");
                        var r = table.insertRow(rd);
                        var c1 = r.insertCell(0);
                        c1.innerHTML = f1;
                        rd++;
                    }
                    j++;
                }
                i++;
            }
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/get_history");
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send();
}

function Statistics() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            event.preventDefault();
            var i = 0;
            var j = 0;
            var lu = 1;
            var ld = 1;
            var ru = 1;
            var rd = 1;
            var str = xhttp.responseText;
            console.log("str: " + str);
            var row = str.split("|");
            /*console.log(row[0]);
             console.log(row[1]);
             console.log(row[2]);
             console.log(row[3]);*/
            var row2 = "";
            var col = "";
            var length_row = row.length;
            console.log("len: " + length_row);
            while (i < (length_row)) {
                j = 0;
                row = str.split("|");
                row2 = row[i].split(",");
                var length_row2 = row2.length;
                console.log(length_row2);
                /*console.log(row2[0]);
                 console.log(row2[1]);
                 console.log(row2[2]);
                 console.log(row2[3]);
                 console.log(row2[4]);
                 console.log(row2[5]);
                 console.log(row2[6]);
                 console.log(row2[7]);*/
                while (j < length_row2 - 1) {
                    row2 = row[i].split(",");
                    //var row = str.split("|");
                    col = "";
                    col = row2[j].split(" ");
                    if (i === 0) {
                        if (row2.length > 1) {
                            document.getElementById("lub").innerHTML = "Examinations from doctors (total: " + row2[row2.length - 1]+")";
                        } else {
                            document.getElementById("lub").innerHTML = "Examinations from doctors (total: 0)";
                            j++;
                            continue;
                        }
                        var f1 = col[0];
                        var f2 = col[1];
                        var f3 = col[2];
                        var f4 = col[3];
                        var f5 = col[4];
                        var table = document.getElementById("lu");
                        var r = table.insertRow(lu);
                        var c1 = r.insertCell(0);
                        var c2 = r.insertCell(1);
                        var c3 = r.insertCell(2);
                        var c4 = r.insertCell(3);
                        var c5 = r.insertCell(4);
                        c1.innerHTML = f1;
                        c2.innerHTML = f2;
                        c3.innerHTML = f3;
                        c4.innerHTML = f4;
                        c5.innerHTML = f5;
                        lu++;
                    } else if (i === 1) {
                        if (row2.length > 1) {
                            document.getElementById("rub").innerHTML = "Examinations from nurses (total: " + row2[row2.length - 1]+")";
                        } else {
                            document.getElementById("rub").innerHTML = "Examinations from nurses (total: 0)";
                            j++;
                            continue;
                        }
                        var f1 = col[0];
                        var f2 = col[1];
                        var f3 = col[2];
                        var f4 = col[3];
                        var table = document.getElementById("ru");
                        var r = table.insertRow(ru);
                        var c1 = r.insertCell(0);
                        var c2 = r.insertCell(1);
                        var c3 = r.insertCell(2);
                        var c4 = r.insertCell(3);
                        c1.innerHTML = f1;
                        c2.innerHTML = f2;
                        c3.innerHTML = f3;
                        c4.innerHTML = f4;
                        ru++;
                    } else if (i === 2) {
                        if (row2.length > 1) {
                            document.getElementById("ldb").innerHTML = "Re-examinations from doctors (total: " + row2[row2.length - 1]+")";
                        } else {
                            document.getElementById("ldb").innerHTML = "Re-examinations from doctors(total:0)";
                            j++;
                            continue;
                        }
                        var f1 = col[0];
                        var f2 = col[1];
                        var f3 = col[2];
                        var f4 = col[3];
                        var f5 = col[4];
                        var f6 = col[5];
                        var table = document.getElementById("ld");
                        var r = table.insertRow(ld);
                        var c1 = r.insertCell(0);
                        var c2 = r.insertCell(1);
                        var c3 = r.insertCell(2);
                        var c4 = r.insertCell(3);
                        var c5 = r.insertCell(4);
                        var c6 = r.insertCell(5);
                        c1.innerHTML = f1;
                        c2.innerHTML = f2;
                        c3.innerHTML = f3;
                        c4.innerHTML = f4;
                        c5.innerHTML = f5;
                        c6.innerHTML = f6;
                        ld++;
                    } else {
                        if (row2.length > 1) {
                            document.getElementById("rdb").innerHTML = "Visits (total: " + row2[row2.length - 1]+")";
                        } else {
                            document.getElementById("rdb").innerHTML = "Visits (total: 0)";
                            j++;
                            continue;
                        }
                        var f1 = col[0];
                        var f2 = col[1];
                        var f3 = col[2];
                        var table = document.getElementById("rd");
                        var r = table.insertRow(rd);
                        var c1 = r.insertCell(0);
                        var c2 = r.insertCell(1);
                        var c3 = r.insertCell(2);
                        c1.innerHTML = f1;
                        c2.innerHTML = f2;
                        c3.innerHTML = f3;
                        rd++;
                    }
                    j++;
                }
                console.log("i= " + i);
                i++;
            }
        }
    };
    xhttp.open("POST", "http://localhost:8080/Project360/get_statistics");
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhttp.send();
}

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
            console.log(str);
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
                var row1 = table.insertRow(pou);
                var c1 = row1.insertCell(0);
                var c2 = row1.insertCell(1);
                var c3 = row1.insertCell(2);
                var c4 = row1.insertCell(3);
                var c5 = row1.insertCell(4);
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
            console.log(str);
            var length_row = row.length;
            while (r < (length_row - 1)) {
                var row = str.split(",");
                col = "";
                col = row[r].split(" ");
                //console.log(col);
                var f1 = col[0];
                var f2 = col[1];
                var f3 = col[2];
                var f4 = col[3];
                var table = document.getElementById("empl");
                var row1 = table.insertRow(pou);
                var c1 = row1.insertCell(0);
                var c2 = row1.insertCell(1);
                var c3 = row1.insertCell(2);
                var c4 = row1.insertCell(3);
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
            console.log(str);
            var length_row = row.length;
            while (r < (length_row - 1)) {
                var row = str.split(",");
                col = "";
                col = row[r].split(" ");
                //console.log(col);
                var f1 = col[0];
                var f2 = col[1];
                var f3 = col[2];
                var f4 = col[3];
                var table = document.getElementById("nur");
                var row1 = table.insertRow(pou);
                var c1 = row1.insertCell(0);
                var c2 = row1.insertCell(1);
                var c3 = row1.insertCell(2);
                var c4 = row1.insertCell(3);
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
                var row1 = table.insertRow(pou);
                var c1 = row1.insertCell(0);
                var c2 = row1.insertCell(1);
                var c3 = row1.insertCell(2);
                var c4 = row1.insertCell(3);
                var c5 = row1.insertCell(4);
                var c6 = row1.insertCell(5);
                var c7 = row1.insertCell(6);
                var c8 = row1.insertCell(7);
                var c9 = row1.insertCell(8);
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
            //console.log(str);
            while (r < (length_row - 1)) {
                var row = str.split(",");
                col = "";
                col = row[r].split(" ");
                var f1 = col[0];
                var f2 = col[1];
                var f3 = col[2];
                var f4 = col[3];
                var table = document.getElementById("pat");
                var row1 = table.insertRow(pou);
                var c1 = row1.insertCell(0);
                var c2 = row1.insertCell(1);
                var c3 = row1.insertCell(2);
                var c4 = row1.insertCell(3);
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
                var row1 = table.insertRow(pou);
                var c1 = row1.insertCell(0);
                var c2 = row1.insertCell(1);
                var c3 = row1.insertCell(2);
                var c4 = row1.insertCell(3);
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
                var row1 = table.insertRow(pou);
                var c1 = row1.insertCell(0);
                var c2 = row1.insertCell(1);
                var c3 = row1.insertCell(2);
                var c4 = row1.insertCell(3);
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
                var row1 = table.insertRow(pou);
                var c1 = row1.insertCell(0);
                var c2 = row1.insertCell(1);
                var c3 = row1.insertCell(2);
                var c4 = row1.insertCell(3);
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
