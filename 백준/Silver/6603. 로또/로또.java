import java.util.Scanner;

public class Main {

	// 조합으로 풀어야징
	// 조합 다시 공부하자!

	static Scanner sc = new Scanner(System.in);
	static int k; // k개의 수
	static int[] arr;
	static int[] result;

	public static void input() {
		while (true) {

			k = sc.nextInt();
			arr = new int[k];
			result = new int[6];

			for (int i = 0; i < k; i++) {
				arr[i] = sc.nextInt();
			}

			combination(0, 0);

			System.out.println();

			if (k == 0) {
				return;
			}
		}
	}

	public static void combination(int idx, int ridx) {
		// 기저조건
		if (ridx == 6) {
			for (int i = 0; i < 6; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}

		if (idx == k) {
			return;
		}

		// 재귀조건
		result[ridx] = arr[idx];
		combination(idx + 1, ridx + 1); // 고려했어!
		combination(idx + 1, ridx); // 고려 안했어!
	}

	public static void main(String[] args) {

		input();

	}

}