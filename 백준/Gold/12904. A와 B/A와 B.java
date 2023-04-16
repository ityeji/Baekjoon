import java.util.Scanner;

public class Main {

	// S -> T가 아니라,
	// T -> S로 만들자!
	// 시간 절약!

	// T의 뒤의 글자가 A면 빼주고,
	// B면 빼주고 reverse!
	// 이것을 S.length == T.length일 때까지!
	// reverse(문자열 뒤집기)와 deleteCharAt(문자열에서 문자 제거)는 StringBuffer의 기본 문법!
	// deleteCharAt(문자 위치)

	static Scanner sc = new Scanner(System.in);
	static StringBuffer s1 = new StringBuffer();
	static StringBuffer s2 = new StringBuffer();

	public static void input() {
		s1.append(sc.next());
		s2.append(sc.next());
	}

	public static void solved() {

		while (s1.length() < s2.length()) {
			if (s2.charAt(s2.length() - 1) == 'A') {
				s2.deleteCharAt(s2.length() - 1);
			}

			else if (s2.charAt(s2.length() - 1) == 'B') {
				s2.deleteCharAt(s2.length() - 1);
				s2.reverse();
			}
		}

		int result = 0;

		String s1ToString = s1.toString();
		String s2ToString = s2.toString();

		if (s1ToString.equals(s2ToString)) { // StringBuffer클래스의 equals 메소드는 오버라이딩 되지 않아서
			// ==와 같다(주소값)
			// 그래서, toString을 해준 값을 String에 담아서
			// equals 메소드를 이용해 일치 여부를 판단해야한다.
			result = 1;
		}

		System.out.println(result);
	}

	public static void main(String[] args) {

		input();
		solved();

	}

}