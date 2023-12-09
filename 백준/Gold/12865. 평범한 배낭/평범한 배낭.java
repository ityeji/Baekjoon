import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int k;
	static int[] w;
	static int[] v;
	static int maxValue;
	static int[][] dp;

	public static void inputBox(int n) {

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				// 기본값은 이전 dp값을 가져가는 걸로 (메모이제이션)
				dp[i][j] = dp[i - 1][j];
				if (j - w[i] >= 0) { // 무게에서 자신의 무게를 뺐을 때, 남는 무게가 존재하면
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
					// i - 1는 이전 아이템까지의 최적 조합(이전 아이템까지를 사용해서)
					// j - w[i]는 부족한 무게에 따른 최적 가치
					// (그런 최적 조함 + 현재 나의 가치) vs (이전 아이템까지의 최적 조합)
				}
			}
		}

	}

	public static void main(String[] args) {

		int n = sc.nextInt();
		k = sc.nextInt();
		w = new int[n + 1];
		v = new int[n + 1];
		dp = new int[n + 1][k + 1]; // n은 아이템 순서, k는 1씩 늘어나는 무게

		for (int i = 1; i <= n; i++) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}

		inputBox(n);

		System.out.println(dp[n][k]);

	}

}