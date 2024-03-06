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

    public void places_disk(int i, int j, int player) {
        // Places the new disk
        board[i][j] = player;

        // Inverts the disks

        // Looks for all directions
        for (int m = -1; m <= 1; m++) {
            for (int n = -1; n <= 1; n++) {
                // Checks that the direction isn't idle
                if (!(m == 0 && n == 0)) {
                    boolean disk_found = false;
                    boolean stop = false;
                    int current_i = i;
                    int current_j = j;
                    while (current_i < BOARD_SIZE && current_i > -1 && current_j < BOARD_SIZE && current_j > -1 && !(stop)) {
                        current_i += m;
                        current_j += n;

                        if (board[current_i][current_j] == player) {
                            disk_found = true;
                            stop = true;
                        }
                        else if (board[current_i][current_j] == -player) {
                            
                        }
                        else {
                            stop = true;
                        }
                    }

                    // If a disk of the same color is found, colors the disks inbetween them
                    if (disk_found) {
                        System.out.printf("direction : %d %d\n", m, n);
                        System.out.printf("%d %d\n", current_i, current_j);
                        for (int k = min(i, current_i); k <= max(i, current_i); k++) {
                            for (int l = min(j, current_j); l <= max(j, current_j); l++) {
                                board[k][l] = player;
                            }

                        }
                    }
                }
            }
        }

    }

    public void print_board() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.printf("%d ", board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
