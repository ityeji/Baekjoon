import java.util.Scanner;

public class Main {

	// 가방 문제!
	// DP 활용!
	// 재귀로도 풀 수 있음! (구글링 필요)

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		// dp는 대부분 배열의 크기를 n+1로 둔다
		int[] energy = new int[n + 1];
		int[] joy = new int[n + 1];

		int[][] dp = new int[n + 1][100];

		// 입력
		for (int i = 1; i <= n; i++) {
			energy[i] = sc.nextInt();
		}

		for (int i = 1; i <= n; i++) {
			joy[i] = sc.nextInt();
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= 99; j++) {
				// i번한테 인사를 할 수 있는 경우
				if (energy[i] <= j) {
					// i한테 인사 안하는 경우, i한테 인사하는 경우 중 최대값을 dp에 저장하기
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - energy[i]] + joy[i]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		System.out.println(dp[n][99]);

	}

}