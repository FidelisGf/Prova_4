package DAO;

import ConnectionFactory.ConnectionFactory;
import Model.Biblioteca;
import Model.Genero;
import Model.Livro;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    private Connection connection;

    public LivroDAO() {
        this.connection  = new ConnectionFactory().getConnection();
    }

    public void criarTabelaLivros(){
        try {
            String sql = "CREATE TABLE IF not exists Livros " +
                    "(idLivro BIGINT not NULL AUTO_INCREMENT, " +
                    " PRIMARY KEY (idLivro) , " +
                    " nomeLivro VARCHAR(255), " +
                    " idGenero BIGINT not NULL , " +
                    " idBiblioteca BIGINT not NULL , " +
                    "FOREIGN KEY (idBiblioteca) REFERENCES  Bibliotecas(idBiblioteca)ON DELETE CASCADE , " +
                    " DATA TIMESTAMP, " +
                    " FOREIGN KEY (idGenero) REFERENCES Generos(idGenero)ON DELETE CASCADE)";
            Statement statement = connection.createStatement();
            statement.execute(sql);
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }
    public void cadastrarLivro(Livro livro){
        try {
            String sql = "INSERT INTO Livros (nomeLivro,idGenero,idBiblioteca) VALUES (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, livro.getNomeLivro());
            statement.setLong(2, livro.getGenero().getIdGenero());
            statement.setLong(3, livro.getBiblioteca().getIdBiblioteca());
            statement.execute();
            statement.close();
            JOptionPane.showMessageDialog(null, "Livro criado com sucesso ! ");
        }catch (SQLException e){
        }
    }
    public List<Livro> listarLivros(){
        try {
            String sql = "SELECT * FROM Livros";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            ResultSet resultSet = statement.executeQuery();
            return listar(resultSet);
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }
    public List<Livro> listar(ResultSet resultSet){
        List<Livro> list = new ArrayList<>();
        Livro livro = null;
        Biblioteca biblioteca;
        Genero genero;
        try {
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
    public Livro listarLivroById(Long id){
        Livro livro = null;
        Biblioteca biblioteca;
        Genero genero;
        try {
            String sql = "SELECT * FROM Livros WHERE idLivro = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.execute();
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                genero = new Genero();
                livro = new Livro();
                biblioteca = new Biblioteca();
                biblioteca.setIdBiblioteca(resultSet.getLong("idBiblioteca"));
                genero.setIdGenero(resultSet.getLong("idGenero"));
                livro.setIdLivro(resultSet.getLong("idLivro"));
                livro.setNomeLivro(resultSet.getString("nomeLivro"));
                livro.setBiblioteca(biblioteca);
                livro.setGenero(genero);
                return livro;
            }
            return livro;
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }
}
