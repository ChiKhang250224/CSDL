package Task_1;

public class TowerOfHanoi {
	public static void moveTower(int disk, char source, char dest, char spare) {
		if (disk == 1) {
			System.out.println("Di chuyen disk tu " + source + " den " + dest);
		} else {
			moveTower(disk - 1, source, spare, dest);
			System.out.println("Di chuyen disk tu " + source + " den " + dest);
			moveTower(disk - 1, spare, dest, source);
		}
	}
	public static void main(String[] args) {
		int disk = 3;
		moveTower(3, 'A', 'C', 'B');
		
	}
}