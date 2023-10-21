package Task1;

public class Task1_4 {
	// tranpose a matrix
	public static int[][] transpose(int[][] a) {
		int[][] b = new int[a[0].length][a.length];
		for (int row = 0; row < a.length; row++) {
			for (int col = 0; col < a[0].length; col++) {
				b[col][row] = a[row][col];
			}
		}
		return b;
	}

	public static void printMatrix(int[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				System.out.print(matrix[row][col] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] a = { { 1, 4, 5 }, { 2, 9, 6 } };
		printMatrix(transpose(a));

	}

}
