package spaceapps.alvaro.caringfornature.Fragmentos.Modelos;

import java.util.List;

/**
 * Created by Alvaro on 30/04/2017.
 */

public class Desastre {
    /**
     * Un incendio en nuestra estructura de firebase tiene esta estructura
     *
     "-KixGMwTKBEUWrQVWt1g" : {
         "brillo" : 331.6,
         "confianza" : " nominal",
         "dia_noche" : "D ",
         "fecha_obtenido" : "2017-04-28",
         "hora_obtenido" : "19:18",
         "latitud" : 13.59873,
         "longitud" : -86.00985,
         "satelite" : "Suomi-National Polar-orbiting Partnership (SNPP)",
         "usuarios_afectados" : {
                    "1":true,
                    "2":true
            }
     }
     */

    private String confianza,dia_noche,fecha_obtenido,hora_obtenido,satelite;
    private float latitud,longitud,brillo;
    private List<Integer> usuarios;

    public String getConfianza() {
        return confianza;
    }

    public void setConfianza(String confianza) {
        this.confianza = confianza;
    }

    public String getDia_noche() {
        return dia_noche;
    }

    public void setDia_noche(String dia_noche) {
        this.dia_noche = dia_noche;
    }

    public String getFecha_obtenido() {
        return fecha_obtenido;
    }

    public void setFecha_obtenido(String fecha_obtenido) {
        this.fecha_obtenido = fecha_obtenido;
    }

    public String getHora_obtenido() {
        return hora_obtenido;
    }

    public void setHora_obtenido(String hora_obtenido) {
        this.hora_obtenido = hora_obtenido;
    }

    public String getSatelite() {
        return satelite;
    }

    public void setSatelite(String satelite) {
        this.satelite = satelite;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public float getBrillo() {
        return brillo;
    }

    public void setBrillo(float brillo) {
        this.brillo = brillo;
    }

    public List<Integer> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Integer> usuarios) {
        this.usuarios = usuarios;
    }
}
