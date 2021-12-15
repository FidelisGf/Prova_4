package View;

import Controller.BibliotecaController;
import Model.Biblioteca;
import Model.Genero;
import Model.Livro;

import javax.swing.*;
import java.util.List;
import java.util.StringTokenizer;

public class BibliotecaView {
    BibliotecaController bibliotecaController = new BibliotecaController();
    public void cadastrarBiblioteca(){
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setNomeBiblioteca(JOptionPane.
                showInputDialog(null,"Insira um nome Para a nova Biblioteca : "));
        bibliotecaController.cadastrarBiblioteca(biblioteca);
    }
    public void exibirListaDeLivros(){
        String output = "Livros disponiveis :  \n";
        long idBiblioteca = bibliotecaController.listarBibliotecas().get(escolherBiblioteca()).getIdBiblioteca();
        for(Livro livro : bibliotecaController.listarLivrosPorBiblioteca(idBiblioteca)){
            output += livro.getNomeLivro() + " Com Genero : " + livro.getGenero().getIdGenero() + "\n";
        }
        JOptionPane.showMessageDialog(null, output);
    }
    public int escolherBiblioteca(){
        int i = 0;
        List<Biblioteca> list = bibliotecaController.listarBibliotecas();
        if(list.isEmpty()){
            return -1;
        }
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);
        String[] tmp = new String[list.size()];
        String opc = "";
        String output = "";
        for (Biblioteca biblioteca : list) {
            tmp[i] =  i + "| " + "NOME : " + biblioteca.getNomeBiblioteca();
            i++;
        }
        Object selectionObject = (String) JOptionPane.showInputDialog(frame,"Selecione uma Biblioteca","Biblioteca",JOptionPane.QUESTION_MESSAGE,null, tmp, tmp[0]);
        Genero genero = new Genero();
        String pegaop = selectionObject.toString();
        StringTokenizer st = new StringTokenizer(pegaop);
        int id1 = Integer.parseInt(st.nextToken("|"));
        return id1;
    }
    public void menuLivro(){
        while (true){
            String op = exibeMenuBiblioteca();
            switch (op){
                case "1":
                    cadastrarBiblioteca();
                    break;
                case "2":
                    exibirListaDeLivros();
                    break;
                case "3":
                    Menu menu = new Menu();
                    menu.menu();
                    break;

            }
        }
    }
    public String exibeMenuBiblioteca(){
        String[] escolhas = {"1", "2","3"};
        String menuTexto = "1 | Cadastrar Biblioteca | " + "\n\n2 | Livros Da Biblioteca  |" + "\n\n" + "3 | Sair |\n\n";
        return (String) JOptionPane.showInputDialog(null,"Selecione uma opção :\n\n" + menuTexto,"Menu", JOptionPane.INFORMATION_MESSAGE, null,escolhas, escolhas[0]);
    }
}
