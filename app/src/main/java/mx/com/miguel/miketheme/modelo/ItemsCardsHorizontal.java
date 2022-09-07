package mx.com.miguel.miketheme.modelo;

public class ItemsCardsHorizontal {
    private String titulo,numeroBody,iconoBody,iconoFooter,descIconFooter,legendFooter;
    private int tipo;//1--> up, 2-->down

    public ItemsCardsHorizontal(String titulo, String numeroBody, String iconoBody, String iconoFooter, String descIconFooter, String legendFooter, int tipo) {
        this.titulo = titulo;
        this.numeroBody = numeroBody;
        this.iconoBody = iconoBody;
        this.iconoFooter = iconoFooter;
        this.descIconFooter = descIconFooter;
        this.legendFooter = legendFooter;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNumeroBody() {
        return numeroBody;
    }

    public void setNumeroBody(String numeroBody) {
        this.numeroBody = numeroBody;
    }

    public String getIconoBody() {
        return iconoBody;
    }

    public void setIconoBody(String iconoBody) {
        this.iconoBody = iconoBody;
    }

    public String getIconoFooter() {
        return iconoFooter;
    }

    public void setIconoFooter(String iconoFooter) {
        this.iconoFooter = iconoFooter;
    }

    public String getDescIconFooter() {
        return descIconFooter;
    }

    public void setDescIconFooter(String descIconFooter) {
        this.descIconFooter = descIconFooter;
    }

    public String getLegendFooter() {
        return legendFooter;
    }

    public void setLegendFooter(String legendFooter) {
        this.legendFooter = legendFooter;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
