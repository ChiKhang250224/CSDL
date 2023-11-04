package Task1;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MyWordCount {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";
	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<WordCount> getWordCounts() {
		List<WordCount> re = new ArrayList<>();
		for (String w : words) {
			WordCount wc = new WordCount(w, comtWord(w));
			if (re.contains(re))
				;
			re.add(wc);

		}
		return re;
	}

	private int comtWord(String w) {
		int count = 0;
		for (String w1 : words) {
			if (w1.equals(w)) {
				count++;
			}
		}
		return count;
	}

	// Returns the words that their appearances are 1, do not consider duplidated
	// words

	public Set<String> getUniqueWords() {
		Set<String> re = new HashSet<>();
		for (String w : words) {
			if (comtWord(w) == 1) {
				re.add(w);

			}
		}

		return re;
	}
	// Returns the words in the text file, duplicated words appear once in the
	// result

	public Set<String> getDistinctWords() {
		return new HashSet<>(words);
	}

	public Set<WordCount> exportWordCounts() {
		Set<WordCount> re = new TreeSet<>(new Comparator<>() {

			@Override
			public int compare(WordCount w1, WordCount w2) {
				return w1.getWord().compareTo(w2.getWord());
			}
		});
		re.addAll(getWordCounts());
		return re;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsOrderByOccurence() {
		Set<WordCount> re = new TreeSet<>(new Comparator<>() {

			@Override
			public int compare(WordCount w1, WordCount w2) {
				return -(w1.getCount() - w2.getCount());
			}
		});
		re.addAll(getWordCounts());
		return re;
	}

	// delete words beginning with the given pattern (i.e., delete words begin
	// with 'A' letter
	public Set<WordCount> filterWords(String pattern) {
		Set<WordCount> re = new TreeSet<>(new Comparator<>() {

			@Override
			public int compare(WordCount w1, WordCount w2) {
				return w1.getWord().compareTo(w2.getWord());
			}
		});

		for (WordCount wc : getWordCounts()) {
			if (!wc.getWord().startsWith(pattern)) {
				re.add(wc);
			}
		}

		return re;
	}

}
