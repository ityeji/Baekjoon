import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int totalPrice = sc.nextInt();

		int loop = sc.nextInt();

		int sum = 0;

		for (int i = 0; i < loop; i++) {
			int price = sc.nextInt();
			int gae = sc.nextInt();

			sum += (price * gae);
		}

		if (totalPrice == sum) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

}