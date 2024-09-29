import java.util.Map.Entry;
import java.util.List;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;   

public class Main {
    public static void main(String[] args) {

        // All variables
        boolean run = true;
        int turn = 1;
        boolean ai = false; 
        int move_picked_i; 
        int move_picked_j; 

        // Creation of interface
        JFrame frame = new Display("Reversi");

        // Creation of all entities 
        Player firstPlayer = new Player(1); // Player 1
        Player secondPlayer = new Player(-1); // Player 2
        Board theBoard = new Board(firstPlayer);
        Ai theAI = null;
        if (ai) {theAI = new Ai();}

        //List<Couple> moves = firstPlayer.all_possible_moves(theBoard);
        //moves.forEach(System.out::println);
        //Couple move = ai.minimax(5, firstPlayer, secondPlayer, theBoard);

        // Display window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        while (run) {

            // if player clicked on button, checks if valid 

                // if valid, makes move & turn <- -turn 
            /* 
            if theBoard.possible_move(move_picked_j, move_picked_i, turn) {
                
                turn = -turn;
            } else {
                
            } */
            
                // Updates board

            if (theBoard.game_finished()) {
                run = false;
            }
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermeture de l'app
        frame.setVisible(true);
    }
}