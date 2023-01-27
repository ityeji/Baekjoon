
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextLine();
		int cnt = 0;
		// 더한 값 배열에 저장해주기
		int[] sums = new int[n];

		while (cnt < n) {

			// 배열 생성

			// String으로 받기
			// 공백으로 나누어져 있지 않으면, 한 번에 String으로 받아 char배열로 저장시키자!
			String s = sc.nextLine();

			if (s.length() <= 0 && s.length() >= 80) {
				break;
			}

			// char배열로 변환해주기
			char[] arr = s.toCharArray();

			// 배열 탐색
			int score = 0; // 점수
			int sum = 0;

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == 'O') {
					if (score > 0) {
						score++;
					} else {
						score = 1;
					}
				} else {
					score = 0;
				}
				sum += score;
			}

			sums[cnt] = sum;
			cnt++;
		}
		if (sums != null) {
			// 결과값 출력
			for (int i : sums) {
				System.out.println(i);
			}
		}
	}

}
