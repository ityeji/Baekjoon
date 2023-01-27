
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[9];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		int max = arr[0];

		// max찾기
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		// max값 인덱스 찾기
		// 불필요한 메모리 방지 -> while문 사용
		int idx = 0;
		while (idx < arr.length) {
			if (arr[idx] == max) {
				break;
			}
			idx++;
		}

		System.out.println(max);
		System.out.println(idx + 1); // 인덱스는 -1이니까

	}

}
