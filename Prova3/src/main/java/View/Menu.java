package View;

import javax.swing.*;

public class Menu {
    public String exibeMenu(){
        String[] escolhas = {"1", "2", "3"};
        String menuTexto = "1 | Menu Bibliotecas | " + "\n\n2 | Menu Generos  |" + "\n\n" + "3  | Menu Livros  |" + "\n\n";
        return (String) JOptionPane.showInputDialog(null,"Selecione uma opção :\n\n" + menuTexto,"Menu", JOptionPane.INFORMATION_MESSAGE, null,escolhas, escolhas[0]);
    }
    public void menu(){
        while (true){
            String op = exibeMenu();
            switch (exibeMenu()){
                case "1":
                    BibliotecaView bibliotecaView = new BibliotecaView();
                    bibliotecaView.menuLivro();
                    break;
                case "2":
                    GeneroView generoView = new GeneroView();
                    generoView.menuGenero();
                    break;
                case "3":
                    LivroView livroView = new LivroView();
                    livroView.menuLivro();
                    break;
            }
        }
    }

}
