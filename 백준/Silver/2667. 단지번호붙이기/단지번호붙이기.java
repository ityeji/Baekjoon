import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// DFS로 풀자..
	// BFS는 나랑 안맞아

	static Scanner sc = new Scanner(System.in);
	static int n;
	static int count;
	static int[][] arr;
	static int danzi; // 총 단지 수
	static ArrayList<Integer> countArr; // 각 단지내 집의 수

	static boolean[][] visited; // 누적 길이를 저장할 배열 (BFS 들어가기 전 초기화 해야함)

	// 델타 (상하좌우)
	static int[] drow = { -1, 1, 0, 0 };
	static int[] dcol = { 0, 0, -1, 1 };

	public static void input() {
		n = sc.nextInt();
		arr = new int[n][n];
		danzi = 0;
		countArr = new ArrayList<>();
		visited = new boolean[n][n];

		for (int row = 0; row < n; row++) {
			String input = sc.next();
			for (int col = 0; col < n; col++) {
				arr[row][col] = input.charAt(col) - '0';
			}
		}
	}

	public static void solved() {
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				if (arr[row][col] == 1 && !visited[row][col]) {
					count = 0;
					DFS(row, col);
					danzi++;
					countArr.add(count);
				}
			}
		}
	}

	public static void DFS(int row, int col) {
		visited[row][col] = true;
		count++;

		for (int i = 0; i < 4; i++) {
			int dr = row + drow[i];
			int dc = col + dcol[i];

			if (dr >= 0 && dr < n && dc >= 0 && dc < n && arr[dr][dc] == 1 && !visited[dr][dc]) {
				DFS(dr, dc);
			}
		}
	}

	public static void main(String[] args) {

		input();

		solved();

		Collections.sort(countArr);

		System.out.println(danzi);
		for (int i : countArr) {
			System.out.println(i);
		}
	}

}