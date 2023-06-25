import java.util.Scanner;
import java.util.Stack;

public class Main {

	// 하노이탑도 공식이 있어...
	// 최소이동횟수 = 2 * (원판 개수 - 1개의 원판을 옮기는데 걸리는 횟수) + 1
	// 1. 1개의 원판을 옮기는데 걸리는 횟수 = 1회
	// 2. 2개의 원판을 옮기는데 걸리는 횟수 = 2*1+1 = 3회
	// 3. 3개의 원판을 옮기는데 걸리는 횟수 = 2*3+1 = 7회
	// 4. 4개의 원판을 옮기는데 걸리는 횟수 = 2*7+1 = 15회
	// 진행은 원판 (n-1)개를 옮기는데 걸리는 횟수 + 원판(n)을 옮기는 횟수(1번) + (n-1)개를 옮기는데 걸리는 횟수

	static int cnt;

	static StringBuilder sb = new StringBuilder();

	public static void print(int n, int start, int to) {
		// 이동 할 때마다 이동 방향 출력하고
		// cnt++
		cnt++;
		sb.append(start + " " + to + "\n");
	}

	public static void hanoi(int n, int start, int to, int v) {

		// n개의 원판을 돌릴 때 먼저 n-1개의 원판을 돌릴 때 횟수를 구해야하므로
		// 재귀를 써야함.
		// basecase
		if (n == 1) {
			print(n, start, to);
			return;
		}

		hanoi(n - 1, start, v, to); // n원판을 목적지(3)에 옮기기 전 n-1까지의 원판을 2에 옮겨놓기(그래야 가장 큰 원판 n을 3에 옮길 수 있음)
		print(n, start, to); // n이전의 원판들을 옮겼으니, n원판을 목적지에 가져다 놓자!
		hanoi(n - 1, v, to, start); // n원판을 목적지에 가져다놨으니, 미리 옮겨놨던 n-1까지의 원판들을 임시장소에서 목적지로 옮기기
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		cnt = 0; // 옮긴횟수

		hanoi(n, 1, 3, 2);

		System.out.println(cnt);
		System.out.println(sb);

	}

}