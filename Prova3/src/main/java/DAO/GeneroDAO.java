package DAO;

import ConnectionFactory.ConnectionFactory;
import Model.Biblioteca;
import Model.Genero;
import Model.Livro;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GeneroDAO {
    private Connection connection;

    public GeneroDAO() {
        this.connection  = new ConnectionFactory().getConnection();
    }

    public void criarTabelaGenero(){
        try {
            String sql = "CREATE TABLE IF not exists Generos " +
                    "(idGenero BIGINT not NULL AUTO_INCREMENT, " +
                    " PRIMARY KEY (idGenero) , " +
                    " nomeGenero VARCHAR(255), " +
                    " DATA TIMESTAMP) ";
            Statement statement = connection.createStatement();
            statement.execute(sql);
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }
    public void cadastrarGenero(Genero genero){
        try {
            String sql = "INSERT INTO Generos (nomeGenero) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, genero.getNomeGenero());
            statement.execute();
            statement.close();
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }
    public List<Genero> listarGeneros(){
        Genero genero;
        List<Genero> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Generos";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                genero = new Genero();
                genero.setIdGenero(resultSet.getInt("idGenero"));
                genero.setNomeGenero(resultSet.getString("nomeGenero"));
                list.add(genero);
            }
            return list;
        }catch (SQLException e){
            throw new RuntimeException();

        }
    }
    public void editarGenero(Genero genero){
        try {
            String sql = "UPDATE Generos SET nomeGenero = ? WHERE idGenero = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, genero.getNomeGenero());
            statement.setInt(2, (int) genero.getIdGenero());
            statement.executeUpdate();
            statement.close();
            JOptionPane.showMessageDialog(null, "Editado com sucesso");
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }
    public List<Livro> listarLivrosPorGenero(long idGenero){
        List<Livro> list = new ArrayList<>();
        Biblioteca biblioteca;
        Genero genero;
        Livro livro = null;
        try {
            String sql = "SELECT * FROM Livros WHERE idGenero = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, idGenero);
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
}
