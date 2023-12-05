
package dao.interfaces;

import domain.Anclado;
import domain.Comun;
import domain.Post;
import java.util.List;


public interface PostDAO {
    
    public Comun crearPostComun(Comun post);
    
    public Anclado crearPostAnclado(Anclado anclado);
    
    public Post eliminarPost(Long id);
    
    public Post editarPost(Long id, String titulo, String contenido);
    
    public Comun getPostComunById(Long id);
    
    public List<Post> getAllPosts();
    
    public List<Anclado> getAllAncladoPosts();
    
    public List<Comun> getAllComunPosts();
}
