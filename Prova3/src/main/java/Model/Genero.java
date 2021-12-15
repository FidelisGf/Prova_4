package Model;

public class Genero {
    private long IdGenero;
    private String nomeGenero;

    public Genero() {
    }

    public Genero(String nomeGenero) {
        this.nomeGenero = nomeGenero;
    }

    public long getIdGenero() {
        return IdGenero;
    }

    public void setIdGenero(long idGenero) {
        IdGenero = idGenero;
    }

    public String getNomeGenero() {
        return nomeGenero;
    }

    public void setNomeGenero(String nomeGenero) {
        this.nomeGenero = nomeGenero;
    }


    @Override
    public String toString() {
        return "Genero{" +
                "IdGenero=" + IdGenero +
                ", nomeGenero='" + nomeGenero + '\'' +
                '}';
    }
}
