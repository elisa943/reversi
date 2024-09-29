import javax.swing.*;
import java.awt.*; 

// Classe de boutons personnalisés pour dessiner des disques
public class DiskButton extends JButton {
    private Color diskColor = null;

    // Méthode pour définir la couleur du disque
    public void setDiskColor(Color color) {
        this.diskColor = color;
        repaint();  // Demande de repeindre le bouton avec la nouvelle couleur
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // Appelle le paintComponent du bouton
        if (diskColor != null) {
            g.setColor(diskColor);
            int diameter = Math.min(getWidth(), getHeight()) - 10;  // Taille du disque avec une petite marge
            g.fillOval((getWidth() - diameter) / 2, (getHeight() - diameter) / 2, diameter, diameter);
        }
    }
}