import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		// T는 5이하이므로 배열 크기를 넉넉하게 주기
		// 일수
		int[] day = new int[n + 6];

		// 금액
		int[] pay = new int[n + 6];

		// DP
		// pay의 최대의 경우를 저장하는 배열
		int[] dp = new int[n + 6];

		for (int i = 1; i <= n; i++) {
			day[i] = sc.nextInt();
			pay[i] = sc.nextInt();
		}

		// 뒤에서부터 DP 만들어주기

		for (int i = n; i > 0; i--) {
			if (i + day[i] > n + 1) {
				// i번째 날 상담을 시작해버리면, n을 넘어버릴 때
				dp[i] = dp[i + 1];
				// 어차피 i번째날 상담은 못잡으니까
				// 뒷날의 최대값이 곧 i번째날의 최대값
			} else {
				dp[i] = Math.max(dp[i + 1], pay[i] + dp[i + day[i]]); // max값 갱신해서 넣어주기
			}
		}

		System.out.println(dp[1]); // 1일부터 n일까지의 최대값

	}

}