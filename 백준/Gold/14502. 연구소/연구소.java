import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	// 1을 세개 세우는 로직 하나
	// 원소가 0이면 1세우기
	// 벽세우기 == 완전탐색 == 백트래킹 == 재귀(DFS)

	// 0이면 2로 채우는 로직 하나

	// 0을 세어서 Max 갱신하는 로직 하나

	static Scanner sc = new Scanner(System.in);
	static int[][] map; // 원본 맵
	static int n; // 세로 크기
	static int m; // 가로 크기
	static Queue<int[]> queue; // 좌표 저장할 큐
	static int max; // max값 갱신

	// 델타 (상,하,좌,우)
	static int[] drow = { -1, 1, 0, 0 };
	static int[] dcol = { 0, 0, -1, 1 };

	// 입력 받기
	public static void input() {
		n = sc.nextInt();
		m = sc.nextInt();
		max = 0;

		map = new int[n][m];

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				map[row][col] = sc.nextInt();
			}
		}

		DFS(0);
	}

	// 1을 세 개 세우자
	public static void DFS(int depth) { // depth는 벽이 몇 개 세워졌는지를 뜻함.
		// 기저조건
		// 벽 3개 세웠으면 바이러스 뿌리고 안전지대 구하자!!
		if (depth == 3) {
			BFS();
			return;
		}

		// 지금까지 세워진 벽이 3개가 아니라면?
		// 3개 세우자!
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1; // 벽 세우기
					DFS(depth + 1); // 벽 하나 추가!
					// 다른 곳에도 벽 세워봐야지
					map[i][j] = 0; // 재귀에서는 돌려놓는 것이 중요!
				}
			}
		}
	}

	// 0을 2로 바꾸기
	// 그러나, 1 만나면 다음 0은 보지 않는다!
	// BFS!
	// for문 돌려가며 원소가 2이면 미리 만들어놓은 BFS에 row와 col을 인자값으로 주기
	// for문 끝나면 0세기

	public static void BFS() {

		// 원본을 건들면 안되니까 map 복사하기
		int[][] copyMap = new int[n][m];

		queue = new LinkedList<>();

		// map 복사하기
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				copyMap[row][col] = map[row][col];
			}
		}

		// 바이러스면 큐에 넣기
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				if (copyMap[row][col] == 2) {
					queue.offer(new int[] { row, col });
				}
			}
		}

		while (!queue.isEmpty()) {
			// 정점 꺼내기
			int[] tmp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int dr = tmp[0] + drow[i];
				int dc = tmp[1] + dcol[i];

				// 벽체크, 방문체크, 범위체크
				if (dr >= 0 && dr < n && dc >= 0 && dc < m && copyMap[dr][dc] == 0) {
					queue.offer(new int[] { dr, dc });
					copyMap[dr][dc] = 2;
				}
			}
		}

		outputResult(copyMap);
	}

	public static void outputResult(int[][] copyMap) {
		int vir = 0;

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				if (copyMap[row][col] == 0) {
					vir++;
				}
			}
		}
		max = Integer.max(vir, max);
	}

	public static void main(String[] args) {
		input();
		System.out.println(max);
	}

}