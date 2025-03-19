/**
 * @author von
 */
public class App {
    public static void main(String[] args) throws Exception {
        //java.awt.EventQueue.invokeLater(() -> {
        //    new Interfaz().setVisible(true);
        //});
        int longitudPista = 1320;
        CarreraMonitor monitor = new CarreraMonitor();
        Carrera carrera = new Carrera(longitudPista);
        Personaje conejo = new Personaje("Conejo", 0, 110, 10, "/imagenes/conejo.png");
        // La tortuga debe tener la velocidad >= 2 para que el conejo no se quede detenido
        Personaje tortuga = new Personaje("Tortuga", 0, 300, 2, "/imagenes/tortuga.png");

        carrera.agregarPersonaje(conejo);
        carrera.agregarPersonaje(tortuga);

        Interfaz interfaz = new Interfaz(conejo, tortuga);

        ThreadConejo threadConejo = new ThreadConejo(conejo, tortuga, longitudPista, interfaz, monitor);
        ThreadTortuga threadTortuga = new ThreadTortuga(tortuga, longitudPista, interfaz, monitor);

        threadConejo.start();
        threadTortuga.start();

    }
}
