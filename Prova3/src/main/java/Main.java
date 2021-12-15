import DAO.BibliotecaDAO;
import DAO.GeneroDAO;
import DAO.LivroDAO;
import View.BibliotecaView;
import View.GeneroView;
import View.LivroView;
import View.Menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
       criarTabelas();
        Menu menu = new Menu();
        menu.menu();
    }
    public static void criarTabelas(){
        BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
        bibliotecaDAO.criarTabelaBiblioteca();
        GeneroDAO generoDAO = new GeneroDAO();
        generoDAO.criarTabelaGenero();
        LivroDAO livroDAO = new LivroDAO();
        livroDAO.criarTabelaLivros();
    }
}
