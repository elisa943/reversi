public class Board {
    public static int[][] board;
    public static final int BOARD_SIZE = 8;
    public player startingPlayer;

    public board(player startingPlayer) {
        board = new int[BOARD_SIZE][BOARD_SIZE]; // initialisée à 0
        board[BOARD_SIZE/2 - 1][BOARD_SIZE/2 - 1] = 1;
        board[BOARD_SIZE/2][BOARD_SIZE/2] = 1;
        board[BOARD_SIZE/2][BOARD_SIZE/2 - 1] = -1;
        board[BOARD_SIZE/2 - 1][BOARD_SIZE/2] = -1;
        this.startingPlayer = startingPlayer;
    }

    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static int min(int a, int b) {
        return (a < b) ? a : b;
    }

    public void places_disk(int j, int i, int player) {
        // Place the new disk
        board[j][i] = player;
        
        // Invert the disks
        boolean disk_found;
        boolean stop;
        int current_i;
        int current_j;

        // Look for all directions
        for (int m = -1; m <= 1; m++) { // y 
            for (int n = -1; n <= 1; n++) { // x
                // Checks that the direction isn't idle
                if (!(m == 0 && n == 0)) {
                    disk_found = false;
                    stop = false;
                    current_i = i;
                    current_j = j;
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
        /* Returns the value of the player who won */
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

        return positive > negative ? 1 : -1;
    }

    public void print_board() {
        /* Prints on the board on the terminal */
        for (int j = 0; j < BOARD_SIZE; j++) {
            for (int i = 0; i < BOARD_SIZE; i++) {
                System.out.printf("%d ", board[j][i]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean possible_move(int j, int i, int player) {
        /* Returns true if a move is possible 
        ie : if the disk chosen by the player is neighbouring an opposite player's disk */
        // If the position is already occupied, returns false
        if (board[j][i] != 0) {return false;}
        
        // Else, checks if it's surrounded by a disk of -color (except through diagonals)
        for (int dir_j = max(0, j-1); dir_j <= min(BOARD_SIZE - 1, j+1); dir_j++) {
            for (int dir_i = max(0, i-1); dir_i <= min(BOARD_SIZE - 1, i+1); dir_i++) {
                if ((dir_i-i == 0 && dir_j-j != 0) || (dir_i-i != 0 && dir_j-j == 0)) {
                    // If a disk of the opposite color is found nearby (j, i) then a move can be made
                    if (board[dir_j][dir_i] == (-player)) {return true;}
                }
            }
        }

        return false;
    }

}
