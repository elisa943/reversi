import java.util.Map.Entry;
import java.util.List;

public class main {
    public static void main(String[] args) {
        board theBoard = new board();
        theBoard.init();

        theBoard.print_board();

        player firstPlayer = new player();
        player secondPlayer = new player();
        firstPlayer.init(1);
        secondPlayer.init(-1);

        List<Entry<Integer,Integer>> moves = secondPlayer.all_possible_moves(theBoard);

        System.out.printf("%b", moves.isEmpty());

    }
}