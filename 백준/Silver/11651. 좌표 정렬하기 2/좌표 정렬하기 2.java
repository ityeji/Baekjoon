import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[][] arr = new int[n][2];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		Arrays.sort(arr, (arr1, arr2) -> {
			if (arr1[1] == arr2[1]) { // Y좌표가 같다면? X좌표로 판단!
				return arr1[0] - arr2[0];
			} else {
				return arr1[1] - arr2[1];
			}
		});

		for (int[] nums : arr) {
			for (int num : nums) {
				System.out.print(num + " ");
			}
			System.out.println();
		}

	}

}