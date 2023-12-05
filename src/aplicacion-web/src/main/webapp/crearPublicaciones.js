document.getElementById("myForm").addEventListener('submit',function(event) {
  event.preventDefault();
  
   const titulo = document.getElementById("titulo").value;
   const contenido = document.getElementById("contenido").value;

    const postObj = {
        titulo : titulo,
        contenido: contenido
    }
            console.log(titulo); 
            console.log(contenido); 


    let post = JSON.stringify(postObj)
    const url = "http://localhost:8080/aplicacion-web/CrearPostAdmin"
    /*
        fetch("CrearPostAdmin",{
        method: 'POST',
        headers: { 'Content-Type': 'application/json'},
        body: post});
    */
    
    let xhr = new XMLHttpRequest()
    xhr.open('POST', url, true)
    xhr.setRequestHeader('Content-type', 'application/json; charset=UTF-8')
    xhr.send(post);
    xhr.onload = function () {
    if(xhr.status === 201) {
        console.log("Post successfully created!") 
    }
  }
  });