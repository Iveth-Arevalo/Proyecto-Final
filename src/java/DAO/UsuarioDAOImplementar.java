package DAO;

import Factory.ConexionBD;
import Factory.FactoryConexionBD;
import Model.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDAOImplementar implements UsuarioDAO{
    //objeto conexion
    ConexionBD conn;

    //contructor sin parametros
    public UsuarioDAOImplementar() {
        
    }
    

    @Override
    public List<Usuario> Listar() {
        this.conn = FactoryConexionBD.open(FactoryConexionBD.MySql);
        StringBuilder misql = new StringBuilder();
        misql.append("select * from tb_usuario");
        List<Usuario> lista = new ArrayList<Usuario>();
        try {
            ResultSet resultadoSql = this.conn.consultaSql(misql.toString());
            while (resultadoSql.next()) {                
                Usuario usuario = new Usuario();
                usuario.setId(resultadoSql.getInt("id"));
                usuario.setNombre(resultadoSql.getString("nombre"));
                usuario.setApellido(resultadoSql.getString("apellido"));
                usuario.setCorreo(resultadoSql.getString("correo"));
                usuario.setUsuario(resultadoSql.getString("usuario"));
                usuario.setClave(resultadoSql.getString("clave"));
                usuario.setTipo(resultadoSql.getInt("tipo"));
                usuario.setEstado(resultadoSql.getInt("estado"));
                usuario.setPregunta(resultadoSql.getString("pregunta"));
                usuario.setRepuesta(resultadoSql.getString("respuesta"));
                usuario.setFecha_registro(resultadoSql.getDate("fecha_registro"));
                lista.add(usuario);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            this.conn.cerrarConexion();
        }
        return lista;
    }

    @Override
    public List<Usuario> Listar2() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Usuario editarUsu(int id_usu_edit) {
        this.conn = FactoryConexionBD.open(FactoryConexionBD.MySql);
        Usuario usuario = new Usuario();
        StringBuilder miSql = new StringBuilder();
        
        miSql.append("select * from tb_usuario where id =").append(id_usu_edit);
        try {
            ResultSet resultadoSql = this.conn.consultaSql(miSql.toString());
            while (resultadoSql.next()) {                             
                usuario.setId(resultadoSql.getInt("id"));
                usuario.setNombre(resultadoSql.getString("nombre"));
                usuario.setApellido(resultadoSql.getString("apellido"));
                usuario.setCorreo(resultadoSql.getString("correo"));
                usuario.setUsuario(resultadoSql.getString("usuario"));
                usuario.setClave(resultadoSql.getString("clave"));
                usuario.setTipo(resultadoSql.getInt("tipo"));
                usuario.setEstado(resultadoSql.getInt("estado"));
                usuario.setPregunta(resultadoSql.getString("pregunta"));
                usuario.setRepuesta(resultadoSql.getString("respuesta"));
                usuario.setFecha_registro(resultadoSql.getDate("fecha_registro"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            this.conn.cerrarConexion();
        }
        return usuario;
    }

    @Override
    public boolean guardarUsu(Usuario usuario) {
        this.conn = FactoryConexionBD.open(FactoryConexionBD.MySql);
        boolean guardar = false;
        try {
            if (usuario.getId() == 0) {
                StringBuilder misql = new StringBuilder();
                misql.append("insert into tb_usuario(nombre, apellido, correo, usuario, clave, tipo, estado, pregunta, respuesta) values('");
                misql.append(usuario.getNombre() + 
                                "', '").append(usuario.getApellido() +
                                "', '").append(usuario.getCorreo() + 
                                "', '").append(usuario.getUsuario() + 
                                "', '").append(usuario.getClave() +
                                "', '").append(usuario.getTipo() +
                                "', '").append(usuario.getEstado() +
                                "', '").append(usuario.getPregunta()+
                                "', '").append(usuario.getRepuesta());
                misql.append("');");
                this.conn.ejecutarSql(misql.toString());
            } else if(usuario.getId() > 0){
                StringBuilder miSql = new StringBuilder();
                miSql.append("update tb_usuario set id ='").append(usuario.getId());
                miSql.append("', nombre = '").append(usuario.getNombre());
                miSql.append("', apellido = '").append(usuario.getApellido());
                miSql.append("', correo = '").append(usuario.getCorreo());
                miSql.append("', usuario = '").append(usuario.getUsuario());
                miSql.append("', clave = '").append(usuario.getClave());
                miSql.append("', tipo = '").append(usuario.getTipo());
                miSql.append("', estado = '").append(usuario.getEstado());
                miSql.append("', pregunta = '").append(usuario.getPregunta());
                miSql.append("', respuesta = '").append(usuario.getRepuesta());
                miSql.append("' where id = ").append(usuario.getId()).append(";");
                this.conn.ejecutarSql(miSql.toString());
            }
            guardar = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            this.conn.cerrarConexion();
        }
        return guardar;
    }

    @Override
    public boolean borrarUsu(int id_usu_borrar) {
        this.conn = FactoryConexionBD.open(FactoryConexionBD.MySql);
        boolean borrar = false;
        try {
            StringBuilder miSql = new StringBuilder();
            miSql.append("delete from tb_usuario where id =").append(id_usu_borrar);
            this.conn.ejecutarSql(miSql.toString());
            borrar = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            this.conn.cerrarConexion();
        }
        return borrar;
    }

    @Override
    public ArrayList<Usuario> startSesion(String user, String clave) {
       this.conn = FactoryConexionBD.open(FactoryConexionBD.MySql);
        StringBuilder miSQL = new StringBuilder();
        miSQL.append("SELECT * FROM tb_usuario WHERE correo = '").append(user);
        miSQL.append("' and clave = '").append(clave);
        miSQL.append("';");          
         //ArrayList<Usuario> user = new ArrayList(); // crear el array de almacenamiento en cada fial los registros encontrados
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        try{
        //Se crea el objeto ResultSet implementando el método (consultaSQL) creado para la consulta.
            ResultSet resultadoSQL = this.conn.consultaSql(miSQL.toString());
            while(resultadoSQL.next()){
                Usuario usuario = new Usuario();
                //Asignar cada campo consultado al atributo en la clase.
                usuario.setId(resultadoSQL.getInt("id"));
                usuario.setNombre(resultadoSQL.getString("nombre"));
                usuario.setApellido(resultadoSQL.getString("apellido"));
                usuario.setCorreo(resultadoSQL.getString("correo"));
                usuario.setUsuario(resultadoSQL.getString("usuario"));
                usuario.setClave(resultadoSQL.getString("clave"));
                usuario.setTipo(resultadoSQL.getInt("tipo"));
                usuario.setEstado(resultadoSQL.getInt("estado"));
                usuario.setPregunta(resultadoSQL.getString("pregunta"));
                usuario.setRepuesta(resultadoSQL.getString("respuesta"));
                //usuario.setFecha_registro(resultadoSQL.getDate("fecha_registro"));
                lista.add(usuario);                
            }
        }catch(Exception ex){
            System.out.println("error mio "+ ex.getMessage());
        }
        
        return lista;
    }
   
        //Método creado para probar de inmediato el método startSesion()
    public static void main(String[] args){
        //UsuarioDaoImplementar p = new UsuarioDaoImplementar();  
        UsuarioDAO p = new UsuarioDAOImplementar();
       
        ArrayList<Usuario> user = new ArrayList();
        user = p.startSesion("wendicastro425@gmail.com", "1234");
    
        int size = user.size();

          for (int i = 0; i < user.size(); i++) {
              System.out.println(user.get(i).getUsuario() + "\t" + user.get(i).getClave() + "\t" + user.get(i).getCorreo() + "\t" + user.get(0).getNombre() + "\t" + 
                      user.get(0).getTipo());
              System.out.println("El valor máximo de i es: " + i);
            } 
      }
    
    
}
