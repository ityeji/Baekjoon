
import java.util.Scanner;

public class Main {

	public static int solve(int[] arr) {

		int milk = 0; // 현재 영학이가 있는 우윳집
		int count = 0; // 먹는 우유 개수
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == milk) {
				count++;
				milk++;
			}
			if (milk == 3) {
				milk = 0;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력받은 수만큼의 크기로 배열 만들기
		int[] arr = new int[sc.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println(solve(arr));

	}

}
