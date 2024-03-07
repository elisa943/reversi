public class board {
    public static int[][] board;
    public static int BOARD_SIZE = 8;

    public static void init() {
        board = new int[BOARD_SIZE][BOARD_SIZE]; // initialisée à 0
        board[BOARD_SIZE/2 - 1][BOARD_SIZE/2 - 1] = 1;
        board[BOARD_SIZE/2][BOARD_SIZE/2] = 1;
        board[BOARD_SIZE/2][BOARD_SIZE/2 - 1] = -1;
        board[BOARD_SIZE/2 - 1][BOARD_SIZE/2] = -1;
    }

    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static int min(int a, int b) {
        return (a < b) ? a : b;
    }

    public void places_disk(int j, int i, int player) {
        // Places the new disk
        board[j][i] = player;
        
        // Inverts the disks

        // Looks for all directions
        for (int m = -1; m <= 1; m++) { // y 
            for (int n = -1; n <= 1; n++) { // x
                // Checks that the direction isn't idle
                if (!(m == 0 && n == 0)) {
                    boolean disk_found = false;
                    boolean stop = false;
                    int current_i = i;
                    int current_j = j;
                    while (current_i < BOARD_SIZE && current_i > -1 && current_j < BOARD_SIZE && current_j > -1 && !(stop)) {
                        current_j += m;
                        current_i += n;

                        if (board[current_j][current_i] == player) {
                            disk_found = true;
                            stop = true;
                        }
                        else if (board[current_j][current_i] == -player) {
                            
                        }
                        else {
                            stop = true;
                        }
                    }

                    // If a disk of the same color is found, colors the disks inbetween them
                    if (disk_found) {
                        int x = i + n;
                        int y = j + m; 
                        while (x != current_i || y != current_j) {
                            board[y][x] = player;
                            x += n;
                            y += m; 
                        }
                    }
                }
            }
        }

    }

    public boolean game_finished() {
        for (int j = 0; j < BOARD_SIZE; j++) {
            for (int i = 0; i < BOARD_SIZE; i++) {
                if (board[j][i] == 0) {return false;}
            }
        }
        return true;
    }

    public int winner() {
        int positive = 0;
        int negative = 0;
        for (int j = 0; j < BOARD_SIZE; j++) {
            for (int i = 0; i < BOARD_SIZE; i++) {
                if (board[j][i] > 0) {
                    positive++;
                }
                else {
                    negative++;
                }
            }
        }

        return positive > negative ? positive : negative;
    }

    public void print_board() {
        for (int j = 0; j < BOARD_SIZE; j++) {
            for (int i = 0; i < BOARD_SIZE; i++) {
                System.out.printf("%d ", board[j][i]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
