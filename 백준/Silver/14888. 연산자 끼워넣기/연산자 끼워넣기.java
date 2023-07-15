import java.util.Scanner;

public class Main {

	// 백트래킹

	static int n;
	static int[] nums;
	static int[] opers = new int[4]; // 연산자 개수는 4개
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void DFS(int num, int idx) { // num은
		// 기저조건
		if (idx == n) {
			max = Integer.max(num, max);
			min = Integer.min(num, min);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (opers[i] > 0) {
				opers[i]--; // 연산자 숫자 하나 줄어든다.

				switch (i) {
				case 0:
					DFS(num + nums[idx], idx + 1);
					break;
				case 1:
					DFS(num - nums[idx], idx + 1);
					break;
				case 2:
					DFS(num * nums[idx], idx + 1);
					break;
				case 3:
					DFS(num / nums[idx], idx + 1);
					break;
				}

				// 연산자 숫자 하나 늘어난다. (복구해주기)
				opers[i]++;
			}
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		nums = new int[n];

		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}

		for (int i = 0; i < 4; i++) {
			opers[i] = sc.nextInt();
		}

		DFS(nums[0], 1);

		System.out.println(max);
		System.out.println(min);

	}

}