import java.util.Scanner;
import java.util.Stack;

public class Main {

	// 분배법칙을 사용하자!

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		int mul = 1;
		int result = 0;
		Stack<Character> stack = new Stack<>();

		x: for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case '(':
				stack.push(s.charAt(i));
				mul *= 2;
				break;

			case '[':
				stack.push(s.charAt(i));
				mul *= 3;
				break;

			case ')':
				if (stack.isEmpty() || stack.peek() != '(') {
					result = 0;
					break x;
				}

				if (s.charAt(i - 1) == '(') {
					result += mul;
				}
				stack.pop();
				mul /= 2;
				break;

			case ']':
				if (stack.isEmpty() || stack.peek() != '[') {
					result = 0;
					break x;
				}

				if (s.charAt(i - 1) == '[') {
					result += mul;
				}

				stack.pop();
				mul /= 3;
				break;
			}
		}

		System.out.println(!stack.isEmpty() ? 0 : result); // 삼항 연산자
	}
}