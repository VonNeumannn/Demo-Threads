/**
 * @author Justin Acuña Barrantes - 2018093451
 *         Clase que representa un monitor para la carrera, para saber si el
 *         conejo está durmiendo o no,
 *         y despertarlo cuando la tortuga esté cerca de la meta.
 */
public class CarreraMonitor {
    public synchronized void esperar() {
        try {
            wait(); // Bloquea el hilo hasta que otro lo despierte
        } catch (InterruptedException e) {
            System.err.println("Error en la espera");
        }
    }

    public synchronized void despertar() {
        notify(); // Despierta al hilo dormido
    }
}
