
package DAO;


import Model.Usuario;
import java.util.ArrayList;
import java.util.List;

public interface UsuarioDAO {
    //metodos abstractos
    public List<Usuario> Listar();
    public List<Usuario> Listar2();
    public Usuario editarUsu(int id_usu_edit);
    public boolean guardarUsu(Usuario usuario);
    public boolean borrarUsu(int id_usu_borrar);
    
       public ArrayList<Usuario> startSesion(String user, String clave);
}
