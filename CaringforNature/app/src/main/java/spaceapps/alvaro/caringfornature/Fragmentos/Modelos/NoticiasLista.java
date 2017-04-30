package spaceapps.alvaro.caringfornature.Fragmentos.Modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Alvaro on 30/04/2017.
 */

public class NoticiasLista {
    public static final String[] tituloNoticias = {
            "Incendio en Reserva Bosawas deja 1000 hectáreas destrozadas",
            "Deslave deja a familias sin hogar"
    };
    private static String fecha = "Hoy";
    private static String lorem ="Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore..";

    /**
     * Genera una lista de objetos {@link Noticias} con un tamaño determinado
     *
     * @param count Tamaño
     * @return Lista aleatoria
     */
    public static List<Noticias> randomList(int count) {
        Random random = new Random();
        List<Noticias> items = new ArrayList<>();

        // Restricción de tamaño
        count = Math.min(count, 10);

        while (items.size() < count) {

            items.add(new Noticias(tituloNoticias[random.nextInt(tituloNoticias.length)],lorem,fecha));
        }

        return new ArrayList<>(items);
    }
}
