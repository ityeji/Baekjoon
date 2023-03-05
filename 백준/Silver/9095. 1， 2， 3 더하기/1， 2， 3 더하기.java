
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	static int n;

	static int[] arr = new int[11]; // 만약 n으로 2가 들어오면 인덱스 오류가 나니까 애초에 크게 배열 크기 잡아버리기

	public static void input() {
		n = sc.nextInt();

		solved();
	}

	public static void solved() {

		// 경우의 수를 구하는 것이므로
		// 경우의 수를 배열에 저장해주자
		// arr[1]= (1) arr[2]=(1+1) arr[3]=(1+1+1, 1+2, 2+1, 3)
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;

		for (int i = 4; i <= n; i++) {
			arr[i] = arr[i - 3] + arr[i - 2] + arr[i - 1];
			// if (n==4)
			// 1+1+1(3)+1 -> 3에다 +1한 형태
			// 1+1(2)+2 -> 2에다 +2한 형태
			// 1+2(3)+1 -> 3에다 +1한 형태
			// 2+1(3)+1 -> 3에다 +1한 형태
			// 2+2 -> 2에다 +2한 형태
			// 1+3 -> 1에다 +3한 형태
			// 3+1 -> 3에다 +1한 형태

			// 즉, 3에다 +1, 2에다 +2, 1에다 +3
			// 4-1, 4-2, 4-3
			// 그러나, n이 3일 때는 적용 안됨 -> 4이상부터! --> if로 조건 주기
		}

		System.out.println(arr[n]);

	}

	public static void main(String[] args) {
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			input();
		}

	}

}
