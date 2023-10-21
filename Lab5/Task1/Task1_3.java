package Task1;

public class Task1_3 {
	// multiply 2 matrices
	public static int[][] multiply(int[][] a, int[][] b) {
		int[][] result = new int[a.length][a[0].length];
		for (int row = 0; row < a.length; row++) {
			for (int col = 0; col < a[0].length; col++) {
				for (int k = 0; k < a[0].length; k++) {
					result[row][col] += a[row][k] * b[k][col];
				}
			}
		}
		return result;
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
		int[][] a = { { 1, 4 }, { 2, 9 } };
		int[][] b = { { 4, 4 }, { 4, 5 } };
		printMatrix(multiply(a, b));
	}

}
