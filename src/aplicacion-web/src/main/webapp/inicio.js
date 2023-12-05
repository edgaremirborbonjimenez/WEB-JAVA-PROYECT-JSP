/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
fetch('Inicio', {
  method: 'GET',
  headers: {    'Content-Type': 'application/json'  }
})
.then(res => res.json())
.then(data => {
    console.log(data);
            mostrarPublicaciones(data);
    })
.catch(error => {
});
document.getElementById("publicar").addEventListener("click", function(event) {
   location.href="crear-publicacion.jsp"; 
});

function addGlobalListener(type,selector,callback){
    document.addEventListener(type , e=> {
        if(e.target.matches(selector))callback(e);
    });
}
//borra post
addGlobalListener("click","img",e =>{
    console.log(e.target.parentNode.id);
    const data = {id: e.target.parentNode.id, borrar:"post"};
    fetch("Inicio",{
        method: 'POST',
        headers: { 'Content-Type': 'application/json'},
        body: JSON.stringify(data)})
    .then(res => res.json())
    .then(data => {
        
        console.log(data);
        document.getElementById(e.target.parentNode.id).remove();
        
     })
     .catch(error => {
         
     });
});
//comentar
addGlobalListener("click","button",e =>{
    e.preventDefault();    
    var postid=e.target.parentNode.parentNode.id;
    var input=document.getElementById("input"+postid);
    
    console.log(postid);
    console.log(input.value);
    const data = {id: postid, comentario: input.value};
    fetch("Inicio",{
        method: 'POST',
        headers: { 'Content-Type': 'application/json'},
        body: JSON.stringify(data)})
    .then(res => res.json())
    .then(data => {
        document.getElementById("input"+postid).value = '';
        console.log(data);
        mostrarPublicaciones(data);
     })
     .catch(error => {
         
     });
});
function getComentarios(idPost,comentarios){
     const data = {idPost: idPost};
    fetch("Inicio",{
        method: 'POST',
        headers: { 'Content-Type': 'application/json'},
        body: JSON.stringify(data)})
    .then(res => res.json())
    .then(data => {
        //console.log(data);

        for (var key in data) {
            if (data.hasOwnProperty(key)) {
                var valor = data[key];
                    console.log(valor);
                var pcom = document.createElement('p');
                pcom.id=valor.postId+"-"+valor.id;
                pcom.innerText+=valor.normal+": "+valor.contenido;
                comentarios.appendChild(pcom);
            }
            
        }
        mostrarPublicaciones(data);
     })
     .catch(error => {
         
     });
}
function mostrarPublicaciones(data){
    
    for (var key in data) {
        if (data.hasOwnProperty(key)) {
            var valor = data[key];

            var nuevaPublicacion = document.createElement('div');
            nuevaPublicacion.classList.add('publi');
            nuevaPublicacion.id = valor.id;
            nuevaPublicacion.innerHTML += '<h3>'+'De: '+valor.nombre+'</h3>';
            
            var basura = document.createElement('img');
                basura.classList.add('basura');
                basura.id='b'+valor.id;
                basura.setAttribute('alt', 'b'+valor.id);
                basura.src = 'https://cdn3.iconfinder.com/data/icons/user-interface-169/32/trash-512.png';
                nuevaPublicacion.appendChild(basura);
                
            nuevaPublicacion.innerHTML += '<h5>'+valor.titulo+'</h5>';
            nuevaPublicacion.innerHTML += '<p>'+valor.conteindo+'</p>';
            nuevaPublicacion.innerHTML += '<p>'+"comentarios"+'</p>';
            
            var comentarios = document.createElement('div');
                comentarios.classList.add('coms');
                comentarios.id = 'coms'+valor.id;
                getComentarios(valor.id,comentarios);
            nuevaPublicacion.appendChild(comentarios);
                
            var comentar = document.createElement('form');
                comentar.classList.add('in');
                comentar.setAttribute('method', 'POST');
                comentar.setAttribute('action', 'Inicio');
                var inputcom = document.createElement('input');
                    inputcom.id='input'+valor.id;
                    inputcom.setAttribute('type', 'text');
                    inputcom.setAttribute('placeholder', 'Escribele un comentario:');
                comentar.appendChild(inputcom);
                var botoncomentar = document.createElement('button');
                    botoncomentar.setAttribute('type', 'submit');
                    botoncomentar.innerText="Enviar";
                comentar.appendChild(botoncomentar);
            nuevaPublicacion.appendChild(comentar);
                
            var puntoDeAnclaje = document.getElementById('publicaciones');
            puntoDeAnclaje.appendChild(nuevaPublicacion);
        }
    }
}