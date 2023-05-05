
import java.util.Scanner;

public class Main {
	// 다이나믹프로그래밍
	// 1개일 때 4, 2개일 때 6, 3개일 때 10, 4개일 때 16, 5개일 때 26, 6개일 때 42, 7개일 때 68
	// 이걸 보면...
	// n = n-2 + n-1
	// 이걸 dp로 풀어보자!

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		long[] dp = new long[n + 1];

		dp[0] = 2;
		dp[1] = 4;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}

		System.out.println(dp[n]);

	}

}
