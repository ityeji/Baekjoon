
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[5];

		// 배열 저장
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		// 배열에 제곱수 한 값 다시 저장
		// 합도 구하자
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] *= arr[i];
			sum += arr[i];
		}

		int result = sum % 10;

		System.out.println(result);

	}

}
