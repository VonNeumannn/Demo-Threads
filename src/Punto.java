/**
 *
 * @author Justin Acuña Barrantes - 2018093451
 *         Clase que representa un punto en un plano cartesiano de la pista
 */
public class Punto {
    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Punto(" + x + ", " + y + ")";
    }
}
