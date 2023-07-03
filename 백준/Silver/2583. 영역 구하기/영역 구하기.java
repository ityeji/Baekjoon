import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	// DFS
	// 넓이를 오름차순으로 정렬하라고 하니까
	// Array에 넣어서! (몇개가 나올지 모르니, ArrayList로!)
	// arr.size()로 영역 개수 출력하고
	// arr를 오름차순으로 정렬해서 출력

	// 행: row 열: col
	static int[] drow = { -1, 1, 0, 0 }; // 상, 하, 좌, 우
	static int[] dcol = { 0, 0, -1, 1 };

	static int[][] map;
//	static boolean[][] visited;
	// 방문했으면 배열 원소를 1로 바꿔주면 되니까
	// 굳이 방문체크 배열 필요 없음!!

	static int count;
	static int m;
	static int n;

	static ArrayList<Integer> arr;

	public static void DFS(int row, int col) {
		map[row][col] = 1; // 방문체크 대신 1로 바꿔주기!
		count++;

		// 델타 배열 사용
		for (int i = 0; i < 4; i++) {
			int dr = row + drow[i];
			int dc = col + dcol[i];

			// 벽체크, 범위체크
			if (dr >= 0 && dr < m && dc >= 0 && dc < n) {
				if (map[dr][dc] == 0) {
					DFS(dr, dc);
				}
			}
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		m = sc.nextInt();
		n = sc.nextInt();
		int k = sc.nextInt();

		map = new int[m][n];
//		visited = new boolean[m][n];

		arr = new ArrayList<>();

		// 배열에 1 저장
		for (int i = 0; i < k; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			for (int row = y1; row < y2; row++) {
				for (int col = x1; col < x2; col++) {
					map[row][col] = 1;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0) {
					count = 0;
					DFS(i, j);
					// DFS가 끝나면, 넓이 arrayList에 저장하기
					// 여기서 넓이는 count
					arr.add(count);
				}
			}
		}

		System.out.println(arr.size());

		Collections.sort(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

}