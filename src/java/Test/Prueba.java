package Test;

import DAO.CategoriaDAO;
import DAO.CategoriaDAOImplementar;
import Model.Categoria;
import java.util.List;


public class Prueba {
    
    public static void main(String[] args) {
        Prueba evaluar = new Prueba();
        evaluar.listarCategorias();
      
    }
    
    public void borrar(){
        CategoriaDAO categoria = new CategoriaDAOImplementar();
        categoria.borrarCat(2);//elimina la categoria 2
    }
    
    public void guardar(){
        CategoriaDAO categoria = new CategoriaDAOImplementar();
        Categoria guarda_cat = new Categoria();
        guarda_cat.setNom_categoria("Bebidas Naturales");//nueva categoria a guardar
        guarda_cat.setId_categoria(5);//modifica categoria anterio registrada con el id 5
        guarda_cat.setEstado_categoria(1);//estado
        categoria.guardarCat(guarda_cat);
    }
    
    public void editarCategoria(){
        CategoriaDAO categoria = new CategoriaDAOImplementar();
        Categoria cat_edit = categoria.editarCat(1);//se pasa el valor id_categoria = 1
        System.out.println("CATEGORIA A EDITAR");
        System.out.println("ID: " + cat_edit.getId_categoria() + 
                           " Nombre: " + cat_edit.getNom_categoria() +
                           " Estado: " + cat_edit.getEstado_categoria());
    }
    
    public void listarCategorias(){
        CategoriaDAO categoriaDAO = new CategoriaDAOImplementar();
        List<Categoria> listar = categoriaDAO.Listar();
        System.out.println("LISTADO DE CATEGORIAS");
        for(Categoria categoriaListar : listar){
            System.out.println("ID: " + categoriaListar.getId_categoria() +
                               " Nombre: " + categoriaListar.getNom_categoria() +
                                " Estado: " + categoriaListar.getEstado_categoria());
        }
    }
}
