import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		int result = 0;

		// a, b, c 모든 변수가 다를 경우
		if (a != b && b != c && c != a) {
			if (a > b) {
				if (a > c) {
					result = a * 100;
				} else {
					result = c * 100;
				}
			} else {
				if (b > c) {
					result = b * 100;
				} else {
					result = c * 100;
				}
			}
		} else if (a == b && b == c && c == a) {
			// 세 변수가 다 같은 경우
			result = 10000 + a * 1000;
		} else {
			// 두 변수가 다 같은 경우
			if (a == b || a == c) {
				// a가 b혹은 c랑 같은 경우 (a가 2번 반복되는 경우)
				result = 1000 + a * 100;
			} else if (b == c || b == a) {
				// b가 2번 반복되는 경우
				result = 1000 + b * 100;
			} else {
				result = 1000 + c * 100;
			}
		}

		System.out.println(result);
	}

}