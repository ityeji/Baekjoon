
import java.util.Scanner;

public class Main {

	// 먼저 케이크 길이만큼 1m단위로 잘라서 해당하는 조각에 사람의 번호를 적어야 하므로
	// 케이크 길이만큼 일차원 배열을 만들어, 사람의 번호를 저장한다.
	// 그리고, 사람 수만큼의 이차원 배열을 만들어
	// 조각의 범위를 나타내는 숫자를 적는다.
	// 일차원 배열 안에 해당 사람 숫자를 넣고, count해서 max값 찾고, 인덱스 찾아내서 출력

	static Scanner sc = new Scanner(System.in);

	static int l; // 케이크 길이

	static int[] cakeLen; // 케이크 조각 배열

	static int n; // 사람의 수

	static int[][] wanted;

	static int max;

	static int result;

	public static void input() {

		// 케이크 길이 입력 받기
		l = sc.nextInt();

		// 케이크 길이만큼 배열 만들기
		cakeLen = new int[l + 1];

		// 사람 수 입력 받기
		n = sc.nextInt();

		// 사람 수만큼 일차원 배열 만들기
		wanted = new int[n][2];

		// 범위 입력 받기
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < 2; col++) {
				wanted[row][col] = sc.nextInt();
			}
		}

		solved();
	}

	public static void solved() {
		max = 0;
		result = 0;

		for (int i = 0; i < n; i++) {
			int tmp = wanted[i][1] - wanted[i][0];
			if (max < tmp) {
				max = tmp;
				result = i + 1;
			}
		}

		System.out.println(result);

		result = 0; // result 다시 초기화
		max = 0; // max 다시 초기화

		for (int i = 1; i <= n; i++) {
			int count = 0;

			for (int j = wanted[i - 1][0]; j <= wanted[i - 1][1]; j++) {
				if (cakeLen[j] == 0) {
					cakeLen[j] = i;
					count++;
				}

				if (max < count) {
					max = count;
					result = i;
				}
			}

		}

		System.out.println(result);

	}

	public static void main(String[] args) {
		input();
	}

}
