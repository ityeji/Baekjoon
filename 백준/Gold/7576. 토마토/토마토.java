import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	// 하루가 지나면 -> 상,하,좌,우의 익지않은 토마토(0)는 익은 토마토(1)의 영향을 받아 익게됨
	// 최소 날짜를 출력해야하므로 -> BFS
	// BFS에서 dist 배열 썼던 것처럼 -> 똑같이 활용하면 됨!
	// 그런데, 따로 dist 배열 사용하지 않고, 그 배열에 그대로 저장해도 무관!

	static int n; // 행
	static int m; // 열
	static int[][] map;
	// BFS 사용할 거니까~ 큐 활용!
	static Queue<int[]> queue = new LinkedList<>();
	static int max;

	// 델타 (상하좌우)
	static int[] drow = { -1, 1, 0, 0 };
	static int[] dcol = { 0, 0, -1, 1 };

	public static void BFS() {
		while (!queue.isEmpty()) { // 큐가 빌 때까지
			int[] tmp = queue.poll();
			int row = tmp[0]; // row 저장
			int col = tmp[1]; // col 저장

			for (int i = 0; i < 4; i++) {
				int dr = row + drow[i];
				int dc = col + dcol[i];

				if (dr >= 0 && dr < n && dc >= 0 && dc < m && map[dr][dc] == 0) {
					map[dr][dc] = map[row][col] + 1;
					queue.offer(new int[] { dr, dc });
				}
			}
		}

		System.out.println(solved());
	}

	public static boolean checkZero() {
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				if (map[row][col] == 0) {
					return true;
				}
			}
		}

		return false;
	}

	public static int solved() {

		// 0이 있으면 모두 익지 못한 상황이므로 -1 리턴
		if (checkZero()) {
			return -1;
		}

		// 0이 없으면, max값 찾아서 출력해주기
		max = 0;
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				if (max < map[row][col]) {
					max = map[row][col];
				}
			}
		}

		return max - 1; // 만약, 하루가 지나서 상하좌우의 토마토가 익었다면
		// map에 저장되어 있는 수는 2이지만,
		// 하루 지났으므로 답에는 1이 나와야한다.
		// 그래서 1씩 빼주는 것. (1부터 시작해서 1씩 커지는 식으로 로직을 구성했으므로)

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		m = sc.nextInt();
		n = sc.nextInt();

		map = new int[n][m];

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				map[row][col] = sc.nextInt();
			}
		}

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				if (map[row][col] == 1) {
					queue.offer(new int[] { row, col });
				}
			}
		}

		BFS();

	}

}