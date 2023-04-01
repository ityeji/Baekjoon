import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	static int[][] map; // 도화지

	static boolean[][] visited; // 박문철2

	static int count; // 그림의 개수

	static int area; // 1을 세면 자연스럽게 그림의 넓이를 알 수 있다.

	static int result; // 가장 넓이가 넓은 그림의 넓이는?

	// 델타 배열
	static int[] drow = { -1, 1, 0, 0 }; // 상하좌우 행
	static int[] dcol = { 0, 0, -1, 1 }; // 상하좌우 열

	public static void input() {

		int n = sc.nextInt();
		int m = sc.nextInt();

		map = new int[n][m];

		visited = new boolean[n][m];

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				map[row][col] = sc.nextInt();
			}
		}
	}

	public static void solved() {

		result = 0;
		count = 0;

		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[0].length; col++) {
				area = 0;
				if (!visited[row][col] && map[row][col] == 1) {
					DFS(row, col);
					count++;
					result = Math.max(result, area);
				}
			}
		}
	}

	public static void DFS(int x, int y) {

		area++;
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int dr = x + drow[i];
			int dc = y + dcol[i];

			// 인덱스 제약, 방문 여부, 1인지 여부
			if (dr >= 0 && dc >= 0 && dr < map.length && dc < map[x].length && !visited[dr][dc] && map[dr][dc] == 1) {

				visited[dr][dc] = true;
				DFS(dr, dc);
			}
		}
	}

	public static void main(String[] args) {

		input();

		solved();

		System.out.println(count);
		System.out.println(result);

	}

}