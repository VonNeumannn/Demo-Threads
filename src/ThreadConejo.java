/**
 * @author von
 */
public class ThreadConejo extends Thread {
    private Personaje personaje;
    private Personaje tortuga;
    private int longitudPista;
    private Interfaz interfaz;
    private CarreraMonitor monitor;

    public ThreadConejo(Personaje personaje, Personaje tortuga, int longitudPista, Interfaz interfaz,
            CarreraMonitor monitor) {
        this.personaje = personaje;
        this.tortuga = tortuga;
        this.longitudPista = longitudPista;
        this.interfaz = interfaz;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        int puntoDormir = (int) (Math.random() * ((longitudPista - 400) - 200)) + 200;
        while (!personaje.haTerminado(longitudPista)) {
            if (personaje.getX() >= puntoDormir) {
                monitor.esperar();
            }
            if (personaje.getX() < tortuga.getX() - 1 && tortuga.getX() >= 10) {
                personaje.setVelocidad(tortuga.getVelocidad() - 1);
                personaje.moverse();
            }
            else {
                personaje.moverse();
            }
            
            //personaje.mostrarPosicion();
            interfaz.actualizarCarrera();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.err.println("Error en la carrera");
            }
        }
        System.out.println(personaje.getNombre() + " ha terminado la carrera.");
    }

}
