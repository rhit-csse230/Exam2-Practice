package evaluator;

import java.util.Scanner;
import java.util.Stack;

public class InfixEvaluator extends Evaluator {

	@Override
	public int evaluate(String expression) throws ArithmeticException {
		// TODO Read the functions defined below.
		// Then implement this function.  No more than two lines of code are needed!
		return 0;
	}

	public String convertToPostfix(String exp) {
		Scanner scanner = new Scanner(exp);
		Stack<String> stack = new Stack<String>();
		StringBuilder sb = new StringBuilder();

		String token, top;

		while (scanner.hasNext()) {
			token = scanner.next();
			try {
				Integer.parseInt(token);
				sb.append(token + " ");
			} catch (NumberFormatException e) {
				try {
					if (token.equals("(")) {
						stack.push(token);
						continue;
					} else if (token.equals(")")) {
						while (true) {
							top = stack.pop();
							if (top.equals("(")) {
								break;
							} else {
								sb.append(top + " ");
							}
						}
					} else {
						while (true) {
							if (stack.isEmpty() || stack.peek().equals("(")
									|| this.hasLowerPrecedence(stack.peek(), token)) {
								stack.push(token);
								break;
							} else {
								top = stack.pop();
								sb.append(top + " ");
							}
						}
					}
				} catch (Exception e2) {
					scanner.close();
					throw new ArithmeticException();
				}
			}
		}
		scanner.close();
		while (!stack.isEmpty()) {
			top = stack.pop();
			if (top.equals("(")) {
				throw new ArithmeticException();
			}
			sb.append(top + " ");
		}

		return sb.toString().trim();
	}

	private boolean hasLowerPrecedence(String op1, String op2) {
		return getPrecedence(op1) < getPrecedence(op2);
	}

	private int getPrecedence(String op) {
		if ("(".contains(op)) {
			return 5;
		}
		if ("^".contains(op)) {
			return 4;
		}
		if ("*/".contains(op)) {
			return 3;
		}
		if ("+-".contains(op)) {
			return 2;
		}
		if (")".contains(op)) {
			return 1;
		}
		return 0;
	}
}
