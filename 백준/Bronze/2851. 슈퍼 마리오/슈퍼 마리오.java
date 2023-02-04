
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 배열에 숫자 저장
		// 배열 돌려가며 더한 값이
		// 100보다 작거나 같을 때 값 픽스
		// 100보다 커지는 순간에 값 픽스
		// 두 수 비교 (100에서 값을 뺀 값의 절댓값이 작은 쪽 출력)
		// 같으면? 100보다 큰 값 출력

		Scanner sc = new Scanner(System.in);

		int[] arr = new int[10];

		for (int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt();
		}

		if (arr[0] != 0) { // 입력 받아지면

			int sum = 0; // 더한 값 저장할 변수

			// i값 픽스할 변수 저장
			int hap1 = 0;
			int hap2 = 0;

			x: for (int i = 0; i < 9; i++) {
				sum = 0; // i가 돌때마다 sum 초기화
				for (int j = 0; j <= i + 1; j++) {
					sum += arr[j];

					if (sum <= 100) {
						hap1 = sum; // 100보다 작을 때
					}
					if (sum >= 100) {
						hap2 = sum; // 100보다 클 때
						break x;
					}
				}

			}

			// 100과의 차이를 구하기 위해
			int cha = Math.abs(100 - hap2);

			if (hap1 == hap2) {
				System.out.println(hap1); // 둘이 같다는 소리는 즉, 100이라는 소리
			} else if ((100 - hap1) == cha || (100 - hap1) > cha) {
				System.out.println(hap2);
			} else {
				System.out.println(hap1);
			}

		}

	}
}
