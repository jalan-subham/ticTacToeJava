import java.util.Arrays;

public class Board {
    private char[][] board;

    Board() {
        this.board = new char[3][3];
    }

    public boolean placeSymbol(int i, int j, char symbol) {
        if (this.board[i][j] != 0)  {
            return false;
        }
        this.board[i][j] = symbol;
        return true;
    }

    public boolean isValid(int i, int j) {
        return board[i][j] == 0;
    }

    public boolean isWinner() {
        // check all rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != 0 && board[i][0] == board[i][1] && board[i][1] == board[i][2]) return true;
        }
        // check all cols
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != 0 && board[0][j] == board[1][j] && board[1][j] == board[2][j]) return true;
        }
        // check diags
        if (board[0][0] != 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2]) return true;
        if (board[0][2] != 0 && board[0][2] == board[1][1] && board[1][1] == board[2][0]) return true;

        return false;
    }

    public void printBoard() {
        for (int i = 0; i < 2; i++) {
            System.out.printf("%s | %s | %s\n", board[i][0], board[i][1], board[i][2]);
            System.out.println("_________");
        }
        System.out.printf("%s | %s | %s\n", board[2][0], board[2][1], board[2][2]);
    }



}

