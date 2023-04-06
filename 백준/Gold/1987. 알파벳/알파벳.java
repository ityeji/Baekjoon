import java.util.Scanner;

public class Main {

	static int r; // 세로

	static int c; // 가로

	static char[][] map;

	static boolean[] visited; // 방문처리
	// 알파벳-65를 인덱스로 가지고 있는 원소를 true로 바꿔준다.

	// 델타(상하좌우)
	static int[] drow = { -1, 1, 0, 0 };
	static int[] dcol = { 0, 0, -1, 1 };

	// 최대값 구하기
	static int max;

	public static void solved(int row, int col, int count) {

		visited[map[row][col] - 65] = true; // 방문처리

		// 상하좌우로 인접한 칸 확인하기
		for (int i = 0; i < 4; i++) {
			int dr = row + drow[i];
			int dc = col + dcol[i];

			if (dr >= 0 && dr < r && dc >= 0 && dc < c && !visited[map[dr][dc] - 65]) {
				solved(dr, dc, count + 1);
				visited[map[dr][dc] - 65] = false;
			}
		}

		max = Math.max(max, count);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		r = sc.nextInt();
		c = sc.nextInt();

		map = new char[r][c];

		visited = new boolean[26]; // 해당 알파벳 방문 여부

		max = Integer.MIN_VALUE;

		for (int row = 0; row < r; row++) {
			String s = sc.next();
			for (int col = 0; col < c; col++) {
				map[row][col] = s.charAt(col);
			}
		}

		solved(0, 0, 1); // 실행함과 동시에 한 칸을 간 것이므로

		System.out.println(max);

	}

}