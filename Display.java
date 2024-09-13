import javax.swing.*;
import java.awt.event.*;
import java.awt.*;  

public class Display extends JFrame {
    // Table of graphics for each button 
    final int BUTTON_SIZE = 100;
    static final int DISK_RADIUS = 45;
    static int BOARD_SIZE = board.BOARD_SIZE; 
    static public Graphics[][] graphicsButtons;
    static final int WINDOW_SIZE = 800;

    public static void main(String[] args) {
        
        JFrame f = new JFrame();
        f.setSize(WINDOW_SIZE, WINDOW_SIZE);
        f.setTitle("Reversi");

        // Creates a drawing of a disk and adds it to the frame
        Draw drawing = new Draw(45);
        f.add(drawing);

        // Creates the grid 
        JPanel panel = new JPanel(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        f.add(panel);

        // Adds buttons 
        JButton[][] buttons = new JButton[BOARD_SIZE][BOARD_SIZE];
        for (int j = 0; j < BOARD_SIZE; j++)
        {
            for (int i = 0; i < BOARD_SIZE; i++) {
                buttons[j][i] = new JButton();
                panel.add(buttons[j][i]);
            }
        }
    }

    public Display(String title) {
        this.graphicsButtons = new Graphics[BOARD_SIZE][BOARD_SIZE];
        JButton[][] buttons = new JButton[BOARD_SIZE][BOARD_SIZE];

        initialize_game(title, buttons);
        initialize_graphics_button(this.graphicsButtons, buttons);
    }

    public void initialize_game(String title, JButton[][] buttons) {
        // Sets title and size
        setTitle(title);
        setSize(WINDOW_SIZE, WINDOW_SIZE);
        
        // Creates the grid
        JPanel panel = new JPanel(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        add(panel);

        // Initializes buttons 
        for (int j = 0; j < BOARD_SIZE; j++)
        {
            for (int i = 0; i < BOARD_SIZE; i++) {
                buttons[j][i] = new JButton();
                panel.add(buttons[j][i]);
            }
        }
        add(panel);
    }
    
    public void initialize_graphics_button(Graphics[][] graphicsButtons, JButton[][] buttons) {
        /* Initialize graphics buttons */
        for (int j = 0; j < BOARD_SIZE; j++) {
            for (int i = 0; i < BOARD_SIZE; i++) {
                // Get the Graphics object from the button
                graphicsButtons[j][i] = buttons[j][i].getGraphics();
            }
        }
    }

    public void display_disk(int j, int i, Color color) {
        // Sets the color 
        graphicsButtons[j][i].setColor(color);

        // Draws the disk
        graphicsButtons[j][i].fillOval(i*BUTTON_SIZE, j*BUTTON_SIZE, DISK_RADIUS, DISK_RADIUS);
    }

    public static void free() {
        for (int j = 0; j < BOARD_SIZE; j++) {
            for (int i = 0; i < BOARD_SIZE; i++) {
                graphicsButtons[j][i].dispose();
            }
        }
    }
}
