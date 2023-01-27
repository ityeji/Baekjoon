
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		if (n <= 1000) {
			double[] arr = new double[n];

			// 점수 저장
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}

			double max = arr[0];

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > max) {
					max = arr[i];
				}
			}

			// 배열 요소 조작
			for (int i = 0; i < arr.length; i++) {
				arr[i] = (arr[i] / max) * 100;
			}


			// 평균 구하기
			double sum = 0;
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i];
			}

			System.out.println(sum / arr.length);

		}

	}

}
