import javax.swing.*;
import java.awt.*; 
import java.awt.geom.*;

public class Draw extends JComponent {
    private int COMPONENT_SIZE;
    private int BUTTON_SIZE = 100;

    public Draw(int SIZE) {
        COMPONENT_SIZE = SIZE;
    }

    protected void paintComponent (Graphics g, int j, int i, Color color) {
        Graphics2D g2d = (Graphics2D) g;

        // Creates the disk
        Ellipse2D.Double d = new Ellipse2D.Double(i*BUTTON_SIZE, j*BUTTON_SIZE, COMPONENT_SIZE, COMPONENT_SIZE);

        // Sets the color
        g2d.setColor(color);

        // Fills the disk with the given color
        g2d.fill(d);
    }
}