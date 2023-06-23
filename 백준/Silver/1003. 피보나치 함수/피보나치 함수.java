import java.util.Scanner;

public class Main {

	// 역시 제한 초가 짧으니
	// 다이나믹프로그래밍을 써야겠군!
	// 다이나믹프로그래밍 -> 복잡한 여러 문제를 여러 개의 간단한 문제로 나누어 풀고,
	// 그것을 결합하여 최종적인 문제를 해결한다.
	// 메모이제이션
	// 미리 계산해서 저장해 둔 결과를 활용하여 중복 연산을 줄이는 방식
	// 시간초과가 나니까, 0카운트, 1카운트를 저장할 2차원 배열 만들기

	static public int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {

			int n = sc.nextInt();

//			dp = new int[n + 1][2];
			// 자꾸 0이 입력될 때 인덱스 오류 나니까 아예 문제에서 n의 제한을 40까지로 두었으므로
			// 41개의 칸을 만들어준다(작은 숫자이니 메모리 걱정x)
			dp = new int[41][2];

			dp[0][0] = 1; // n이 0이면 0카운트 1
			dp[0][1] = 0; // n이 0이면 1카운트 0
			dp[1][0] = 0; // n이 1이면 0카운트 0
			dp[1][1] = 1; // n이 1이면 1카운트 1

			for (int j = 2; j <= n; j++) {
				dp[j][0] = dp[j - 1][0] + dp[j - 2][0];
				dp[j][1] = dp[j - 1][1] + dp[j - 2][1];
			}

			sb.append(dp[n][0] + " " + dp[n][1]);
			sb.append("\n");

		}

		System.out.println(sb);
	}

}