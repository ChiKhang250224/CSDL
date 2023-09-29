package Task2;

public class MyCaesar {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private int n;

	public MyCaesar(int shiftSteps) {
		this.n = shiftSteps;
	}

	public char encryptChar(char c) {
		String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		c = Character.toUpperCase(c);
		if (ALPHABET.indexOf(c) != -1) {
			int newIndex = (ALPHABET.indexOf(c) + this.n) % 26;
			return ALPHABET.charAt(newIndex);
		} else {
			return c;
		}
	}

	public String encryptText(String text) {
		StringBuilder encryptedText = new StringBuilder();
		char[] characters = text.toCharArray();
		for (int i = 0; i < characters.length; i++) {
		    char c = characters[i];
		    char encryptedChar = encryptChar(c);
		    encryptedText.append(encryptedChar);
		}
		return encryptedText.toString();
	}
	public char decryptChar(char c) {
		String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		c = Character.toUpperCase(c);
		if (ALPHABET.indexOf(c) != -1) {
			int newIndex = (ALPHABET.indexOf(c) - this.n + 26) % 26;
			return ALPHABET.charAt(newIndex);
		} else {
			return c;
		}
	}
	public String decrypt(String input) {
		    StringBuilder decrypted = new StringBuilder();
		    char[] characters = input.toCharArray();
		    for (int i = 0; i < characters.length; i++) {
		        char c = characters[i];
		        decrypted.append(decryptChar(c));
		    }
		    return decrypted.toString();
		}

	public static void main(String[] args) {
		MyCaesar mc = new MyCaesar(3);
		
		String encryptedText = mc.encryptText("Hello");
		char encryptedChar = mc.encryptChar('A');
		char decryptChar = mc.decryptChar('D');
		
		String decrypted = mc.decrypt("KHOOR");
		System.out.println("Ky tu da ma hoa: " + encryptedChar);
		System.out.println("Ky tu da giai ma: " + decryptChar);
		System.out.println("Chuoi da ma hoa: " + encryptedText);
		System.out.println("Chuoi da giai ma: " + decrypted);
	}
}
