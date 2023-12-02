const inputTitulo = document.getElementById("titulo");
const textAreaContenido = document.getElementById("contenido");
const btnGuardarPost = document.getElementById("btn-guardar-post");
const anclarPost = document.getElementById("anclar");

const crearPublicacion = (titulo, contenido) => {
    if (isStringEmpty(titulo)) {
        throw Error("Agregue algún título.");
    }

    if (isStringEmpty(contenido)) {
        throw Error("Agregue algún contenido.");
    }

    const post = { "tituloPost": titulo, "contenidoPost": contenido };

    try {
        if (anclarPost !== null && typeof anclarPost !== "undefined" && anclarPost.checked) {
            guardarPublicacionAnclada(post);
        } 
    } catch (err) {
        throw Error(err);
    }
}

const guardarPublicacionAnclada = (post) => {
    $.ajax({
        url: "http://localhost:8080/aplicacion-web/CrearPostAdmin?action=crear-post-anclado",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(post),
        success: function (data) {
        },
        error: function (error) {
            throw Error(error.statusText);
        }
    });
}

const presionarBtnGuardarPublicacion = () => {
    confirmarPublicacion(confirm("¿Seguro que quieres crear la publicación?"));
}

window.onload = () => {
    btnGuardarPost.onclick = presionarBtnGuardarPublicacion;
}