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
alert("Iniciaste seison");
}