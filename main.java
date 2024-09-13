import java.util.Map.Entry;
import java.util.List;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;   

public class main {
    public static void main(String[] args) {

        boolean run = true;
        int turn = 1;
        boolean ai = false; 

        // Create front-end
        JFrame frame = new Display("Reversi");

        // Creates all entities 
        player firstPlayer = new player(1);
        player secondPlayer = new player(-1);
        board theBoard = new board(firstPlayer);
        ai theAI = new ai();

        //List<Couple> moves = firstPlayer.all_possible_moves(theBoard);
        //moves.forEach(System.out::println);
        //Couple move = ai.minimax(5, firstPlayer, secondPlayer, theBoard);

        while (run) {

            // if player clicked on button, checks if valid 


            turn = -turn; 

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermeture de l'app
            frame.setVisible(true);
        }

        Display.free();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermeture de l'app
        frame.setVisible(true);
    }
}