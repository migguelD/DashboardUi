package mx.com.miguel.miketheme.modelo;

public class ItemsVerticalCardList {
    private int idIcono;
    private String titulo;

    public ItemsVerticalCardList(int idIcono, String titulo) {
        this.idIcono = idIcono;
        this.titulo = titulo;
    }

    public int getIdIcono() {
        return idIcono;
    }

    public void setIdIcono(int idIcono) {
        this.idIcono = idIcono;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
