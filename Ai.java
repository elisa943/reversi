import java.util.ArrayList;
import java.util.List;

public class Ai {

    public static int state_value(Player thePlayer, Board theBoard) {
        /* Counts the number of thePlayer's tile for now. 
        In the future, a better heuristic will be needed. */
        
        // If the game isn't finished, returns the difference of disks between the player and its adversary. 
        if (!theBoard.game_finished()) {
            int valueOfPlayer = 0;
            int valueOfAdversary = 0;

            for (int j = 0; j < Board.BOARD_SIZE; j++) {
                for (int i = 0; i < Board.BOARD_SIZE; i++) {
                    if (theBoard.board[j][i] == thePlayer.player_value) {
                        valueOfPlayer++;
                    }
                    else if (theBoard.board[j][i] == -thePlayer.player_value) {
                        valueOfAdversary++;
                    }
                }
            }

            return valueOfPlayer-valueOfAdversary;
        }
        // Else, the game is finished and returns ±Board.BOARD_SIZE if the player won or not
        else {
            return (Board.BOARD_SIZE*Board.BOARD_SIZE)*((theBoard.winner() == thePlayer.player_value) ? 1 : -1);
        }
    }

    public static Board result(Board theBoard, Couple move) {
        Board copy = new Board(theBoard.startingPlayer);

        // Copies theBoard's board. 
        for (int j = 0; j < Board.BOARD_SIZE; j++) {
            for (int i = 0; i < Board.BOARD_SIZE; i++) {
                copy.board[j][i] = theBoard.board[j][i];
            }
        }

        // TODO : Makes the associated move 


        // TODO : Changes copy's starting player 

        return copy;
    }

    public static Couple minimax(int depth, Player firstPlayer, Player secondPlayer, Board theBoard) {
        /* Returns the optimal action for the current player */

        // if the game is finished, no need to make a move. 
        if (theBoard.game_finished()) {return null;}

        // list of all possible moves. 
        List<Couple> possible_moves = (theBoard.startingPlayer == firstPlayer ? firstPlayer : secondPlayer).all_possible_moves(theBoard);
        List<Integer> state_value_all_moves;

        // TODO : change Entry class -> Couple class

        return possible_moves.get(0);
    }

}