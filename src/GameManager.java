import java.util.Scanner;
import java.util.StringTokenizer;

public class GameManager {
    static int[] parseTupleInput(String input) {
        StringTokenizer st = new StringTokenizer(input, ",");
        try {
            int firstNumber = Integer.parseInt(st.nextToken().trim());
            int secondNumber = Integer.parseInt(st.nextToken().trim());
            if (firstNumber < 1 || firstNumber > 3 || secondNumber < 1 || secondNumber > 3) {
                return new int[]{};
            }
            return new int[]{firstNumber, secondNumber};
        }
        catch (Exception e) {
//            System.out.println("Ex");
            return new int[]{};
        }

    }


    public static void main(String[] args) {
        while (true) {
            playGame();
            System.out.println("Press enter to play again.");
            new Scanner(System.in).nextLine();
        }
        // out of loop, either all moves over or someone won

    }

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to TicTacToe. Type who goes first.");
        String userInput = "";

        while (!(userInput.equals("x") || userInput.equals("o"))) {
            System.out.print("Enter X/O: ");
            userInput = scanner.nextLine().toLowerCase();
        }

        Player playerX = new Player('X');
        Player playerO = new Player('O');

        Player evenPlayer = playerO;
        Player oddPlayer = playerX;
        if (userInput.equals("x")) {
            evenPlayer = playerX;
            oddPlayer = playerO;
        }

        Board gameBoard = new Board();

        Player currentPlayer;


        for (int i = 0; i < 9; i++) {
            // play the nine moves
            System.out.println("Current Board: ");
            gameBoard.printBoard();
            currentPlayer = i % 2 == 1 ? oddPlayer : evenPlayer;
            String currentInput;
            int[] indices;
            while (true) {
                System.out.printf("Player %s, make your turn. Enter two numbers between 1 and 3 separated by a comma.\n", currentPlayer.symbol);
                currentInput = scanner.nextLine();
                indices = GameManager.parseTupleInput(currentInput);
                if (indices.length == 0) {
                    System.out.println("Invalid Input.");
                    continue;
                }
                if (!gameBoard.isValid(indices[0] - 1, indices[1] - 1)) {
                    System.out.println("Place already taken.");
                    continue;
                }
                break;
            }
            gameBoard.placeSymbol(indices[0] - 1, indices[1] - 1, currentPlayer.symbol);

            if (gameBoard.isWinner()) {
                System.out.printf("Player %s wins.\n\n", currentPlayer.symbol);
                break;
            }

        }
    }
}
