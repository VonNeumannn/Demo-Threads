
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author von
 */ 
public class Carrera {
    private Pista pista;
    private List<Personaje> personajes;

    public Carrera(int longitudPista) {
        pista = new Pista(longitudPista);
        personajes = new ArrayList<>();
    }

    public void agregarPersonaje(Personaje personaje) {
        personajes.add(personaje);
    }

    // Método para obtener los personajes que están en la carrera
    public List<Personaje> getPersonajes() {
        return personajes;
    }

}
