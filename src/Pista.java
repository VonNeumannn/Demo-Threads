
/**
 * @author Justin Acuña Barrantes - 2018093451
 * Clase que representa una pista de carreras, con sus respectivas coordenadas
 */
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author von
 */
public class Pista {
    private List<Punto> puntos;

    public Pista(int longitud) {
        puntos = new ArrayList<>();
        for (int i = 0; i < longitud; i++) {
            puntos.add(new Punto(i, 0));
        }
    }

    public List<Punto> getPuntos() {
        return puntos;
    }
}
