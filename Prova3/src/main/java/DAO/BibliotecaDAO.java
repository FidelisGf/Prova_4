package DAO;
import ConnectionFactory.*;
import Model.Biblioteca;
import Model.Genero;
import Model.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaDAO {
    private Connection connection;

    public BibliotecaDAO() {
        this.connection  = new ConnectionFactory().getConnection();
    }

    public void criarTabelaBiblioteca(){
        try {
            String sql = "CREATE TABLE IF not exists Bibliotecas " +
                    "(idBiblioteca BIGINT not NULL AUTO_INCREMENT, " +
                    " PRIMARY KEY (idBiblioteca) , " +
                    " nomeBiblioteca VARCHAR(255), " +
                    " DATA TIMESTAMP)";
            Statement statement = connection.createStatement();
            statement.execute(sql);
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }
    public void cadastrarBiblioteca(Biblioteca biblioteca){
        try {
            String sql = "INSERT INTO Bibliotecas (nomeBiblioteca) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, biblioteca.getNomeBiblioteca());
            statement.execute();
            statement.close();
        }catch (SQLException e){
            throw new RuntimeException();

        }
    }
    public List<Livro> listarLivrosPorBiblioteca(long idBiblioteca){
        List<Livro> list = new ArrayList<>();
        Biblioteca biblioteca;
        Genero genero;
        Livro livro = null;
        try {
            String sql = "SELECT * FROM Livros WHERE idBiblioteca = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, idBiblioteca);
            statement.execute();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                genero = new Genero();
                livro = new Livro();
                biblioteca = new Biblioteca();
                biblioteca.setIdBiblioteca(resultSet.getLong("idBiblioteca"));
                genero.setIdGenero(resultSet.getLong("idGenero"));
                livro.setNomeLivro(resultSet.getString("nomeLivro"));
                livro.setIdLivro(resultSet.getLong("idLivro"));
                livro.setBiblioteca(biblioteca);
                livro.setGenero(genero);
                list.add(livro);
            }
            return list;
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }
    public List<Biblioteca> listarBibliotecas(){
        List<Biblioteca> bibliotecas = new ArrayList<>();
        Biblioteca biblioteca = null;
        try {
            String sql = "SELECT * FROM Bibliotecas";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                biblioteca = new Biblioteca();
                biblioteca.setNomeBiblioteca(resultSet.getString("nomeBiblioteca"));
                biblioteca.setIdBiblioteca(resultSet.getLong("idBiblioteca"));
                bibliotecas.add(biblioteca);
            }
            return bibliotecas;
        }catch (SQLException e){
            throw new RuntimeException();
        }

    }

}
