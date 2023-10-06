package Task_1;

public class PascalTriangle {
	// This method is used to display a Pascal triangle based on the parameter n.
	// Where n represents the number of rows
	public static void printPascalTriangle(int n) {
		int[] row = { 1 };
		for (int i = 0; i < n; i++) {
			printRow(row);
			row = generateNextRow(row);
		}
	}

	// get the nth row.
	// For example: n=1 ==> {1}, n=2 ==> {1, 1}, ...

	public static int[] getPascalTriangle(int n) {
		int[] row = { 1 };
		for (int i = 1; i < n; i++) {
			row = generateNextRow(row);
		}
		return row;
	}

	// generate the next row based on the previous row
	// Ex. prevRow = {1} ==> nextRow = {1, 1}
	// Ex. prevRow = {1, 1} ==> nextRow = {1, 2, 1}
	public static int[] generateNextRow(int[] prevRow) {
		int[] nextRow = new int[prevRow.length + 1];
		nextRow[0] = 1;
		nextRow[nextRow.length - 1] = 1;
		for (int i = 1; i < nextRow.length - 1; i++) {
			nextRow[i] = prevRow[i - 1] + prevRow[i];
		}
		return nextRow;
	}

	private static void printRow(int[] row) {
		for (int i = 0; i < row.length; i++) {
			System.out.print(row[i] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
			printPascalTriangle(4);
	}
}
