import javax.swing.*;
import java.awt.event.*;
import java.awt.*;  

public class Display extends JFrame {
    // Table of graphics for each button 
    static final int BUTTON_SIZE = 100;
    static final int DISK_RADIUS = 45;
    final int WINDOW_SIZE = 800;
    static int BOARD_SIZE = board.BOARD_SIZE; 
    JPanel panel;
    public Graphics[][] graphicsButtons;

    public Display(String title) {
        initialize_game(title);
        this.graphicsButtons = new Graphics[BOARD_SIZE][BOARD_SIZE];
        initialize_graphics_button();
    }

    public void initialize_game(String title) {
        
        // Sets title and size
        setTitle("Reversi");
        setSize(WINDOW_SIZE, WINDOW_SIZE);
        
        // Creates the grid
        this.panel = new JPanel(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        add(panel);

        // Adds buttons 
        JButton[][] buttons = new JButton[BOARD_SIZE][BOARD_SIZE];
        for (int j = 0; j < BOARD_SIZE; j++)
        {
            for (int i = 0; i < BOARD_SIZE; i++) {
                buttons[j][i] = new JButton();
                panel.add(buttons[j][i]);
            }
        }

        //Graphics graphics = panel.getGraphics();
        //Draw drawing = new Draw(50, 50, graphics);
    }

    public void initialize_graphics_button() {
        /*
        for (int j = 0; j < BOARD_SIZE; j++) {
            for (int i = 0; i < BOARD_SIZE; i++) {
                graphicsButtons[j][i] = Graphics.create(i*BUTTON_SIZE, j*BUTTON_SIZE, BUTTON_SIZE, BUTTON_SIZE);
            }
        }
        */
    }

    public void display_disk(int j, int i, Color color) {
        // Sets the color 
        graphicsButtons[j][i].setColor(color);

        // Draws the disk
        graphicsButtons[j][i].fillOval(i*BUTTON_SIZE, j*BUTTON_SIZE, DISK_RADIUS, DISK_RADIUS);
    }

    public void free() {
        for (int j = 0; j < BOARD_SIZE; j++) {
            for (int i = 0; i < BOARD_SIZE; i++) {
                graphicsButtons[j][i].dispose();
            }
        }
    }
}
