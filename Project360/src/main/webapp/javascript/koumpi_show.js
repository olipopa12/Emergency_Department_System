function pass(e) {
    var x = document.getElementById("password");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}
src = "//netda.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"