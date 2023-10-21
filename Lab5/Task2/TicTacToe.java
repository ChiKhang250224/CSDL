package Task2;

public class TicTacToe {
	private static final char EMPTY = ' ';
	private static char[][] board;

//Task2_1
	/*
	 * This method checks all rows and returns true if any of them are marked with
	 * all of a single player's markers. Otherwise, returns false.
	 */
	public boolean checkRows() {
		boolean allX = true;
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (board[row][col] != 'x') {
					allX = false;
					break;
				}
			}
			if (allX) {
				return true;
			}
		}
		return false;
	}

	// Task2_2
	/*
	 * This method checks all columns and returns true if any of them are marked
	 * with all of a single player's. Otherwise, returns false.
	 */
	public boolean checkColumns() {
		for (int col = 0; col < board[0].length; col++) {
			boolean allX = true;
			for (int row = 0; row < board.length; row++) {
				if (board[row][col] != 'x') {
					allX = false;
					break;
				}
			}
			if (allX) {
				return true;
			}
		}
		return false;
	}

	// Task2_3
	/*
	 * This method checks both diagonals and returns true if any of them are marked
	 * with all of a single player's markers. Otherwise, returns false.
	 */
	public static boolean checkDiagonals() {
		// Check top-left to bottom-right
		for (int row = 0; row < board.length; row++) {
			if (board[row][row] != 'x') {
				break;
			}
			if (row == board.length - 1) {
				return true;
			}
		}

		// Check bottom-left to top-right
		for (int row = 0; row < board.length; row++) {
			if (board[row][board.length - 1 - row] != 'x') {
				break;
			}
			if (row == board.length - 1) {
				return true;
			}
		}

		return false;
	}

}