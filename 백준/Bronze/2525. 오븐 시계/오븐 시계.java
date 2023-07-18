import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		int tmp = 0;

		if (b + c >= 60) {
			int n = (b + c) / 60;
			a += n;
			tmp = (b + c) - (n * 60);
		} else {
			tmp = b + c;
		}

		if (a >= 24) {
			a -= 24;
		}

		System.out.println(a + " " + tmp);

	}

}