package Model;

public class Livro {
    private Long IdLivro;
    private String nomeLivro;
    private Genero genero;
    private Biblioteca biblioteca;
    public Livro(String nomeLivro, Genero genero) {
        this.nomeLivro = nomeLivro;
        this.genero = genero;
    }

    public Livro(String nomeLivro, Genero genero, Biblioteca biblioteca) {
        this.nomeLivro = nomeLivro;
        this.genero = genero;
        this.biblioteca = biblioteca;
    }

    public Livro() {
    }

    public Long getIdLivro() {
        return IdLivro;
    }

    public void setIdLivro(Long idLivro) {
        IdLivro = idLivro;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "IdLivro=" + IdLivro +
                ", nomeLivro='" + nomeLivro + '\'' +
                ", genero=" + genero +
                ", biblioteca=" + biblioteca +
                '}';
    }
}
