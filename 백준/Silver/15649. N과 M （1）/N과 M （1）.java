
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
		visit = new boolean[n + 1];
		arr = new int[m];
	}

	static void makeProgression(int cnt) { // cnt는 출력시 위치를 나타냄
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (visit[i]) {
				continue;
			}
			arr[cnt] = i; // 출력시 0번째자리에 i
			visit[i] = true; // 방문 했다고 체크
			makeProgression(cnt + 1);

			visit[i] = false;
		}
	}

	static void solve() {
		input();
		makeProgression(0);
	}

	public static void main(String[] args) {
		solve();

	}

}
