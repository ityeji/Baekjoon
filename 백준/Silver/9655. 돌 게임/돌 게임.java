import java.util.Scanner;

public class Main {

	// 돌이 1개 -> 1개를 상근이가 들고감 (상근 w)
	// 돌이 2개 -> 첫 번째 돌 상근, 두 번째 돌 창영 (창영w)
	// 돌이 3개 -> 한 개씩 가져가도, 한 번에 상근이가 3개 가져가도 (상근w)
	// 돌이 4개 이상 -> dp[n-1] 승자의 반대가 승리

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		boolean[] dp = new boolean[n + 1]; // 다 false로 초기화되어 있음
		// 다 true로 만들고(상근이가 이겼다고 할 때), 창영이가 이겼을 때 false로 만드는 것은 불필요하게 로직 늘어남
		// 그러니, 상근이가 이겼으면 false, 창영이가 이겼으면 true로 나타내자

		if (n > 1) {
			dp[2] = true;
		}

		// 4 이상부터는 n-1의 결과의 반대!
		for (int i = 4; i <= n; i++) {
			dp[i] = !dp[i - 1];
		}

		if (dp[n]) {
			System.out.println("CY");
		} else {
			System.out.println("SK");
		}

	}

}