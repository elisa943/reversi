BOARD_SIZE = 8

class Board():
    def __init__(self) -> None:
        self.board = [[0 for _ in range(BOARD_SIZE)] for _ in range(BOARD_SIZE)]
        self.board [int(BOARD_SIZE/2) - 1][int(BOARD_SIZE/2) - 1] = 1
        self.board [int(BOARD_SIZE/2)][int(BOARD_SIZE/2)] = 1
        self.board [int(BOARD_SIZE/2)][int(BOARD_SIZE/2) - 1] = -1
        self.board [int(BOARD_SIZE/2) - 1][int(BOARD_SIZE/2)] = -1
        print(self.board)
