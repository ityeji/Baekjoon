import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	// 스택을 사용하라고...?

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String input = sc.next();

		Stack<Character> stack = new Stack<>(); // 원본 스택
		Stack<Character> tmpstack = new Stack<>(); // 임시로 담을 스택

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < input.length(); i++) {
			stack.push(input.charAt(i));
		}

		int m = sc.nextInt();

		int cursor = stack.size(); // 맨 뒤에 위치

		for (int i = 0; i < m; i++) {
			char c = sc.next().charAt(0);
			char tmpchar = ' ';

			switch (c) {
			case 'L':
				if (!stack.isEmpty()) {
					tmpchar = stack.pop();
					tmpstack.push(tmpchar);
				}
				break;
			case 'D':
				if (!tmpstack.isEmpty()) {
					tmpchar = tmpstack.pop();
					stack.push(tmpchar);
				}
				break;
			case 'B':
				if (!stack.isEmpty()) {
					stack.pop();
				}
				break;
			case 'P':
				stack.push(sc.next().charAt(0));
				break;
			}
		}

		// stack에 있는 것을 tmpstack에 다 옮기기
		while (!stack.isEmpty()) {
			tmpstack.push(stack.pop());
		}

		// tmpstack에 있는 원소 빼기
		while (!tmpstack.isEmpty()) {
			sb.append(tmpstack.pop());
		}

		System.out.println(sb);

	}

}