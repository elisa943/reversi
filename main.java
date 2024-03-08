import java.util.Map.Entry;
import java.util.List;

public class main {
    public static void main(String[] args) {
        board theBoard = new board();

        player firstPlayer = new player(1);
        player secondPlayer = new player(-1);

        theBoard.print_board();

        List<Entry<Integer,Integer>> moves = firstPlayer.all_possible_moves(theBoard);

        System.out.printf("%b\n", moves.isEmpty());

    }
}