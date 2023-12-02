document.getElementById("chck").onclick = setPasswordVisible;
var psw = document.getElementById("psw");

function setPasswordVisible(){
if(psw.type == "password"){
    psw.type = "text";
}else{
    psw.type = "password";
}
}

function muestraMensaje(){
alert("Iniciaste sesion");
}

function goHome(){
    const xmlhttp = new XMLHttpRequest();
    xmlhttp.open(
            "GET",
            "http://localhost:8080/api/Login",
            true);
    xmlhttp.send();
}