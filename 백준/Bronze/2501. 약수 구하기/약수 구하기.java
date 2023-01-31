
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		// 배열리스트에 약수 저장하기
		// 그리고 get 사용해서 답 추출하기

		int cnt = 0;

		for (int i = 1; i <= a; i++) {
			if (a % i == 0) {
				cnt++;
			}
		}
		int[] arr = new int[cnt];

		cnt = 0;

		for (int i = 1; i <= a; i++) {
			if (a % i == 0) {
				arr[cnt] = i;
				cnt++;
			}
		}

		if (cnt < b) {
			System.out.println(0);
		} else {
			System.out.println(arr[b - 1]);
		}
	}

}
