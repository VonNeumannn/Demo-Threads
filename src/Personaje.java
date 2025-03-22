/**
 * @author Justin Acuña Barrantes - 2018093451
 *         Clase que representa un personaje en la carrera
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
