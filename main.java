import java.util.Map.Entry;
import java.util.List;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;   

public class main {
    public static void main(String[] args) {

        JFrame frame = new Display("Reversi");

        // Creates all entities 
        player firstPlayer = new player(1);
        player secondPlayer = new player(-1);
        board theBoard = new board(firstPlayer);

        ai theAI = new ai();

        List<Couple> moves = firstPlayer.all_possible_moves(theBoard);

        Couple move = ai.minimax(5, firstPlayer, secondPlayer, theBoard);


        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); // Fermeture de l'app
        frame.setVisible(true);

    }
}