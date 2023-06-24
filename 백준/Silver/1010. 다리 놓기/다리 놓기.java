import java.util.Scanner;

public class Main {

	// DFS로 풀어서 시간초과가 났으니...
	// 조합 공식에 DP를 적용해서 풀자
	// nC0 = 1, nCn = 1, nC1 = n
	// nCr = nCn-r
	// nCr = n-1Cr + n-1Cr-1 -> 애를 dp로 만들기
	// dp[i][j] = dp[i-1][j]+dp[i-1][j-1]

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		int[][] dp = new int[31][31]; // 범위는 31까지이므로
		dp[0][0] = 1;
		dp[0][0] = 1;

		for (int i = 1; i <= 30; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
				}
			}
		}

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			System.out.println(dp[m][n]);

		}

	}

}