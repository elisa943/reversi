import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;

public class player {
    public static int player_value; // either 1 or -1 

    public player(int value) {
        this.player_value = value;
    }

    public static int score(board theBoard) {
        /* Counts the number of disk the player has. */
        int n = 0;

        for (int j = 0; j < board.BOARD_SIZE; j++) {
            for (int i = 0; i < board.BOARD_SIZE; i++) {
                if (theBoard.board[j][i] == player_value) {
                    n++;
                }
            }
        }

        return n;

    }

    public List<Entry<Integer,Integer>> all_possible_moves(board theBoard) {
        /* Returns a list of all possible moves */
        List<java.util.Map.Entry<Integer,Integer>> moves = new ArrayList<>();
        int BOARD_SIZE = board.BOARD_SIZE;

        for (int j = 0; j < BOARD_SIZE; j++) {
            for (int i = 0; i < BOARD_SIZE; i++) {
                
                if (theBoard.possible_move(j, i, this.player_value)) {
                    Entry<Integer,Integer> pair=new SimpleEntry<>(j,i);
                    moves.add(pair);
                }
            }
        }

        return moves;
    }
}