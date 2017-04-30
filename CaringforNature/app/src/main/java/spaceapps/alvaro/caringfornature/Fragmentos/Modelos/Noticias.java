package spaceapps.alvaro.caringfornature.Fragmentos.Modelos;

import spaceapps.alvaro.caringfornature.R;

/**
 * Created by Alvaro on 30/04/2017.
 */

public class Noticias {
    public Noticias(String titulo, String contenido, String fecha_publicacion) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha_publicacion = fecha_publicacion;
    }

    private String titulo, contenido,fecha_publicacion;
    public int getIdDrawable() {
        return R.drawable.ic_noticias;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }
}
