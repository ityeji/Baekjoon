import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		// 아!!! 제한이 14이네!!! 그럼 굳이 max값 안구해줘도 되겠다
//		int maxK = 0;
//		int maxN = 0;

//		for (int i = 0; i < t; i++) {
		// 바로 15로 만들면 되니까!
		// testcase마다 배열을 만들어주면 메모리 낭비가 심해지니까
		// 아예 최댓값만큼의 dp 배열을 만들어주자
//			maxK = Math.max(maxK, sc.nextInt());
//			maxN = Math.max(maxN, sc.nextInt());
//		}

//		int[][] dp = new int[maxK + 1][maxN + 1]; // k는 층, n은 호수
		int[][] dp = new int[15][15];

		// k층 n호 -> (k-1)층 1호 + (k-1)층 2호 + ... + (k-1)층 n호
		// 일단 0층의 i호는 i명이 산다
		// n이 1이면 그게 몇 층이든 값은 1이 된다.
//		for (int i = 1; i < maxN + 1; i++) {
		for (int i = 1; i < 15; i++) {
			dp[0][i] = i;
		}
//		for (int i = 0; i < maxK + 1; i++) {
		for (int i = 0; i < 15; i++) {
			dp[i][1] = 1;
		}

		// 나머지 부분을 채워야함.
		// k층 n호 -> (k-1)층 1호 + (k-1)층 2호 + ... + (k-1)층 n호
//		for (int i = 1; i < maxK + 1; i++) { // 1층부터 maxK까지
//			for (int j = 2; j < maxN + 1; j++) { // 2호부터 maxN까지
		for (int i = 1; i < 15; i++) {
			for (int j = 2; j < 15; j++) {
				dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
				// 어차피 dp[i][j-1]는
				// dp[i-1][1] + ... + dp[i-1][j-1]일 테니까
				// 여기서 바로 dp[i-1][j]만 더해주면 됨!
			}

		}

		for (int i = 0; i < t; i++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			System.out.println(dp[k][n]);
		}

	}

}