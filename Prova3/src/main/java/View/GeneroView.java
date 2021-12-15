package View;

import Controller.GeneroController;
import Model.Genero;
import Model.Livro;

import javax.swing.*;
import java.util.List;
import java.util.StringTokenizer;

public class GeneroView {
    GeneroController generoController = new GeneroController();
    public void cadastrarGenero(){
        Genero genero = new Genero();
        genero.setNomeGenero(JOptionPane.
                showInputDialog(null, "Digite o nome do novo genero :"));
        generoController.cadastrarGenero(genero);

    }
    public void listarGeneros(){
        String output = "Generos Disponiveis : \n\n";
        for(Genero genero : generoController.listarGeneros()){
            output += " Nome do Genero : " + genero.getNomeGenero() + "\n";
        }
        JOptionPane.showMessageDialog(null, output);
    }
    public void editarGeneros(){
        int IdGenero = escolherGenero();
        Genero genero = generoController.listarGeneros().get(IdGenero);
        String opc = JOptionPane.showInputDialog(null, "1/ Editar Nome\n2/ Sair");
        switch (opc){
            case "1":
                String nvNome = JOptionPane
                        .showInputDialog(null, " " +
                                "Digite um novo nome Para o Genero " + genero.getNomeGenero() + "  :");
                genero.setNomeGenero(nvNome);
                break;
            case "2":
                break;
        }
        generoController.editarGenero(genero);
    }
    public void listarLivroPorGenero(){
        String output = "Livros disponiveis : \n";
        long idGenero = generoController.listarGeneros().get(escolherGenero()).getIdGenero();
        for(Livro livro : generoController.listarLivroPorGenero(idGenero)){
            output += livro.getNomeLivro() + "\n";
        }
        JOptionPane.showMessageDialog(null, output);
    }
    public int escolherGenero(){
        int i = 0;
        List<Genero> list = generoController.listarGeneros();
        if(list.isEmpty()){
            return -1;
        }
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);
        String[] tmp = new String[list.size()];
        String opc = "";
        String output = "";
        for (Genero genero : list) {
            tmp[i] =  i + "| " + "NOME : " + genero.getNomeGenero();
            i++;
        }
        Object selectionObject = (String) JOptionPane.showInputDialog(frame,"Selecione o Genero","Generos",JOptionPane.QUESTION_MESSAGE,null, tmp, tmp[0]);
        Genero genero = new Genero();
        String pegaop = selectionObject.toString();
        StringTokenizer st = new StringTokenizer(pegaop);
        int id1 = Integer.parseInt(st.nextToken("|"));
        return id1;
    }
    public void menuGenero(){
        while (true){
            String op = exibeMenuGenero();
            switch (op){
                case "1":
                    cadastrarGenero();
                    break;
                case "2":
                    editarGeneros();
                    break;
                case "3":
                    listarLivroPorGenero();
                    break;
                case "4":
                    Menu menu = new Menu();
                    menu.menu();
                    break;

            }
        }
    }
    public String exibeMenuGenero(){
        String[] escolhas = {"1", "2","3","4"};
        String menuTexto = "1 | Cadastrar Genero | " + "\n\n2 | Editar Generos  |" + "\n\n" + "3 |Ver Livros de um Genero |\n\n4  | Sair  |\n\n ";
        return (String) JOptionPane.showInputDialog(null,"Selecione uma opção :\n\n" + menuTexto,"Menu", JOptionPane.INFORMATION_MESSAGE, null,escolhas, escolhas[0]);
    }
}
