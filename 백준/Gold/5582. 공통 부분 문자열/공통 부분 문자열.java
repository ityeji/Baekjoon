import java.util.Scanner;

public class Main {

	// dp를 이용한 문제풀이
	// 2차원 배열에 dp를 만들건데.. (크기는 +1씩! -> 대각선을 활용하기 위해서)
	// 행에는 String1, 열에는 String2
	// 연속적으로 같은 문자열 배치라면? -> dp[row+1][col+1]이 dp[row-1][col-1]보다 1 증가해있다.

	static Scanner sc = new Scanner(System.in);
	static String s1;
	static String s2;
	static int[][] dp;

	public static void input() {
		s1 = sc.next();
		s2 = sc.next();
		dp = new int[s1.length() + 1][s2.length() + 1]; // s1은 행, s2는 열
	}

	public static void solved() {

		int result = 0;

		for (int row = 1; row < s1.length() + 1; row++) {
			for (int col = 1; col < s2.length() + 1; col++) {
				if (s1.charAt(row - 1) == s2.charAt(col - 1)) {
					dp[row][col] = dp[row - 1][col - 1] + 1;
					result = Math.max(result, dp[row][col]);
				}
			}
		}

		System.out.println(result);
	}

	public static void main(String[] args) {

		input();
		solved();

	}

}