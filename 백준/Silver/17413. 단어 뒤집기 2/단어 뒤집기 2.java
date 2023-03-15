
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();

		Stack<Character> charStack = new Stack<>(); // 태그는 스택에 넣으면 안됨.

		StringBuilder sb = new StringBuilder(); // 공백, <>부분을 뜯어서 따로 출력할 것이기 때문에
		// 스트링빌더 이용해서 한 번에 결과값 출력

		// 한 문장을 인덱스 하나하나 탐색
		int idx = 0;

		while (idx < s.length()) {

			if (s.charAt(idx) == '<') {
				if (charStack.size() != 0) {
					while (charStack.size() > 0) { // 개인적으로,,, Stack 출력은 while로 하는 게 안헷갈리고 좋다.
						// while 범위는 charStack.size()가 0이기 전까지 (0이라는 소리는 더이상 꺼낼 stack원소가 없다는 것을 뜻함)
						sb.append(charStack.pop());
					}
				}
				while (s.charAt(idx) != '>') {

					sb.append(s.charAt(idx));
					idx++;
				}
				sb.append('>');

			} else if (s.charAt(idx) == ' ') {
				if (charStack.size() != 0) {
					while (charStack.size() > 0) {
						sb.append(charStack.pop());
					}
				}
				sb.append(' ');
			}

			else {
				charStack.push(s.charAt(idx));
			}

			idx++;
		}

		// 위의 코드는 무조건 <나 공백을 만나야 stack이 출력되는 형식임
		// 만약, 특수기호 없이 문장이 끝났을 때에도 거꾸로 문자가 출력되야함.
		// idx가 이미 입력받은 String변수의 길이를 넘었지만(==문장이 끝났지만)
		// 아직 Stack에 char가 남아있을 때
		// 이것들을 마지막에 출력해주어야함.

		if (charStack.size() != 0) {
			while (charStack.size() > 0) {
				sb.append(charStack.pop());
			}
		}

		System.out.println(sb);
	}

}
