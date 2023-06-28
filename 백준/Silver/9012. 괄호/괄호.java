import java.util.Scanner;
import java.util.Stack;

public class Main {

	// '('모양이면 stack쌓기
	// ')'모양이면 stack에서 pop
	// 만약, 다 입력 받았는데 stack.size() == 0이면 yes
	// 다 입력 받지도 않았는데 이미 stack.size()==0이면 no
	// 다 입력 받았는데 stack.size() > 0이면 no

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			String s = sc.next();
			System.out.println(solved(s));
		}

	}

	public static String solved(String s) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			// '('은 stack 쌓기
			if (c == '(') {
				stack.push(c);
			} else if (stack.empty()) {
				// c가 ')'인데 이미 stack.size()==0
				return "NO";
			} else {
				// c가 ')'인데 stack.size()도 0이 아니면?
				stack.pop();
			}
		}

		// 다 완료했는데 stack.size()가...
		if (stack.empty()) {
			return "YES";
		} else {
			return "NO";
		}
	}

}