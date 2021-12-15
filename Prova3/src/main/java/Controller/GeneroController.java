package Controller;

import DAO.GeneroDAO;
import Model.Genero;
import Model.Livro;

import java.util.List;

public class GeneroController {
    GeneroDAO generoDAO = new GeneroDAO();
    public void cadastrarGenero(Genero genero){
        generoDAO.cadastrarGenero(genero);
    }
    public List<Genero> listarGeneros(){
        return generoDAO.listarGeneros();
    }
    public void editarGenero(Genero genero){
        generoDAO.editarGenero(genero);
    }
    public List<Livro> listarLivroPorGenero(long idGenero){
        return generoDAO.listarLivrosPorGenero(idGenero);
    }
}
