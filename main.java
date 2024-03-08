import java.util.Map.Entry;
import java.util.List;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;   

public class main {
    public static void main(String[] args) {

        JFrame frame = new Display("Reversi");
        
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); // Fermeture de l'app
        frame.setVisible(true);

        // Creates all entities 
        board theBoard = new board();
        player firstPlayer = new player(1);
        player secondPlayer = new player(-1);

        theBoard.print_board();

        List<Entry<Integer,Integer>> moves = firstPlayer.all_possible_moves(theBoard);

    }
}