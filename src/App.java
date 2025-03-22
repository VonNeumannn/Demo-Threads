/**
 * @author Justin Acuña Barrantes - 2018093451
 *         Programa principal de la aplicación, ejecutar este archivo para
 *         iniciar la carrera
 */
public class App {
    public static void main(String[] args) throws Exception {
        // Longitud de la pista y velocidades, cambiar a los valores deseados, pero la
        // tortuga debe tener una velocidad >= 2
        int longitudPista = 1320;
        int VELOCIDAD_CONEJO = 6;
        int VELOCIDAD_TORTUGA = 2;

        // Monitor que revisa el estado de los personajes
        CarreraMonitor monitor = new CarreraMonitor();

        // Crea una carrera con la longitud de la pista
        Carrera carrera = new Carrera(longitudPista);

        Personaje conejo = new Personaje("Conejo", 0, 110, VELOCIDAD_CONEJO, "/imagenes/conejo.png");
        // La tortuga debe tener la velocidad >= 2 para que el conejo no se quede
        // detenido
        Personaje tortuga = new Personaje("Tortuga", 0, 300, VELOCIDAD_TORTUGA, "/imagenes/tortuga.png");

        // Agrega los personajes a la carrera
        carrera.agregarPersonaje(conejo);
        carrera.agregarPersonaje(tortuga);

        // Crea la interfaz gráfica
        Interfaz interfaz = new Interfaz(conejo, tortuga);

        // Crea los hilos de ejecución
        ThreadConejo threadConejo = new ThreadConejo(conejo, tortuga, longitudPista, interfaz, monitor);
        ThreadTortuga threadTortuga = new ThreadTortuga(tortuga, longitudPista, interfaz, monitor);

        // Inicia los hilos
        threadConejo.start();
        threadTortuga.start();

    }
}
