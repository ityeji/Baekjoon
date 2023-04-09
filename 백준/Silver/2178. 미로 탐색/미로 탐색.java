import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	// 미로찾기 최단 경로를 구하려면?
	// BFS!
	// 시작 정점의 자식 노드들을 먼저 모두 차례로 방문한 후에 방문했던 자식 노드들을 시작점으로 하여 다시 해당 노드의 자식 노드들을 차례로
	// 방문하는 방식
	// 갈림길에서 깊게 탐색했다가 다시 돌아오는 것이 아닌(DFS)
	// 가능한 경로로 한 번에 퍼지는 느낌(BFS)
	// 큐 활용

	static Scanner sc = new Scanner(System.in);

	static int n;

	static int m;

	static int[][] map;

	static int[][] dist; // 누적 길이를 저장할 배열

	static Queue<int[]> queue; // 좌표 저장할 큐(메모제이션)

	// 델타 (상하좌우)
	static int[] drow = { -1, 1, 0, 0 };
	static int[] dcol = { 0, 0, -1, 1 };

	public static void input() {
		n = sc.nextInt();

		m = sc.nextInt();

		map = new int[n][m];

		dist = new int[n][m];

		queue = new LinkedList<>();

		for (int row = 0; row < n; row++) {
			String s = sc.next();
			for (int col = 0; col < m; col++) {
				map[row][col] = s.charAt(col) - '0';
			}
		}
	}

	public static void BFS(int row, int col) {

		int distance = 0;

		queue.offer(new int[] { row, col, distance + 1 });
		// 0번 인덱스 -> x좌표, 1번 인덱스 -> y좌표, 2번 인덱스 -> 누적 거리

		while (!queue.isEmpty()) {

			// 정점 꺼내기
			int[] tmp = queue.poll();

			// 델타 돌면서 재귀 하기
			for (int i = 0; i < 4; i++) {
				int dr = tmp[0] + drow[i];
				int dc = tmp[1] + dcol[i];

				// 벽체크, 방문 체크(dist배열로), 범위 체크
				// 인접해있고, 경로라면?
				// queue에 넣어주자!
				if (dr >= 0 && dr < n && dc >= 0 && dc < m && map[dr][dc] == 1 && dist[dr][dc] == 0) {
					queue.offer(new int[] { dr, dc, tmp[2] + 1 });
					dist[dr][dc] = tmp[2] + 1;
				}
			}

		}
	}

	public static void main(String[] args) {

		input();
		BFS(0, 0);
		System.out.println(dist[n - 1][m - 1]);

	}

}