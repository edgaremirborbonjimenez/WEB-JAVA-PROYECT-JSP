
package dao.interfaces;

import domain.Post;
import java.util.List;


public interface PostDAO {
    
    public Post crearPost(Post post);
    
    public Post eliminarPost(Long id);
    
    public Post editarPost(Long id, String titulo, String contenido);
    
    public Post getPostById(Long id);
    
    public List<Post> getAllPosts();
}
