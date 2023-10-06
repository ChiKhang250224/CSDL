package Task_1;

public class Task1_1 {
	// S(n)=1-2+3-4+…+ ((-1)^(n+1) ).n , n>0
	public static int getSn1(int n) {
		if (n == 1) {
			return 1;
		}
		return (int) ((Math.pow(-1, n + 1) * n) + getSn1(n - 1));
	}

	// S(n)=1+1.2+1.2.3+…+1.2.3…n, n>0
	public static int giaiThua(int n) {
		if (n == 0) {
			return 1;
		}
		return n * giaiThua(n - 1);
	}

	public static int getSn2(int n) {
		if (n == 1) {
			return 1;
		}
		return getSn2(n - 1) + giaiThua(n);
	}

	// S(n)=1^2+2^2+3^2+....+n^2 , n>0
	public static int getSn3(int n) {
		if (n == 1) {
			return 1;
		}
		return (int) (Math.pow(n, 2) + getSn3(n - 1));
	}

	// S(n)=1+1/2+1/(2.4)+1/(2.4.6)+…+1/(2.4.6.2n), n>=0
	public static double giaiThuaKep(int n) {
		if(n == 0 || n == 1) {
			return 1;
		}
		return  2*(n - 1)*giaiThuaKep(n - 1) ;
	}
	public static double getSn4(int n) {
		if(n == 1) {
			return 1;
		}
		return (double) (1 / giaiThuaKep(n)) + getSn4(n - 1);
	}
	public static void main(String[] args) {
		System.out.println(getSn1(3));
		System.out.println(getSn2(3));
		System.out.println(getSn3(4));
		System.out.println(getSn4(4));
	}
}
