
package dao.interfaces;

import domain.Comentario;


public interface ComentarioDAO {
    
    public Comentario crearComentario(Comentario comentario);
    
    public Comentario eliminarComentario(Long id);
}
