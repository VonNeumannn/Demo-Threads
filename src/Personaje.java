/**
 * @author von
 */
public class Personaje {
    private String nombre;
    private double x;
    private double y;
    private int velocidad;
    private String sprite;

    public Personaje(String nombre, double x, double y, int velocidad, String sprite) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.velocidad = velocidad;
        this.sprite = sprite;
    }

    public void moverse() {
        x += velocidad;
    }

    public boolean haTerminado(int longitudPista) {
        return x >= longitudPista;
    }

    public void dormir(int longitudPista, Personaje personaje) {
        int puntoDormir = (int) (Math.random() * (longitudPista - 20)) + 10; // Punto aleatorio en la pista
        boolean dormido = false;

        if (x >= puntoDormir) {
            dormido = true;
            System.out.println(nombre + " se ha dormido en " + x);

            while (dormido) {
                try {
                    Thread.sleep(500); // El conejo duerme medio segundo
                } catch (InterruptedException ex) {
                    System.err.println("Error en la carrera");
                }

                // Si la tortuga está a 10 de la meta, se despierta
                if (personaje.getX() >= (longitudPista - 10)) {
                    dormido = false;
                }
            }
        }
    }

    // Getters y Setters
    public double getX() {
        return x;
    }

    public String getNombre() {
        return nombre;
    }

    public double getY() {
        return y;
    }

    public String getSprite() {
        return sprite;
    }

    public int getVelocidad() {
        return velocidad;
    }
    
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
}
