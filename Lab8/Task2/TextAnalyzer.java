package Task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class TextAnalyzer {
	public static final String fileName = "data/short.txt";
	// <word, its positions>
	private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

	// load words in the text file given by fileName and store into map by using add
	// method in Task 2.1.
	// Using BufferedReader reffered in file TextFileUtils.java
	public TextAnalyzer() throws IOException {
		this.load(fileName);
	}

	public void load(String fileName) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader(fileName));
		String line = null;
		int index = 1;
		while (true) {
			line = r.readLine();
			if (line == null)
				break;
			StringTokenizer tokens = new StringTokenizer(line, " ");
			while (tokens.hasMoreTokens()) {
				String word = tokens.nextToken();
				if (tokens.hasMoreTokens()) {
					add(word, index);
				} else {
					add(word, -index);
				}
				index++;
			}
		}
		r.close();
		System.out.println(map);
	}

	// In the following method, if the word is not in the map, then adding that word
	// to the map containing the position of the word in the file. If the word is
	// already in the map, then its word position is added to the list of word
	// positions for this word.
	// Remember to negate the word position if the word is at the end of a line in
	// the text file

	public void add(String word, int position) {
		if (!map.containsKey(word)) {
			map.put(word, new ArrayList<>());
		}
		map.get(word).add(position);

	}

	// This method should display the words of the text file along with the
	// positions of each word, one word per line, in alphabetical order
	public void displayWords() {
		Map<String, ArrayList<Integer>> sortedMap = new TreeMap<>(map);

		System.out.println("Word\t\t\t\tWord Position(s)");
		System.out.println("================================================");

		for (Map.Entry<String, ArrayList<Integer>> entry : sortedMap.entrySet()) {
			System.out.printf("%-20s", entry.getKey());
			ArrayList<Integer> positions = entry.getValue();
			for (int i = 0; i < positions.size(); i++) {
				if (i != positions.size() - 1) {
					System.out.print(positions.get(i) + ", ");
				} else {
					System.out.print(positions.get(i));
				}
			}
			System.out.println();
		}
	}

	// This method will display the content of the text file stored in the map
	public void displayText() {
		for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

	// This method will return the word that occurs most frequently in the text file
	public String mostFrequentWord() {
		String mostFrequent = null;
		int maxCount = 0;

		for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
			int count = entry.getValue().size();
			if (count > maxCount) {
				maxCount = count;
				mostFrequent = entry.getKey();
			}
		}

		return mostFrequent;
	}

	public static void main(String[] args) throws IOException {
		TextAnalyzer e = new TextAnalyzer();
		e.displayWords();
		e.displayText();
		e.mostFrequentWord();

	}
}
