
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	static int n;

	public static void input() {
		n = sc.nextInt();

		solved();
	}

	public static void solved() {
		if (n == 4 || n == 7) {
			System.out.println(-1);
		} else if (n % 5 == 0) {
			System.out.println(n / 5);
		} else if (n % 5 == 1 || n % 5 == 3) {
			System.out.println((n / 5) + 1);
		} else if (n % 5 == 2 || n % 5 == 4) {
			System.out.println((n / 5) + 2);
		}
	}

	public static void main(String[] args) {

		input();

	}

}
