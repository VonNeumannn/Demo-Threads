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
            //personaje.mostrarPosicion();
            interfaz.actualizarCarrera();

            if (personaje.getX() >= (longitudPista - 250)) {
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
