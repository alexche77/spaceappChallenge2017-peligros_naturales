package spaceapps.alvaro.caringfornature.Fragmentos.Modelos;

import java.util.List;

/**
 * Created by Alvaro on 30/04/2017.
 */

public class Desastre {
    /**
     * Un incendio en nuestra estructura de firebase tiene esta estructura
     *
     dia_noche:"D"
     direccion:"Departamento de Jinotega, Nicaragua"
     fecha_obtenido:"2017-10-23"
     hora_obtenido: "18:42"
     latitud: "13.93322"
     longitud:"-85.71487"

     */

    private String dia_noche,fecha_obtenido,hora_obtenido,latitud,longitud, direccion;



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


    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
