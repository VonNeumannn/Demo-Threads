/**
 * @author Justin Acuña Barrantes - 2018093451
 *         Clase que representa un hilo para la tortuga
 */
public class ThreadTortuga extends Thread {
    private Personaje personaje;
    private int longitudPista;
    private Interfaz interfaz;
    private CarreraMonitor monitor;

    public ThreadTortuga(Personaje personaje, int longitudPista, Interfaz interfaz, CarreraMonitor monitor) {
        this.personaje = personaje;
        this.longitudPista = longitudPista;
        this.interfaz = interfaz;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while (!personaje.haTerminado(longitudPista)) {
            personaje.moverse();
            // personaje.mostrarPosicion();
            interfaz.actualizarCarrera();

            if (personaje.getX() >= (longitudPista - 300)) {
                monitor.despertar(); // Despierta al conejo
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.err.println("Error en la carrera");
            }
        }
        System.out.println(personaje.getNombre() + " ha terminado la carrera.");
    }

}
