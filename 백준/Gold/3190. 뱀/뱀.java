import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	// 덱과,,, 큐...?
	// 아하, 덱은 앞뒤로 들어가고 나오고가 자유롭구나!

	static Scanner sc = new Scanner(System.in);
	static int n; // 보드의 크기
	static int[][] map; // 보드
	static int[] times; // x초가 끝난 뒤에 왼쪽 또는 오른쪽으로 방향 회전
	static char[] direc; // 방향
	static Queue<int[]> snake; // 뱀의 위치
	static boolean[][] visited;

	// 델타(상우하좌)
	static int[] drow = { -1, 0, 1, 0 };
	static int[] dcol = { 0, 1, 0, -1 };

	public static void input() {
		n = sc.nextInt();

		int k = sc.nextInt(); // 사과 개수

		map = new int[n + 2][n + 2];

		visited = new boolean[n + 2][n + 2];

		snake = new LinkedList<>();

		// 벽을 -1로 만들어주기
		for (int i = 0; i < n + 2; i++) {
			map[0][i] = -1;
			map[i][0] = -1;
			map[n + 1][i] = -1;
			map[i][n + 1] = -1;
		}

		// 사과가 있는 곳은 1로 만들어주기
		for (int i = 0; i < k; i++) {
			map[sc.nextInt()][sc.nextInt()] = 1;
		}

		int l = sc.nextInt(); // 뱀의 방향 변환 횟수

		times = new int[l];
		direc = new char[l];

		for (int i = 0; i < l; i++) {
			times[i] = sc.nextInt();
			direc[i] = sc.next().charAt(0);
		}

	}

	public static void solved() {

		// 1,1에 뱀 위치
		int row = 1;
		int col = 1;

		int deltaIdx = 1; // 오른쪽 방향으로 시작함(델타 인덱스 1번)

		int second = 0;

		int timeIdx = 0; // 일정 시간마다 방향 바꾸기

		visited[row][col] = true;

		snake.offer(new int[] { row, col });

		while (true) {

			// 한칸 이동
			row += drow[deltaIdx];
			col += dcol[deltaIdx];

			// 시간 재기
			second++;

			// 만약? -1이거나(벽에 닿거나) 뱀이 있는 위치라면?
			// 게임 끝!
			if (map[row][col] == -1 || visited[row][col]) {
				break;
			}

			// 일단, 방문체크 해주고 큐에 offer해주기
			snake.offer(new int[] { row, col });
			visited[row][col] = true;

			// 사과가 있다면 사과 없어지고, 꼬리 그대로
			if (map[row][col] == 1) {
				map[row][col]--;
			} else {
				// 사과가 없다면, 꼬리가 위치한 칸을 비워주기
				// poll하기
				// 그리고 현재 뱀이 그 자리에 없으니까, 방문처리 false로 변경
				int[] tail = snake.poll();

				visited[tail[0]][tail[1]] = false;
			}

			// 현재 시간과 방향 전환 시간이 같으면?
			// x초가 끝난 후 왼쪽 or 오른쪽

			if (second == times[timeIdx]) {
				if (direc[timeIdx] == 'L') {
					deltaIdx--;
				} else {
					deltaIdx++;
				}
				timeIdx++;

				if (timeIdx >= times.length) {
					timeIdx = times.length - 1;
				}

				if (deltaIdx == 4) {
					deltaIdx = 0;
				} else if (deltaIdx == -1) {
					deltaIdx = 3;
				}
			}

		}

		System.out.println(second);

	}

	public static void main(String[] args) {

		input();

		solved();

	}

}