import java.util.Scanner;

public class Main {

	// 다이나믹프로그래밍
	// 먼저 입력받은 배열만큼 합을 저장할 디피 배열 만들기
	// 가장 말단의 원소(더해지지 않고 입력 받은 그대로)를 디피 배열에 저장하기
	// top-down방식으로 접근
	// 두 개중 Max일 때를 찾아서 그 max값과 자신을 더해서 디피 배열에 저장

	static Scanner sc = new Scanner(System.in);

	static int n; // 삼각형의 크기

	static int[][] tri;

	static int[][] dp; // 같은 크기의 dp 배열 생성

	public static void input() {

		n = sc.nextInt();

		tri = new int[n][n];

		dp = new int[n][n];

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < row + 1; col++) {
				tri[row][col] = sc.nextInt();
			}
		}

		// 디피 배열 -1로 초기화
		// 해당 tri배열 원소가 0포함이므로 -1로 초기화해줘야한다.
		// 나중에 탐색했던 부분은 재탐색 하지 않기 위해 조건문을 줘야하니까

		for (int row = 0; row < n - 1; row++) {
			for (int col = 0; col < row + 1; col++) {
				dp[row][col] = -1;
			}
		}

		// 디피에 복사
		for (int col = 0; col < n; col++) {
			dp[n - 1][col] = tri[n - 1][col];
		}

		System.out.println(searchMax(0, 0));
	}

	public static int searchMax(int row, int col) { //

		if (row == n - 1) {
			return dp[row][col];
		}

		if (dp[row][col] == -1) { // 탐색하지 않은 부분만 연산해야줘야 하므로
			// 미리 본문에서 dp배열을 -1로 초기화해주자 -> -1이라는 말은? 건들이지 않았다는 것!
			dp[row][col] = Integer.max(searchMax(row + 1, col), searchMax(row + 1, col + 1)) + tri[row][col];
		}
		return dp[row][col];
	}

	public static void main(String[] args) {

		input();

	}

}