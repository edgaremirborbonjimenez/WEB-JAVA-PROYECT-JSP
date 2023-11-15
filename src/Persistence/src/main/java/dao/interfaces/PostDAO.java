
package dao.interfaces;

import domain.Post;


public interface PostDAO {
    
    public Post crearPost(Post post);
    
    public Post eliminarPost(Long id);
    
    public Post editarPost(String titulo, String contenido);
}
