
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	static int n;

	static int result;

	public static void input() {
		n = sc.nextInt();
		solved();
	}

	public static void solved() {

		result = 1; // n은 무조건 1부터 시작이므로
		// 기본값으로 1을 넣어준다

		int i = 1;

		int sum = 1;

		while (sum < n) {
			sum += (i * 6);
			result++;
			i++;
		}

		System.out.println(result);

	}

	public static void main(String[] args) {

		input();

	}

}
