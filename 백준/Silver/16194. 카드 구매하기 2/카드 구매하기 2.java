import java.util.Scanner;

public class Main {

	// dp...!
	// if) n = 2
	// 1 + 1
	// if) n = 3
	// 1 + 2
	// if) n = 4
	// 1 + 3 || 2 + 2
	// 카드가 n개 있는 카드집을 샀을 때와, n보다 적은 것들을 산 것을 합친 가격을 비교해서
	// 더 작은 것 dp배열에 넣어주기

	static Scanner sc = new Scanner(System.in);

	static int n;
	static int[] dp;

	public static void solved() {
		n = sc.nextInt();
		dp = new int[n + 1]; // 인덱스 활용할 거니까!
		for (int i = 1; i <= n; i++) {
			dp[i] = sc.nextInt();
			for (int j = 1; j <= i / 2; j++) {
				dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
			}
		}

	}

	public static void main(String[] args) {
		solved();
		System.out.println(dp[n]);

	}

}