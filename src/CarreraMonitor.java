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
