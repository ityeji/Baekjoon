
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num1 = sc.nextInt();
		int num2 = sc.nextInt();

		if (num1 > 0 && num2 < 10) {

			System.out.println((double)num1 / num2);
		}
	}

}
