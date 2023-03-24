import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	static StringBuilder sb = new StringBuilder();

	static int n; // n개의 자연수

	static int m; // m개 선택

	static int[] nums; // 번호 입력 받기

	static boolean[] check; // 방문 여부 결정

	static int[] result; // 수열 만들기

	public static void input() {

		n = sc.nextInt();

		m = sc.nextInt();

		nums = new int[n];

		check = new boolean[n];

		result = new int[m];

		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}

		// 정렬
		Arrays.sort(nums);

		solved(0, 0);

		System.out.println(sb);
	}

	public static void solved(int idx, int startIdx) {

		if (idx == m) {
			for (int i = 0; i < m; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = startIdx; i < n; i++) {
			result[idx] = nums[i];
			solved(idx + 1, i);
		}
	}

	public static void main(String[] args) {

		input();

	}

}