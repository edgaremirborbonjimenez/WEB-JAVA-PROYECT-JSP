   document.getElementById("myForm").addEventListener('submit',function(event) {
  event.preventDefault();
  
   const titulo = document.getElementById("titulo").value;
   const contenido = document.getElementById("contenido").value;
      const isAnclado = document.getElementById("isAnclado").checked;

    const postObj = {};
    /*let post = JSON.stringify(postObj);
       */
      const url = "http://localhost:8080/aplicacion-web/CrearPostAdmin";
    if (isAnclado) {
        postObj = {
        titulo : titulo,
        contenido: contenido,
        isAnclado: true
    }
            fetch("CrearPostAdmin",{
        method: 'POST',
        headers: { 'Content-Type': 'application/json'},
        body: JSON.stringify(postObj)});
    
    
}else{
                postObj = {
        titulo : titulo,
        contenido: contenido,
        isAnclado: false
    }
    
    let xhr = new XMLHttpRequest();
    xhr.open('POST', url, true)
    xhr.setRequestHeader('Content-type', 'application/json; charset=UTF-8')
    xhr.send(JSON.stringify(postObj));
    xhr.onload = function () {
    if(xhr.status === 201) {
        console.log("Post successfully created!") 
    }
  }
    }


    /*
        fetch("CrearPostAdmin",{
        method: 'POST',
        headers: { 'Content-Type': 'application/json'},
        body: post});
    */
    

  });