import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		// 수열 저장할 배열 생성
		int[] arr = new int[n];

		int x = sc.nextInt();

		// 배열 저장
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		// 배열 탐색하면서 x보다 작은 수 출력
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < x) {
				System.out.print(arr[i] + " ");
			}
		}

	}
}