import java.util.Scanner;

public class Main {

	// dp로 풀기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[][] arr = new int[n][n]; // 뜀박질 범위 저장

		long[][] dp = new long[n][n]; // 경로 가짓수 저장

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				arr[row][col] = sc.nextInt();
			}
		}

		// 첫 번째 경로부터 시작할 것이니, dp[0][0]에 1 넣기
		dp[0][0] = 1;

		// 풀이 시작
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {

				// 경로 가짓수가 0이라면, 아무곳으로부터로도 오지 않는다는 얘기로 -> 볼필요
				if (dp[row][col] == 0) {
					continue; // 다른 것들 탐색해서 경로가 1이상인 것들만 확인하자
				}

				// 반드시 오른쪽이나, 아래쪽으로만 이동
				// 먼저 이동 범위 입력 받기
				int tmp = arr[row][col];

				// 0이면? 도착점 -> 멈췃!
				if (tmp == 0) {
					break;
				}

				// 범위 안이면? 점프하고 전의 경로수와 나의 경로수 저장
				// 결국 그러면, 그 전의 노드에 2개의 경로가 있고, 내가 1개의 경로가 있었으면 -> 나는 총 3개의 경로를 가지고 있는 것!

				// 오른쪽
				if (col + tmp < n) {
					dp[row][col + tmp] += dp[row][col];
				}

				// 아래쪽
				if (row + tmp < n) {
					dp[row + tmp][col] += dp[row][col];
				}
			}
		}

		System.out.println(dp[n - 1][n - 1]);

	}

}