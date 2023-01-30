
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		// 카드 내용 배열에 저장해서
		// while + 이중 for문으로 원소 하나하나 더해서
		// max값 갱신

		// 먼저 배열
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		// 먼저 max값 초기화 해주고,,,
		int max = 0; // 양의 정수만 나오므로, 못해도 0

		int sum = 0;

		// for문이 다 돌면서 더해줄동안 고정 인덱스
		int cnt = 0;

		while (cnt < arr.length - 2) {
			for (int i = 1; i + cnt < arr.length - 1; i++) { // i는 더할 요소 중 가운데 요소 인덱스
				// 그래서 i+cnt < arr.length-1
				for (int j = 1; j + i + cnt < arr.length; j++) {
					// j는 더할 요소 중 마지막 인덱스 -> 그래서 i+cnt+j < arr.length
					sum = arr[cnt] + arr[cnt + i] + arr[cnt + i + j];

					if ((sum > max) && (sum <= m)) { // max보다 sum이 더 크면 max를 갱신해주되,
						// max값은 m보다 작아야하므로, sum은 m보다 작거나 같다를 조건에 넣어줌
						max = sum;
					}
				}

			}
			cnt++;
		}
	
		System.out.println(max); // max값 출력

	}

}
