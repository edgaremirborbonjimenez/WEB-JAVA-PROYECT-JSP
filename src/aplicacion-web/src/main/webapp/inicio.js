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
    //console.log(data);
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
                basura.src = 'https://cdn3.iconfinder.com/data/icons/user-interface-169/32/trash-512.png';
                nuevaPublicacion.appendChild(basura);
                
            nuevaPublicacion.innerHTML += '<h5>'+valor.titulo+'</h5>';
            nuevaPublicacion.innerHTML += '<p>'+valor.conteindo+'</p>';
            nuevaPublicacion.innerHTML += '<p>'+"comentarios"+'</p>';
            
            
            var comentarios = document.createElement('div');
                comentarios.classList.add('coms');
                comentarios.id = 'coms'+valor.id;
            nuevaPublicacion.appendChild(comentarios);
                
            var comentar = document.createElement('div');
                comentar.classList.add('in');
                var inputcom = document.createElement('input');
                    inputcom.id='input'+valor.id;
                    inputcom.setAttribute('type', 'text');
                    inputcom.setAttribute('placeholder', 'Escribele un comentario:');
                comentar.appendChild(inputcom);
                var botoncomentar = document.createElement('button');
                    botoncomentar.setAttribute('type', 'button');
                    botoncomentar.innerText="Enviar";
                comentar.appendChild(botoncomentar);
            nuevaPublicacion.appendChild(comentar);
                
            var puntoDeAnclaje = document.getElementById('publicaciones');
            puntoDeAnclaje.appendChild(nuevaPublicacion);  
             
        }
    }
    })
.catch(error => {
  
});
