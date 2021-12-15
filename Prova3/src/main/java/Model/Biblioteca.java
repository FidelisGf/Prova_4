package Model;

public class Biblioteca {
    private long IdBiblioteca;
    private String nomeBiblioteca;

    public long getIdBiblioteca() {
        return IdBiblioteca;
    }

    public void setIdBiblioteca(long idBiblioteca) {
        IdBiblioteca = idBiblioteca;
    }

    public String getNomeBiblioteca() {
        return nomeBiblioteca;
    }

    public void setNomeBiblioteca(String nomeBiblioteca) {
        this.nomeBiblioteca = nomeBiblioteca;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "IdBiblioteca=" + IdBiblioteca +
                ", nomeBiblioteca='" + nomeBiblioteca + '\'' +
                '}';
    }
}
