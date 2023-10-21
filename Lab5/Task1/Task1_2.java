package Task1;

public class Task1_2 {
	public static int[][] subtract(int[][] a, int[][] b) {
		if (a.length != b.length || a[0].length != b[0].length) {
			System.out.print("Kich thuoc ma tran khong giong nhau");
		}
		int[][] result = new int[a.length][a[0].length];
		for (int row = 0; row < a.length; row++) {
			for (int col = 0; col < a[0].length; col++) {
				result[row][col] = a[row][col] - b[row][col];
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
		printMatrix(subtract(a, b));
	}
}
