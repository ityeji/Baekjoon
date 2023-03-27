import java.util.Scanner;

public class Main {

	static int n; // 정수의 개수

	static int s; // 합이 s가 되는

	static int count; // 부분수열 개수

	static int[] nums; // n개의 정수 넣기

	static boolean[] sel; // 부분집합 방문 체크

	public static void powerset(int idx) {

		// 기저조건
		if (idx == n) {

			int sum = 0;

			boolean b = false; // 원소가 없다고 가정(공집합)

			for (int i = 0; i < idx; i++) {
				if (sel[i]) {
					sum += nums[i];
					b = true; // 원소가 있어요!
				}
			}

			if (b) { // 공집합일 때는 생각해주지 말자
				if (sum == s) {
					count++;
				}
			}

			return;
		}

		// 재귀조건
		sel[idx] = true;
		powerset(idx + 1);
		sel[idx] = false;
		powerset(idx + 1);

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		s = sc.nextInt();

		nums = new int[n];

		sel = new boolean[n];

		count = 0;

		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}

		powerset(0);

		System.out.println(count);

	}

}