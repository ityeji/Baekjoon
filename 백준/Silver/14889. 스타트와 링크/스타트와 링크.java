import java.util.Scanner;

public class Main {

	static int n;
	static int[][] scores;
	static int min; // 차이의 최소값
	static boolean[] visited;

	public static void DFS(int cnt, int num) { // cnt는 내가 지금까지 몇 개 골랐는지, num은 어디부터 시작해야하는지
		// 기저조건
		if (cnt == n / 2) { // 0부터 시작이니까, cnt의 값이 n/2와 같아야함.
			// 다 골랐으니
			// 나머지 능력치 합친 것을 구하고
			// 차이를 구해서
			// 최솟값 갱신하자

			dif();
			return;
		}

		for (int i = num; i < n; i++) {
			// 한 명씩 돌아가면서 박문철2 해주고
			// 재귀 호출하기
			visited[i] = true;
			DFS(cnt + 1, i + 1);
			visited[i] = false; // 원상복구
		}

	}

	public static void dif() {
		int start = 0;
		int link = 0;

		for (int row = 0; row < n - 1; row++) {
			for (int col = row + 1; col < n; col++) {
				// 한번에 [row][col] + [col][row]할 것이므로, col을 굳이 0부터 시작 안해도 ok(row 다음부터 시작해도 ok)

				// start
				if (visited[row] == true && visited[col] == true) {
					// start이면 visited를 true로 바꿔줬으므로
					start += scores[row][col];
					start += scores[col][row];
				} else if (visited[row] == false && visited[col] == false) {
					link += scores[row][col];
					link += scores[col][row];
				}
			}
		}

		int val = Math.abs(start - link);

		if (val == 0) { // 차이가 0이면, 최소값이므로 굳이 min값 갱신해줄 필요 x
			min = val;
			return;
		}

		min = Math.min(min, val);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		scores = new int[n][n];
		visited = new boolean[n];

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				scores[row][col] = sc.nextInt();
			}
		}

		min = Integer.MAX_VALUE;

		DFS(0, 0);

		System.out.println(min);

	}

}