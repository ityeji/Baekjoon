import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	static int n; // 부분집합으로 나타낼 숫자

	static boolean[] visited; // 방문처리

	static int[] nums; // 제시되는 수열

	static boolean[] counting; // 합이 나오면 해당 인덱스에 true주기 (크기는 100001)

	public static void input() {
		n = sc.nextInt();

		visited = new boolean[n];

		nums = new int[n];

		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}

		counting = new boolean[(100000 * 20) + 1];
	}

	public static void powerSet(int idx) {

		// 재귀를 부를 때는 basecase부터 작성해야지
		if (idx == n) {
			int sum = 0;

			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					sum += nums[i];
				}
			}

			counting[sum] = true; // 나온 적 있어욤

			return;
		}

		visited[idx] = true; // 나 고려해
		powerSet(idx + 1);
		visited[idx] = false; // 나 고려하지마
		powerSet(idx + 1);

	}

	public static void printResult() {
		int result = 0;

		for (int i = 0; i < counting.length; i++) {
			if (!counting[i]) {
				result = i;
				break;
			}
		}

		System.out.println(result);
	}

	public static void main(String[] args) {

		input();
		powerSet(0);
		printResult();

	}

}