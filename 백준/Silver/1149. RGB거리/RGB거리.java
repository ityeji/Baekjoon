import java.util.Scanner;

public class Main {

	// 만약 내가 빨간색이라면?
	// 내 전이 초록 or 파랑
	// 이 수식을 계속 이어간다면?
	// 인접해있는 집들은 서로 같은 색일 수가 없다!!
	// 이것을 dp로 나타내보자.
	// 특별하게 2차원 배열로 나타내어서
	// [i][0](빨) = [i-1][1](초) + [i-1][2](파)
	// 위의 수식을 동일하게 [i][1] , [i][2]에도 적용하기
	// 결국 [n][0] or [n][1] or [n][2]중에서 최솟값이 정답이 된다!

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		// 인덱스가 n까지 있어야 하므로
		int[][] dp = new int[n + 1][3];

		for (int i = 1; i <= n; i++) {
			// 빨강 비용
			int r = sc.nextInt();
			// 초록 비용
			int g = sc.nextInt();
			// 파랑 비용
			int b = sc.nextInt();

			// 만약 빨강이면 -> 이 전이 초록 or 파랑 중 최소 비용
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + r; // 현재 i번째 집의 빨강일 때의 비용을 구하는 것이므로 따끈따끈하게 입력받은 r을 dp배열에
																	// 저장해줘야한다.

			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + g; // 위와 동일

			dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + b; // 위와 동일

		}

		int min = Math.min(dp[n][0], dp[n][1]);
		System.out.println(Math.min(min, dp[n][2]));

	}

}