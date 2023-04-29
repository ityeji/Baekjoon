import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	// 미로찾기 하듯 찾으면 됨!
	// 나는 DFS로 풀거지롱

	static int n;
	static int m;
	static int[][] arr;
	static boolean[][] visited;
	static int result;
	static int max;
	static int[] drow = { -1, 1, 0, 0 };
	static int[] dcol = { 0, 0, -1, 1 };
	static Scanner sc = new Scanner(System.in);

	public static void input() {
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n + 1][m + 1];
		visited = new boolean[n + 1][m + 1];
		max = 0;

		int k = sc.nextInt();

		for (int i = 0; i < k; i++) {
			arr[sc.nextInt()][sc.nextInt()] = 1;
		}

	}

	public static void solved() {
		for (int row = 1; row < n + 1; row++) {
			for (int col = 1; col < m + 1; col++) {
				if (arr[row][col] == 1) {
					result = 0;
					DFS(row, col);
					max = Math.max(max, result);
				}
			}
		}

	}

	public static void DFS(int row, int col) {

		visited[row][col] = true; // 박문철2
		result++;

		for (int i = 0; i < 4; i++) {
			int dr = row + drow[i];
			int dc = col + dcol[i];

			if (dr >= 0 && dr < n + 1 && dc >= 0 && dc < m + 1 && !visited[dr][dc] && arr[dr][dc] == 1) {
				DFS(dr, dc);
			}
		}
	}

	public static void main(String[] args) {
		input();
		solved();
		System.out.println(max);
	}

}