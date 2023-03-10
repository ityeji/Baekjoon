
import java.util.Scanner;

public class Main {

	// 먼저, 행, 열을 구하기 위해
	// for문 돌려서 입력받은 String.length()를 나눠
	// 나머지가 0이 되는 것 중 가장 큰 값을 구해서
	// 그 큰 값을 행, 그 행의 숫자로 나눈 몫을 열로 둔다
	// 그리고 이차원 배열을 만들어(char) char형태로 만들어 주고
	// 이중 for문 만들어, 열은 고정, 행은 변화하게끔 만들어
	// 암호를 해독한다.

	static Scanner sc = new Scanner(System.in);

	static String message; // 메시지 입력 받기

	static char[][] code;

	public static void solved() {
		int max = 0; // 입력받은 메시지의 행을 구하려면
		// 나눌 수 있는 수의 최댓값을 구해야함.

		// for문으로 나눌 수 있는 최대의 값 구하기
		for (int i = 1; i <= message.length(); i++) { // 극단의 경우 자기 자신의 길이 * 1
			int j = message.length() / i;
			if (j < i) {
				break; // 주어진 조건문에서, 행 <= 열 이므로
				// 행(i)이 커지는 순간 for문 아웃.
			}
			if (message.length() % i == 0 && max < i) {
				max = i;
			}
		}

		// 그러면, max는 행의 크기가 된다.

		// 자연스럽게, message.length() / max를 하면 열의 크기가 나온다.

		int c = message.length() / max;

		// 행렬을 구했으니, 2차원 배열에 입력받은 message를 char로 나눠 담아보자

		// 먼저, 2차원 배열 만들어보자
		code = new char[max][c];

		// 2차원 배열에 담아보자
		// 일단, charAt에 넣어줄 인덱스 값이 따로 필요햇
		int idx = 0;

		// 올바른 문자를 행, 열 반대로 해서 저장해줬으므로
		// 다시 행, 열 반대로 해서 저장해주기
		for (int row = 0; row < c; row++) {
			for (int col = 0; col < max; col++) {
				code[col][row] = message.charAt(idx++); // 하나의 char를 뽑을 때마다 뽑을 위치를 변경해주기(idx++)
			}
		}

		// 열 별로 읽었으니, 거꾸로 행 별로 읽으면 됨!
		for (int row = 0; row < max; row++) {
			for (int col = 0; col < c; col++) {
				System.out.print(code[row][col]);// 하나의 char를 뽑을 때마다 뽑을 위치를 변경해주기(idx++)
			}
		}
	}

	public static void main(String[] args) {

		message = sc.next();

		solved();

	}

}
