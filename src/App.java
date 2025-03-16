public class App {
    public static void main(String[] args) throws Exception {
        //java.awt.EventQueue.invokeLater(() -> {
        //    new Interfaz().setVisible(true);
        //});
        int longitudPista = 1320;
        CarreraMonitor monitor = new CarreraMonitor();
        Carrera carrera = new Carrera(longitudPista);
        Personaje conejo = new Personaje("Conejo", 0, 110, 2, "/imagenes/conejo.png");
        Personaje tortuga = new Personaje("Tortuga", 0, 300, 1, "/imagenes/tortuga.png");

        carrera.agregarPersonaje(conejo);
        carrera.agregarPersonaje(tortuga);

        Interfaz interfaz = new Interfaz(conejo, tortuga);

        ThreadConejo threadConejo = new ThreadConejo(conejo, longitudPista, interfaz, monitor);
        ThreadTortuga threadTortuga = new ThreadTortuga(tortuga, longitudPista, interfaz, monitor);

        threadConejo.start();
        threadTortuga.start();

    }
}
