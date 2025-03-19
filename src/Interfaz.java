/**
 * @author von
 */
import java.awt.*;
import java.net.URL;

import javax.swing.*;

public class Interfaz extends JFrame {
    private JLabel lblPista, lblConejo, lblTortuga;
    private Personaje conejo, tortuga;

    public Interfaz(Personaje conejo, Personaje tortuga) {
        this.conejo = conejo;
        this.tortuga = tortuga;
        //  size for parameters of JFrame
        int WIDTH = 1400;
        int HEIGHT = 500;

        setTitle("Carrera");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // Pista
        URL resource = getClass().getResource("/imagenes/pistaGrande.png");
        if (resource != null) {
            lblPista = new JLabel(new ImageIcon(resource));
            lblPista.setBounds(0, 0, WIDTH, HEIGHT);
        } else {
            System.err.println("No se pudo encontrar la imagen");
        }

        // Sprites de los personajes
        lblConejo = new JLabel(new ImageIcon(getClass().getResource(conejo.getSprite())));
        lblTortuga = new JLabel(new ImageIcon(getClass().getResource(tortuga.getSprite())));

        // Posiciones iniciales de los personajes
        lblConejo.setBounds((int) conejo.getX(), (int) conejo.getY(), 80, 80);
        lblTortuga.setBounds((int) tortuga.getX(), (int) tortuga.getY(), 80, 80);

        // Agregar los elementos al LayeredPane con diferentes niveles
        layeredPane.add(lblPista, JLayeredPane.DEFAULT_LAYER); // Fondo (Pista)
        layeredPane.add(lblTortuga, JLayeredPane.PALETTE_LAYER); // Primer plano (Tortuga)
        layeredPane.add(lblConejo, JLayeredPane.PALETTE_LAYER); // Primer plano (Conejo)

        add(layeredPane);

        setVisible(true);
    }

    // Método para actualizar las posiciones de los personajes
    public void actualizarCarrera() {
        lblConejo.setLocation((int) conejo.getX(), (int) conejo.getY());
        lblTortuga.setLocation((int) tortuga.getX(), (int) tortuga.getY());
        repaint();
    }
}
