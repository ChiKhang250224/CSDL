package Task1;

import java.io.FileNotFoundException;

public class TestMyWordCount {
	public static void main(String[] args) throws FileNotFoundException {
		MyWordCountApp wc = new MyWordCountApp();
		System.out.println(wc.countUnique());
		wc.printWordCounts();
		wc.printWordCountsAlphabet();
		
	}

}
