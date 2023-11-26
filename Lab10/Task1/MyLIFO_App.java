package Task1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyLIFO_App {
	// This method reserves the given array
	public static <E> void reserve(E[] array) {
		Stack<E> re = new Stack<E>();
		for (int i = 0; i < array.length; i++) {
			re.push(array[i]);
		}
		for (int i = 0; i < array.length; i++) {
			array[i] = re.pop();
		}
	}

	// This method checks the correctness of the given input
	// i.e. ()(())[]{(())} ==> true, ){[]}() ==> false
	public static boolean isCorrect(String input) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : input.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				stack.push((c == '(') ? ')' : (c == '{') ? '}' : ']');
			} else if (c == ')' || c == '}' || c == ']') {
				if (stack.isEmpty() || c != stack.pop()) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		Integer[] intArr = { 1, 2, 3, 4, 5 };
		reserve(intArr);
		System.out.println(Arrays.toString(intArr));

		String[] stringArr = { "apple", "banana", "orange"};
		reserve(stringArr);
		System.out.println(Arrays.toString(stringArr));

		String a = "{[()";
		System.out.println(isCorrect(a));

	}
}