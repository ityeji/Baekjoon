
import java.util.Scanner;

public class Main {

	public static int fi(int n) {

		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fi(n - 1) + fi(n - 2);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(fi(sc.nextInt()));

	}

}
