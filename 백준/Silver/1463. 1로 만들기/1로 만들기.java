import java.util.Scanner;

public class Main {

	static Integer[] dp; // 최소 연산 횟수 저장, but, 최소 연산 횟수 0을 main 함수에서 저장해줘야하므로, int[]가 아니라, Integer[]로 배열
							// 생성해주자!

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		dp = new Integer[n + 1];
		dp[0] = dp[1] = 0; // n이 0이거나, 1이면 -> 연산 횟수는 0이니까!

		System.out.println(recur(n));

	}

	static int recur(int n) {

		// 이미 dp[0]과 dp[1]에는 0이 들어있으니
		// null일 때
		// 2로 나뉘는 경우 -> 2로 나뉠 때 최소 연산 횟수 vs 1을 뺄 때 최소 연산 횟수
		// 3으로 나뉘는 경우 -> 3으로 나뉠 때 최소 연산 횟수 vs 1을 뺄 때 최소 연산 횟수
		// 6으로 나뉘는 경우( 2*3 ) -> 3으로 나뉠 때 최소 연산 횟수 vs 2로 나뉠 때 최소 연산 횟수 vs 1을 뺄 때 최소 연산 횟수
		// 이 함수에 들어왔다는 거 자체가 2이상이므로, 연산 횟수 +1이 필수적이다!
		if (dp[n] == null) {
			// 6으로 나눠지는 경우
			if (n % 6 == 0) {
				dp[n] = Math.min(recur(n - 1), Math.min(recur(n / 3), recur(n / 2))) + 1;
			}
			// 3으로만 나눠지는 경우
			else if (n % 3 == 0) {
				dp[n] = Math.min(recur(n / 3), recur(n - 1)) + 1;
			}
			// 2로만 나눠지는 경우
			else if (n % 2 == 0) {
				dp[n] = Math.min(recur(n / 2), recur(n - 1)) + 1;
			}
			// 2와 3으로 나누어지지 않는 경우
			// 1을 뺴야한다!
			else {
				dp[n] = recur(n - 1) + 1;
			}
		}

		return dp[n];
	}

}