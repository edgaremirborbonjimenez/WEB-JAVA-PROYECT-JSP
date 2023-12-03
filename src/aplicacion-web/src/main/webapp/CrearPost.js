
document.getElementById("btn-guardar-post").addEventListener("click", function(event) {
  event.preventDefault();
  
  var form = document.getElementById("myForm");
  var formData = new FormData(form);
  formData.append("correo","correo@ejemplo.com");
  formData.append("pass","123456789");
  
  var usp=new URLSearchParams(formData);
  
  console.log([...formData]);
  
  usp.forEach(function(valor, clave){
        console.log(clave + ": " + valor);
    });
   
    fetch('CrearPostAdmin', {
        method: 'POST',
        body: usp
        })
        .then(response => response)
        .then(data => console.log(data))
        .catch(error => console.error(error));
    
    });
