
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// 9명 중 7명의 합은 100
		// 다 더한 거에서 2명 거 빼면 100되겟네?

		Scanner sc = new Scanner(System.in);

		int[] arr = new int[9];

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}

		// 결과값 저장
		int[] result = new int[7];

		int idx1 = 0, idx2 = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == sum - 100) {
					idx1 = i;
					idx2 = j;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (i != idx1 && i != idx2) {
				System.out.println(arr[i]);
			}
		}

	}

}
