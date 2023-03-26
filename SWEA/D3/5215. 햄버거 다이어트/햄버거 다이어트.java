import java.util.Scanner;

public class Solution {

	static Scanner sc = new Scanner(System.in);

	static StringBuilder sb = new StringBuilder();

	static int n; // 재료의 수

	static int l; // 제한 칼로리

	static int[][] ingre; // 맛에 대한 점수와 칼로리 나타냄

	static int max; // 최대 점수는?

	/////////////////////////////////////////////////

	static int[] scores; // 조합 넣을 점수

	static int[] kcals; // 조합 넣을 칼로리

	///////////////////////////////////////////////////

	public static void input() {
		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {

			n = sc.nextInt();

			l = sc.nextInt();

			ingre = new int[n][2]; // 1열은 점수, 2열은 칼로리
			// 제한 칼로리 사용하려면 2열 사용
			// 나중에 점수 구할 때는 1열 사용

			for (int row = 0; row < n; row++) {
				for (int col = 0; col < 2; col++) {
					ingre[row][col] = sc.nextInt();
				}
			}

			max = Integer.MIN_VALUE;

			//////////////////////////////////////////
			for (int r = 1; r < n + 1; r++) { // 조합으로 다 뽑아봐야하니까 반복문 사용
				scores = new int[r];
				kcals = new int[r];
				combi(0, 0, r); // r만큼 뽑는 조합 함수에 넣어주기
				// 반복문에 의해 1씩 증가
			}
			/////////////////////////////////////////////
			sb.append("#" + tc + " " + max + "\n");
		}
	}

	public static void combi(int idx, int sidx, int r) {

		// max 걸러야함.

		if (sidx == r) { // 다 뽑았어

			int kcalSum = 0; // 칼로리 합

			int scoreSum = 0; // 점수 합

			// 칼로리 다 더해서 제한 칼로리 넘는지 확인
			for (int i = 0; i < sidx; i++) {
				kcalSum += kcals[i];
			}

			if (kcalSum <= l) {
				// 점수 다 더해서 max값 갱신
				for (int i = 0; i < sidx; i++) {
					scoreSum += scores[i];
				}

				max = Math.max(max, scoreSum);
			}

			return;
		}

		if (idx == n) {
			return;
		}

		scores[sidx] = ingre[idx][0]; // 점수 넣기
		kcals[sidx] = ingre[idx][1]; // 칼로리 넣기

		combi(idx + 1, sidx + 1, r);
		combi(idx + 1, sidx, r);

	}

	public static void main(String[] args) {

		input();
		System.out.println(sb);

	}

}