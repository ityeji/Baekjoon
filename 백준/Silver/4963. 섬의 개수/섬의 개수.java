import java.util.Scanner;

public class Main {

	// DFS로 풀어야징

	static int[][] arr;
	static int w;
	static int h;
	static Scanner sc = new Scanner(System.in);
	static boolean[][] visited; // 박문철2
	static int count;

	// 델타 (상,하,좌,우, 좌상, 좌하, 우상, 우하)
	static int[] drow = { -1, 1, 0, 0, -1, 1, -1, 1 };
	static int[] dcol = { 0, 0, -1, 1, -1, -1, 1, 1 };

	public static void input() {
		w = sc.nextInt();
		h = sc.nextInt();

		arr = new int[h][w];
		visited = new boolean[h][w];

		for (int row = 0; row < h; row++) {
			for (int col = 0; col < w; col++) {
				arr[row][col] = sc.nextInt();
			}
		}

		count = 0;
	}

	public static void DFS(int row, int col) {
		// 일단 방문처리!
		visited[row][col] = true;

		for (int i = 0; i < 8; i++) {
			int dr = row + drow[i];
			int dc = col + dcol[i];

			// 범위 체크, 섬 체크, 방문 체크
			if (dr >= 0 && dc >= 0 && dr < h && dc < w && arr[dr][dc] == 1 && !visited[dr][dc]) {
				DFS(dr, dc);
			}
		}
	}

	public static void main(String[] args) {

		while (true) {
			input();

			if (w == 0 || h == 0) {
				break;
			}

			for (int row = 0; row < h; row++) {
				for (int col = 0; col < w; col++) {
					if (arr[row][col] == 1 && !visited[row][col]) {
						DFS(row, col);
						count++;
					}
				}
			}

			System.out.println(count);
		}
	}

}