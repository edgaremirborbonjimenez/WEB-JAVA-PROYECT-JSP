/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
var xmlhttp =  new XMLHttpRequest(); 
xmlhttp.open("GET","Inicio",true);
xmlhttp.onreadystatechange = function (){
    if(xmlhttp.readyState === 4 && xmlhttp.status === 200){
        var j = (JSON.parse(xmlhttp.responseText));
        alert(j[1]);
        document.getElementById("autor").innerHTML = j;
        document.getElementById("texto").innerHTML = j;
        
      }
};
xmlhttp.send();

