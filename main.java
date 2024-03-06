public class main {
    public static void main(String[] args) {
        board theBoard = new board();
        theBoard.init();
        theBoard.print_board();
        theBoard.places_disk(5, 3, 1);
        theBoard.print_board();
    }
}