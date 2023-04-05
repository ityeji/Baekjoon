import java.util.Scanner;
import java.util.Stack;

public class Main {

	// 스택은 뒤에서부터 뺄 수 있으니까!!!
	// 앞으로 동일 문자열이나 그런 거 빼야하는 상황이면 stack 써야겠다...
	// 문자열을 다시 합쳐야 하는데, 스택 사용하면 그 때도 빠진 자리에 바로 채워넣으면 되는 거라...

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Stack<Character> stack = new Stack<>();

		StringBuilder sb = new StringBuilder();

		String s = sc.next();
		String boom = sc.next(); // 폭발 문자열

		// 스택에 넣어주기
		for (int i = 0; i < s.length(); i++) {
			stack.push(s.charAt(i));

			if (stack.size() >= boom.length()) {
				boolean b = true;
				for (int j = 0; j < boom.length(); j++) {
					if (stack.get(stack.size() - boom.length() + j) != boom.charAt(j)) {
						b = false;
						break;
					}
				}

				if (b) {
					for (int j = 0; j < boom.length(); j++) {
						stack.pop();
					}
				}
			}

		}

		if (stack.size() == 0) {
			sb.append("FRULA");
		} else {
			// 스트링 빌더에 담아서 한번에 뿌려주기
			for (char c : stack) {
				sb.append(c);
			}
		}

		System.out.println(sb);

	}
}