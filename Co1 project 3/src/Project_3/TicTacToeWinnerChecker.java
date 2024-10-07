package Project_3;
public class TicTacToeWinnerChecker {

    // Method to check for the winner
    public static String checkWinner(char[][] board) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return board[i][0] + " wins!";
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '-') {
                return board[0][i] + " wins!";
            }
        }

        // Check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            return board[0][0] + " wins!";
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-') {
            return board[0][2] + " wins!";
        }

        // Check if the board is full (tie)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return "Game still ongoing.";
                }
            }
        }

        // If no winner and no empty spaces, it's a tie
        return "It's a tie!";
    }

    public static void main(String[] args) {
        // Example board
        char[][] board = {
            {'X', 'O', 'X'},
            {'O', 'X', 'O'},
            {'O', 'X', 'X'}
        };

        // Print the result
        System.out.println(checkWinner(board));
    }
}
