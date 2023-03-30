import java.util.Scanner;

public class Main {
	// 미로찾기로 풀면 되겟넹
	// 1인 경로 찾기!
	// 델타 만들어서
	// DFS!

	static Scanner sc = new Scanner(System.in);

	static int m; // 배추밭의 가로 길이

	static int n; // 배추밭의 세로 길이

	static int[][] map; // 배추밭

	static boolean[][] visited; // 방문 체크

	static int count; // 배추희지렁이 몇 마리?

	// 델타(상하좌우)
	static int[] drow = { -1, 1, 0, 0 };
	static int[] dcol = { 0, 0, -1, 1 };

	public static void input() {
		m = sc.nextInt();

		n = sc.nextInt();

		map = new int[n][m]; // 세로 개수가 행, 가로 개수가 열

		visited = new boolean[n][m];

		count = 0;

		int k = sc.nextInt(); // 배추가 심어져 있는 위치 개수

		for (int i = 0; i < k; i++) {
			int y = sc.nextInt();
			int x = sc.nextInt();

			map[x][y] = 1;
		}

		solved();
	}

	public static void solved() {

		// 이중 for문 돌려서 출발점을 각가 다르게 하기
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {

				// map[row][col] == 1이면 DFS 실행하도록
				if (map[row][col] == 1 && !visited[row][col]) {
					DFS(row, col);
					count++;
				}

			}
		}
	}

	public static void DFS(int row, int col) {

		visited[row][col] = true;

		for (int i = 0; i < 4; i++) {
			int dr = row + drow[i];
			int dc = col + dcol[i];

			if (dr >= 0 && dc >= 0 && dr < n && dc < m && !visited[dr][dc] && map[dr][dc] == 1) {
				DFS(dr, dc);
			}
		}

	}

	public static void main(String[] args) {

		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			input();

			System.out.println(count);
		}

	}

}