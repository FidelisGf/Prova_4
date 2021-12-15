package Controller;

import DAO.BibliotecaDAO;
import Model.Biblioteca;
import Model.Livro;

import java.util.List;

public class BibliotecaController {
    BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
    public void cadastrarBiblioteca(Biblioteca biblioteca){
        bibliotecaDAO.cadastrarBiblioteca(biblioteca);
    }
    public List<Livro> listarLivrosPorBiblioteca(long idBiblioteca){
        return bibliotecaDAO.listarLivrosPorBiblioteca(idBiblioteca);
    }

    public List<Biblioteca> listarBibliotecas(){
        return bibliotecaDAO.listarBibliotecas();
    }
}
