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

		// Arrays.sort를 람다식으로 커스터마이징 해야함 (람다식 or 인터페이스)
		// 첫 파라미터 < 둘째 파라미터 -> return 음수
		// 첫 파라미터 == 둘째 파라미터 -> return 0
		// 첫 파라미터 > 둘째 파라미터 -> return 양수 --> 두 자리가 바뀐다
		Arrays.sort(arr, (arr_1, arr_2) -> {
			if (arr_1[0] == arr_2[0]) {
				return arr_1[1] - arr_2[1];
			} else {
				return arr_1[0] - arr_2[0];
			}
		});

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}