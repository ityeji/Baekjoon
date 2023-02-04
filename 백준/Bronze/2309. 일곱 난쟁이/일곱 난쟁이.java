
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[9];

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}

		int[] result = new int[7];

		int idx = 0; // result 인덱스

		int idx1 = 0, idx2 = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == sum - 100) {
					idx1 = i;
					idx2 = j;
				}
			}
		}

		// result에 정답 복사
		for (int i = 0; i < arr.length; i++) {
			if (i != idx1 && i != idx2) {
				result[idx] = arr[i];
				idx++;
			}
		}

		// 정렬
		Arrays.sort(result);

		// result 출력
		for (int i : result) {
			System.out.println(i);
		}

	}

}
