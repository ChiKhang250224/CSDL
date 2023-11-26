package Task2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyLIFO_App {
	// TASK2
	// method stutter that accepts a queue of integers as a parameter and replaces
	// every element of the queue with two copies of that element

	// front [1, 2, 3] back
	// becomes
	// front [1, 1, 2, 2, 3, 3] back
	public static <E> void stutter(Queue<E> input) {
		int size = input.size();
		for (int i = 0; i < size; i++) {
			E tmp = input.poll();
			input.add(tmp);
			input.add(tmp);
		}
	}

	// Method mirror that accepts a queue of strings as a parameter and appends the
	// queue's contents to itself in reverse order
	// front [a, b, c] back
	// becomes
	// front [a, b, c, c, b, a] back
	public static <E> void mirror(Queue<E> input) {
		int size = input.size();
		Stack<E> stack = new Stack<>();
		for (int i = 0; i < size; i++) {
			E ele = input.poll();
			stack.push(ele);
			input.add(ele);
		}

		for (int i = 0; i < size; i++) {
			input.add(stack.pop());
		}
	}

	// This method evaluates the value of an expression
	// i.e. 51 + (54 *(3+2)) = 321
	public static int evaluateExpression(String expression) {
		expression = expression.replaceAll("\\(", " ( ").replaceAll("\\)", " ) ").replaceAll("\\+", " + ")
				.replaceAll("\\-", " - ").replaceAll("\\*", " * ").replaceAll("\\/", " / ");

		String[] elements = expression.split("\\s+");

		Stack<Integer> operandStack = new Stack<>();
		Stack<Character> operatorStack = new Stack<>();

		for (String element : elements) {
			if (!element.isEmpty()) {
				char firstChar = element.charAt(0);

				if (Character.isDigit(firstChar) || (element.length() > 1 && Character.isDigit(element.charAt(1)))) {
					operandStack.push(Integer.parseInt(element));
				} else if (firstChar == '(') {
					operatorStack.push(firstChar);
				} else if (firstChar == ')') {
					while (operatorStack.peek() != '(') {
						performOperation(operandStack, operatorStack);
					}
					operatorStack.pop();
				} else if (isOperator(firstChar)) {
					while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(firstChar)) {
						performOperation(operandStack, operatorStack);
					}
					operatorStack.push(firstChar);
				}
			}
		}

		while (!operatorStack.isEmpty()) {
			performOperation(operandStack, operatorStack);
		}

		return operandStack.pop();
	}

	private static boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/';
	}

	private static int precedence(char operator) {
		switch (operator) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		default:
			return 0;
		}
	}

	private static void performOperation(Stack<Integer> operandStack, Stack<Character> operatorStack) {
		int operand2 = operandStack.pop();
		int operand1 = operandStack.pop();
		char operator = operatorStack.pop();

		switch (operator) {
		case '+':
			operandStack.push(operand1 + operand2);
			break;
		case '-':
			operandStack.push(operand1 - operand2);
			break;
		case '*':
			operandStack.push(operand1 * operand2);
			break;
		case '/':
			operandStack.push(operand1 / operand2);
			break;
		}
	}

	public static void main(String[] args) {
		Queue<String> input = new LinkedList<>();
		input.add("1");
		input.add("2");
		input.add("3");
		stutter(input);
		// mirror(input);
		System.out.println(input);

		String expression = "51 + (54 * (3 + 2))";
		int result = evaluateExpression(expression);
		System.out.println("Result: " + result);
	}
}
