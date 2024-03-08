import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;  

public class Display extends JFrame {
    public Display(String title) {
        initialize_game(title);
    }

    public void initialize_game(String title) {
        // Sets title and size
        setTitle("Reversi");
        setSize(800, 800);
        int BOARD_SIZE = board.BOARD_SIZE;

        // Creates the grid
        JPanel panel = new JPanel(new GridLayout(BOARD_SIZE, BOARD_SIZE));
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

        Graphics graphics = panel.getGraphics();
        Draw drawing = new Draw();
    }
}