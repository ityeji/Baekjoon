import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	static StringBuilder sb = new StringBuilder();

	static int n;

	static int m;

	static int[] nums;

	static boolean[] check;

	static int[] result;

	public static void input() {

		n = sc.nextInt();

		m = sc.nextInt();

		nums = new int[n];

		check = new boolean[n];

		result = new int[m];

		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}

		Arrays.sort(nums);

		solved(0);

		System.out.println(sb);
	}

	public static void solved(int idx) {

		if (idx == m) {
			for (int i = 0; i < m; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}

		int before = 0;

		for (int i = 0; i < n; i++) {
			if (check[i]) {
				continue;
			}

			// 중복되는 수열을 여러번 출력하면 안됨.
			// 전에 뽑은 원소를 변수에 저장해서 비교해보자!
			if (before != nums[i]) {
				result[idx] = nums[i];
				check[i] = true;
				before = nums[i];
				solved(idx + 1);
				check[i] = false;
			}
		}
	}

	public static void main(String[] args) {

		input();

	}

}