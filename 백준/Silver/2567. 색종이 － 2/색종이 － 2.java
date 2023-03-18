
import java.util.Scanner;

public class Main {

	// 색종이를 1로 채우고
	// 완전 탐색을 하면서 본인이 1이고 주변이 0이면 -> 둘레

	static Scanner sc = new Scanner(System.in);

	static int[][] map = new int[101][101];

	// 델타 배열
	static int[] dRow = { -1, 1, 0, 0 };
	static int[] dCol = { 0, 0, 1, -1 };

	// 둘레 재기
	static int cnt;

	public static void input() {

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {

			int x = sc.nextInt();

			int y = sc.nextInt();

			for (int row = x; row < x + 10; row++) {
				for (int col = y; col < y + 10; col++) {
					map[row][col] = 1;
				}
			}
		}

		solved();
	}

	public static void solved() {

		for (int row = 1; row <= 100; row++) {
			for (int col = 1; col <= 100; col++) {
				if (map[row][col] == 1) {
					for (int k = 0; k < 4; k++) {
						int drow = row + dRow[k];
						int dcol = col + dCol[k];

						if (drow >= 1 && drow <= 100 && dcol >= 1 && dcol <= 100 && map[drow][dcol] == 0) {
							cnt++;
						} else if (drow < 1 || drow > 100 || dcol < 1 || dcol > 100) {
							cnt++;
						}
					}
				}
			}
		}

		System.out.println(cnt);
	}

	public static void main(String[] args) {
		input();

	}

}
