import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;

public class Player {
    public int player_value; // either 1 or -1 

    public Player(int value) {
        this.player_value = value;
    }

    public int score(Board theBoard) {
        /* Counts the number of disks the player has. */
        int n = 0;

        for (int j = 0; j < Board.BOARD_SIZE; j++) {
            for (int i = 0; i < Board.BOARD_SIZE; i++) {
                if (theBoard.board[j][i] == player_value) {
                    n++;
                }
            }
        }

        return n;
    }

    public List<Couple> all_possible_moves(Board theBoard) {
        /* Returns a list of all possible moves */
        List<Couple> moves = new ArrayList<>();
        int BOARD_SIZE = Board.BOARD_SIZE;

        for (int j = 0; j < BOARD_SIZE; j++) {
            for (int i = 0; i < BOARD_SIZE; i++) {
                
                if (theBoard.possible_move(j, i, this.player_value)) {
                    Couple pair = new Couple(j,i);
                    moves.add(pair);
                }
            }
        }

        return moves;
    }
}