
import java.util.Scanner;

public class Main {

	static int n;
	static int m;
	static int[] arr;
	static boolean[] visit;

	static void input() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		visit = new boolean[n + 1]; // 내가 해당 노드를 방문 했는지 안했는지?
		arr = new int[m]; // 숫자 쌓기
	}

	static void makeProgression(int start, int cnt) { // cnt는 출력시 위치를 나타냄
		// start는 출력될 숫자가 시작할 위치
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i <= n; i++) {
			if (visit[i]) {
				continue;
			}
			arr[cnt] = i; // 출력시 0번째자리에 i
			visit[i] = true; // 방문 했다고 체크
			makeProgression(i + 1, cnt + 1);

			visit[i] = false;
		}
	}

	static void solve() {
		input();
		makeProgression(1, 0);
	}

	public static void main(String[] args) {
		solve();

	}

}
