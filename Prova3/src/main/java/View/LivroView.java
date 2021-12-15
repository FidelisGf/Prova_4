package View;

import Controller.BibliotecaController;
import Controller.GeneroController;
import Controller.LivroController;
import Model.Biblioteca;
import Model.Genero;
import Model.Livro;

import javax.swing.*;
import java.util.List;
import java.util.StringTokenizer;

public class LivroView {
    GeneroController generoController = new GeneroController();
    GeneroView generoView = new GeneroView();
    LivroController livroController = new LivroController();
    BibliotecaController bibliotecaController = new BibliotecaController();
    BibliotecaView bibliotecaView = new BibliotecaView();
    public void cadastrarLivro(){
        Livro livro = new Livro();
        Genero genero = new Genero();
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setIdBiblioteca(bibliotecaController.listarBibliotecas().get(bibliotecaView.escolherBiblioteca()).getIdBiblioteca());
        genero.setIdGenero(generoController.listarGeneros().get(generoView.escolherGenero()).getIdGenero());
        livro.setNomeLivro(JOptionPane.showInputDialog(null, "Insira o nome do Livro : "));
        livro.setGenero(genero);
        livro.setBiblioteca(biblioteca);
        if(livro.getNomeLivro() != null){
            livroController.cadastrarLivro(livro);
        }
    }
    public void listarLivroById(){
        Long id = livroController.listarLivros().get(escolherLivro()).getIdLivro();
        System.out.println(id);
        Livro livro = livroController.listarLivroById(id);
        JOptionPane.showMessageDialog(null, " Livro com nome : " + livro.getNomeLivro() + " Registrado no Genero : " + livro.getGenero().getIdGenero());

    }
    public int escolherLivro(){
        int i = 0;
        List<Livro> list = livroController.listarLivros();
        if(list.isEmpty()){
            return -1;
        }
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);
        String[] tmp = new String[list.size()];
        String opc = "";
        String output = "";
        for (Livro livro : list) {
            tmp[i] =  i + "| " + "NOME : " + livro.getNomeLivro();
            i++;
        }
        Object selectionObject = (String) JOptionPane.showInputDialog(frame,"Selecione o Livro","Livros",JOptionPane.QUESTION_MESSAGE,null, tmp, tmp[0]);
        Genero genero = new Genero();
        String pegaop = selectionObject.toString();
        StringTokenizer st = new StringTokenizer(pegaop);
        int id1 = Integer.parseInt(st.nextToken("|"));
        return id1;
    }
    public void menuLivro(){
        while (true){
            String op = exibeMenuLivro();
            switch (op){
                case "1":
                    cadastrarLivro();
                    break;
                case "2":
                    listarLivroById();
                    break;
                case "3":
                    Menu menu = new Menu();
                    menu.menu();
                    break;

            }
        }
    }
    public String exibeMenuLivro(){
        String[] escolhas = {"1", "2","3"};
        String menuTexto = "1 | Cadastrar Livro | " + "\n\n2 | Buscar Livro  |" + "\n\n" + "3 | Sair |\n\n";
        return (String) JOptionPane.showInputDialog(null,"Selecione uma opção :\n\n" + menuTexto,"Menu", JOptionPane.INFORMATION_MESSAGE, null,escolhas, escolhas[0]);
    }

}
